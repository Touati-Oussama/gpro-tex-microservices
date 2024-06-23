/* tslint:disable */
/* eslint-disable */
import { Document } from '../models/document';
import { Representant } from '../models/representant';
export interface PartieInteresse {
  abreviation?: string;
  adresseLiv?: string;
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  documents?: Array<Document>;
  id?: number;
  latestUpdaterId?: string;
  matrFiscal?: string;
  modalitePaiement?: string;
  modificationDate?: string;
  reference?: string;
  representants?: Array<Representant>;
  siteId?: number;
  version?: number;
}
