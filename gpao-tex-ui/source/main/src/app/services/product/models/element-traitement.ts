/* tslint:disable */
/* eslint-disable */
import { Produit } from '../models/produit';
export interface ElementTraitement {
  archived?: boolean;
  code?: string;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  dimension?: string;
  id?: number;
  latestUpdaterId?: string;
  machineId?: number;
  mesure?: number;
  modificationDate?: string;
  nature?: string;
  observation?: string;
  produit?: Produit;
  toleranceMoins?: number;
  tolerancePlus?: number;
  version?: number;
}
