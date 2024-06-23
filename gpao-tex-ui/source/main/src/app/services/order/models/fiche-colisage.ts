/* tslint:disable */
/* eslint-disable */
import { Colis } from '../models/colis';
import { DetailsColisage } from '../models/details-colisage';
import { OrdreFabrication } from '../models/ordre-fabrication';
export interface FicheColisage {
  archived?: boolean;
  clientAbreviation?: string;
  clientId?: number;
  clientReference?: string;
  colis?: Array<Colis>;
  couleur?: string;
  creationDate?: string;
  creatorIdentifier?: string;
  dateA?: string;
  dateDe?: string;
  deletionDate?: string;
  detailsColisages?: Array<DetailsColisage>;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  nombreColis?: number;
  numeroInterne?: string;
  numeroOf?: string;
  observations?: string;
  ordre?: OrdreFabrication;
  produitDesignationInfo1?: string;
  produitId?: number;
  quantiteColis?: number;
  quantiteTotale?: number;
  version?: number;
}
