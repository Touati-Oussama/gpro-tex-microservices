/* tslint:disable */
/* eslint-disable */
import { DocumentPiValue } from '../models/document-pi-value';
import { RepresentantValue } from '../models/representant-value';
export interface PartieInteresseValue {
  abreviation?: string;
  adresseLiv?: string;
  documents?: Array<DocumentPiValue>;
  id: number;
  matrFiscal?: string;
  modalitePaiement?: string;
  reference: string;
  representants?: Array<RepresentantValue>;
  siteId?: number;
}
