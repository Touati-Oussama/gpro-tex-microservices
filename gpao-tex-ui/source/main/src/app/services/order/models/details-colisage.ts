/* tslint:disable */
/* eslint-disable */
import { FicheColisage } from '../models/fiche-colisage';
export interface DetailsColisage {
  archived?: boolean;
  choix?: string;
  code?: string;
  codeCouleur?: string;
  couleurDesignation?: string;
  couleurId?: number;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  ficheColisage?: FicheColisage;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  pcb?: number;
  poidsBrut?: number;
  poidsNet?: number;
  quantite?: number;
  quantiteDesignation?: string;
  quantiteRestante?: number;
  tailleDesignation?: string;
  tailleId?: number;
  tailles?: string;
  version?: number;
}
