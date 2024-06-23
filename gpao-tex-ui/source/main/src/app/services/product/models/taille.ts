/* tslint:disable */
/* eslint-disable */
import { Produit } from '../models/produit';
export interface Taille {
  archived?: boolean;
  code?: string;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  designation?: string;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  ordre?: number;
  produit?: Produit;
  version?: number;
}
