package com.gpro.consulting.ordre.service;


import com.gpro.consulting.ordre.client.CouleurClient;
import com.gpro.consulting.ordre.client.PiClient;
import com.gpro.consulting.ordre.client.ProduitClient;
import com.gpro.consulting.ordre.client.TailleClient;
import com.gpro.consulting.ordre.dto.*;
import com.gpro.consulting.ordre.mapper.OrdreFabricationMapper;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import com.gpro.consulting.ordre.repository.OrdreFabricationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class OrdreFabricationService {

    private final OrdreFabricationRepository repository;
    private final ProduitClient produitClient;
    private final CouleurClient couleurClient;
    private final TailleClient tailleClient;
    private final PiClient piClient;
    private final EntityManager entityManager;
    private final OrdreFabricationMapper mapper;

    public String createOf(OrdreFabricationValue ordreFabrication) {
        Optional<PartieInteresseValue> pi = piClient.findPiById(ordreFabrication.getPartieInterresId());
        Optional<ProduitValue> produit = produitClient.findProduitById(ordreFabrication.getProduitId());
        initOrdreFabrication(ordreFabrication);
        ordreFabrication.setType(ordreFabrication.getType().isEmpty() ? "Ferme" : ordreFabrication.getType());
        if (pi.isPresent()) {
            ordreFabrication.setPartieInterresId(ordreFabrication.getPartieInterresId());
        }
        if (produit.isPresent()) {
            ordreFabrication.setProduitId(ordreFabrication.getPartieInterresId());
        }
        long totalQuantity = 0L;
        long nombreColisTotal = 0L;
        if (ordreFabrication.getDetailOfs() != null && !ordreFabrication.getDetailOfs().isEmpty()) {
            for (DetailOfValue detailOf : ordreFabrication.getDetailOfs()) {
                if (detailOf.getQuantite() != null) {
                    totalQuantity += detailOf.getQuantite();
                    if (detailOf.getPcb() != 0) {
                        nombreColisTotal += detailOf.getQuantite() / detailOf.getPcb();
                    }
                    detailOf.setQtePreteCoupe(0L);
                    detailOf.setQteRecuCoupe(0L);
                    detailOf.setQtePriseCoupe(0L);
                    detailOf.setQtePriseProd(0L);
                    detailOf.setQteRecueProd(0L);
                    detailOf.setQteProduite(0L);
                    detailOf.setQuantite(totalQuantity);
                }
            }
        }
        ordreFabrication.setQuantite(totalQuantity);
        ordreFabrication.setQuantiteDetailOrdres(totalQuantity);
        ordreFabrication.setNombreColis(nombreColisTotal);
        var of = mapper.toOrdreFabrication(ordreFabrication);
        return repository.save(of).getId().toString();
    }

    private void initOrdreFabrication(OrdreFabricationValue ordreFabrication) {
        ordreFabrication.setModifierQtSortieManuel(false);
        ordreFabrication.setSplit(false);
        ordreFabrication.setMajQteOfAvecImportation(false);
        ordreFabrication.setStatusPlanning("Non Plannifié");
        ordreFabrication.setInspection("NON");
        ordreFabrication.setImplantation("NON");
        ordreFabrication.setQtePreteCoupe(0L);
        ordreFabrication.setQtePriseCoupe(0L);
        ordreFabrication.setQtePriseProd(0L);
        ordreFabrication.setQteRecuCoupe(0L);
        ordreFabrication.setQteRecueProd(0L);
    }

    public OrdreFabricationValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromOrdreFabrication)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No of found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<OrdreFabricationValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromOrdreFabrication)
                .collect(Collectors.toList());
    }

    public List<CouleurValue> listeCouleurOf(Long ofId) {
        OrdreFabricationValue ordreFabrication = findById(ofId);
        if (ordreFabrication == null) {
            return Collections.emptyList();
        }
        List<Long> listIdUsed = new ArrayList<>();
        for (DetailOfValue detailOf : ordreFabrication.getDetailOfs()) {
            Long couleurId = detailOf.getCouleurId();
            if (couleurId != null) {
                listIdUsed.add(couleurId);
            }
        }
        return couleurClient.getAllInList(listIdUsed);
    }

    public List<CouleurValue> listeTailleOf(Long ofId) {
        OrdreFabricationValue ordreFabrication = findById(ofId);
        if (ordreFabrication == null) {
            return Collections.emptyList();
        }
        List<Long> listIdUsed = new ArrayList<>();
        for (DetailOfValue detailOf : ordreFabrication.getDetailOfs()) {
            Long tailleId = detailOf.getTailleId();
            if (tailleId != null) {
                listIdUsed.add(tailleId);
            }
        }
        return tailleClient.getAllInList(listIdUsed);
    }

    public List<OrdreFabricationValue> rechercheOfMulticritere(OrdreFabricationValue request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrdreFabrication> cq = cb.createQuery(OrdreFabrication.class);
        Root<OrdreFabrication> root = cq.from(OrdreFabrication.class);
        List<Predicate> predicates = new ArrayList<>();
        buildCriteria(request, root, predicates, cb);
        cq.select(root).where(predicates.toArray(new Predicate[0])).orderBy(cb.desc(root.get("id")));
        TypedQuery<OrdreFabrication> query = this.entityManager.createQuery(cq);
        List<OrdreFabrication> entities = query.getResultList();
        return mapper.fromOfList(entities);
    }

    private void buildCriteria(OrdreFabricationValue request, Root<OrdreFabrication> root, List<Predicate> whereClause, CriteriaBuilder cb) {
        if (request.getPartieInterresId() != null) {
            whereClause.add(cb.equal(root.get("partieInterresId"), request.getPartieInterresId()));
        }
        if (request.getProduitId() != null) {
            whereClause.add(cb.equal(root.get("produitId"), request.getPriorite()));
        }
        if (request.getQuantite() != null) {
            whereClause.add(cb.equal(root.get("quantite"), request.getQuantite()));
        }
        if (request.getType() != null) {
            whereClause.add(cb.equal(root.get("type"), request.getType()));
        }
        if (request.getDateDebut() != null) {
            whereClause.add(cb.equal(root.get("dateDebut"), request.getDateDebut()));
        }
        if (request.getDateFin() != null) {
            whereClause.add(cb.equal(root.get("dateFin"), request.getDateFin()));
        }
        if (request.getPriorite() != null) {
            whereClause.add(cb.equal(root.get("priorite"), request.getPriorite()));
        }
        if (request.getStatus() != null) {
            whereClause.add(cb.equal(root.get("status"), request.getStatus()));
        }
        if (request.getInformationsStock() != null) {
            whereClause.add(cb.equal(root.get("infomrationStock"), request.getInformationsStock()));
        }
        if (request.getStatusPlanning() != null) {
            whereClause.add(cb.equal(root.get("statusPlanning"), request.getStatusPlanning()));
        }
        if (request.getInspection() != null) {
            whereClause.add(cb.equal(root.get("inspection"), request.getInspection()));
        }
        if (request.getImplantation() != null) {
            whereClause.add(cb.equal(root.get("implantation"), request.getImplantation()));
        }
        if (request.getQuantiteDetailOrdres() != null) {
            whereClause.add(cb.equal(root.get("quantiteDetailOrdres"), request.getQuantiteDetailOrdres()));
        }
        if (request.getNombreColis() != null) {
            whereClause.add(cb.equal(root.get("nombreColis"), request.getNombreColis()));
        }

    }
}