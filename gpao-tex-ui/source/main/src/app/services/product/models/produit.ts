/* tslint:disable */
/* eslint-disable */
import { Couleur } from '../models/couleur';
import { ElementTraitement } from '../models/element-traitement';
import { LigneProduit } from '../models/ligne-produit';
import { MesureProduit } from '../models/mesure-produit';
import { PilotageEfficience } from '../models/pilotage-efficience';
import { ProduitGoShippement } from '../models/produit-go-shippement';
import { Site } from '../models/site';
import { SousFamilleProduit } from '../models/sous-famille-produit';
import { Taille } from '../models/taille';
export interface Produit {
  archived?: boolean;
  cadence?: number;
  codeConception?: string;
  couleurs?: Array<Couleur>;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  designation?: string;
  elementTraitements?: Array<ElementTraitement>;
  etat?: string;
  ficheBesoin?: boolean;
  id?: number;
  latestUpdaterId?: string;
  ligneProduit?: LigneProduit;
  mesureProduits?: Array<MesureProduit>;
  modificationDate?: string;
  partieInteresseId?: number;
  pilotageEfficiences?: Array<PilotageEfficience>;
  prixMajore?: number;
  prixUnitaire?: number;
  produitGoShippements?: Array<ProduitGoShippement>;
  quantite?: number;
  reference?: string;
  sansCouleur?: boolean;
  sansTaille?: boolean;
  site?: Site;
  sousFamilleProduit?: SousFamilleProduit;
  tailles?: Array<Taille>;
  version?: number;
}
