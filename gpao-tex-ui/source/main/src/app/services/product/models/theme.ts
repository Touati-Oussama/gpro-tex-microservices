/* tslint:disable */
/* eslint-disable */
import { Produit } from '../models/produit';
export interface Theme {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  designation?: string;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  produit?: Produit;
  spl?: string;
  version?: number;
}
