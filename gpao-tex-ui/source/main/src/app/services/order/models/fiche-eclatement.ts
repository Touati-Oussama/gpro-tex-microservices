/* tslint:disable */
/* eslint-disable */
import { Chaine } from '../models/chaine';
import { OrdreFabrication } from '../models/ordre-fabrication';
import { Paquet } from '../models/paquet';
export interface FicheEclatement {
  archived?: boolean;
  chaines?: Array<Chaine>;
  clientAbreviation?: string;
  codeConception?: string;
  creationDate?: string;
  creatorIdentifier?: string;
  dateLancement?: string;
  deletionDate?: string;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  nombrePaquet?: number;
  observations?: string;
  ordreFabrication?: OrdreFabrication;
  paquets?: Array<Paquet>;
  produitId?: number;
  quantiteEclate?: number;
  version?: number;
}
