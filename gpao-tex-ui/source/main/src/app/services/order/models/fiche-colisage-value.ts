/* tslint:disable */
/* eslint-disable */
import { ColisValue } from '../models/colis-value';
import { DetailsColisageValue } from '../models/details-colisage-value';
export interface FicheColisageValue {
  clientAbreviation?: string;
  clientId?: number;
  clientReference?: string;
  colis?: Array<ColisValue>;
  couleur?: string;
  dateA?: string;
  dateDe?: string;
  detailsColisages?: Array<DetailsColisageValue>;
  id?: number;
  nombreColis?: number;
  numeroInterne?: string;
  numeroOf?: string;
  observations?: string;
  orderId?: number;
  produitDesignationInfo1?: string;
  produitId?: number;
  quantiteColis?: number;
  quantiteTotale?: number;
}
