/* tslint:disable */
/* eslint-disable */
import { ChaineValue } from '../models/chaine-value';
import { PaquetValue } from '../models/paquet-value';
export interface FicheEclatementValue {
  chaines?: Array<ChaineValue>;
  clientAbreviation?: string;
  codeConception?: string;
  dateLancement?: string;
  id?: number;
  nombrePaquet?: number;
  observations?: string;
  ordreId?: number;
  paquets?: Array<PaquetValue>;
  produitId?: number;
  quantiteEclate?: number;
}
