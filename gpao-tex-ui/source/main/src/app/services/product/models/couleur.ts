/* tslint:disable */
/* eslint-disable */
import { Produit } from '../models/produit';
export interface Couleur {
  archived?: boolean;
  codeCouleur?: string;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  designation?: string;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  produit?: Produit;
  version?: number;
}
