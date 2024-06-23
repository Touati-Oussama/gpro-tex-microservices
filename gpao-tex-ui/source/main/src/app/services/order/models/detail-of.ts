/* tslint:disable */
/* eslint-disable */
import { OrdreFabrication } from '../models/ordre-fabrication';
export interface DetailOf {
  archived?: boolean;
  code?: string;
  codeCouleur?: string;
  couleurId?: number;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  dimension?: string;
  id?: number;
  latestUpdaterId?: string;
  lieuLivraison?: string;
  modificationDate?: string;
  ordre?: OrdreFabrication;
  pcb?: number;
  poidsBrut?: number;
  poidsNet?: number;
  tailleId?: number;
  typeOrdre?: string;
  ue?: string;
  version?: number;
}
