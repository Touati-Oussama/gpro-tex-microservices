/* tslint:disable */
/* eslint-disable */
import { Theme } from '../models/theme';
export interface LigneProduit {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  designation?: string;
  finA?: string;
  finDe?: string;
  fournisseur?: number;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  theme?: Theme;
  version?: number;
}
