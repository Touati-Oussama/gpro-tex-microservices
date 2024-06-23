/* tslint:disable */
/* eslint-disable */
import { FamilleProduit } from '../models/famille-produit';
export interface SousFamilleProduit {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  designation?: string;
  familleProduit?: FamilleProduit;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  version?: number;
}
