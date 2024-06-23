/* tslint:disable */
/* eslint-disable */
import { Produit } from '../models/produit';
import { Taille } from '../models/taille';
export interface MesureProduit {
  archived?: boolean;
  code?: string;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  id?: number;
  latestUpdaterId?: string;
  mesure?: number;
  modificationDate?: string;
  produit?: Produit;
  taille?: Taille;
  toleranceMoins?: number;
  tolerancePlus?: number;
  version?: number;
}
