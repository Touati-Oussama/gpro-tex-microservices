/* tslint:disable */
/* eslint-disable */
import { PartieInteresse } from '../models/partie-interesse';
export interface Document {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  partieInteresse?: PartieInteresse;
  path?: string;
  uidDocument?: string;
  version?: number;
}
