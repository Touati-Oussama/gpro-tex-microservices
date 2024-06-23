/* tslint:disable */
/* eslint-disable */
import { FicheEclatement } from '../models/fiche-eclatement';
import { OrdreFabrication } from '../models/ordre-fabrication';
export interface Paquet {
  archived?: boolean;
  couleurId?: number;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  engagement?: boolean;
  entreeAssemblage?: boolean;
  entreeDevant?: boolean;
  entreeDos?: boolean;
  entreeFinition?: boolean;
  entreePreparation?: boolean;
  ficheEclatement?: FicheEclatement;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  num?: number;
  numMatelas?: string;
  numRouleaux?: string;
  ordreFabrication?: OrdreFabrication;
  productionHeure?: boolean;
  quantite?: number;
  retrait?: string;
  siteId?: number;
  sortieAssemblage?: boolean;
  sortieDevant?: boolean;
  sortieDos?: boolean;
  sortiePreparation?: boolean;
  tailleId?: number;
  version?: number;
}
