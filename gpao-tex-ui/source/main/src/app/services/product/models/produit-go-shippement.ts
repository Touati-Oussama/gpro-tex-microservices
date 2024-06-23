/* tslint:disable */
/* eslint-disable */
import { Produit } from '../models/produit';
import { Site } from '../models/site';
export interface ProduitGoShippement {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  goShippement?: string;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  produit?: Produit;
  saison?: string;
  site?: Site;
  version?: number;
}
