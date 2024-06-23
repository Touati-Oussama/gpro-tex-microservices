/* tslint:disable */
/* eslint-disable */
import { FicheColisage } from '../models/fiche-colisage';
import { OrdreFabrication } from '../models/ordre-fabrication';
export interface Colis {
  archived?: boolean;
  couleurId?: number;
  creationDate?: string;
  creatorIdentifier?: string;
  dateLancementA?: string;
  dateLancementDe?: string;
  dateSortie?: string;
  deletionDate?: string;
  ficheColisage?: FicheColisage;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  ordre?: OrdreFabrication;
  palette?: string;
  poidsBrut?: number;
  poidsNet?: number;
  produitId?: number;
  quantite?: number;
  siteId?: number;
  tailleId?: number;
  tailles?: string;
  version?: number;
}
