/* tslint:disable */
/* eslint-disable */
import { PartieInteresse } from '../models/partie-interesse';
export interface Representant {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  email?: string;
  fax?: string;
  fonction?: string;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  nom?: string;
  partieInteresse?: PartieInteresse;
  telephone?: string;
  version?: number;
}
