/* tslint:disable */
/* eslint-disable */
import { ProductionHeure } from '../models/production-heure';
export interface ProductionHeureDetails {
  archived?: boolean;
  colisId?: number;
  complement?: boolean;
  couleurId?: number;
  creationDate?: string;
  creatorIdentifier?: string;
  date?: string;
  deletionDate?: string;
  detailsId?: number;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  nature?: string;
  nbreColis?: number;
  numMatelasPaquet?: string;
  numPaquet?: number;
  observations?: string;
  operation?: string;
  ordrePaquet?: number;
  paquetId?: number;
  productionHeure?: ProductionHeure;
  qteDeuxiemeChoix?: number;
  qteFinie?: number;
  qteNonEmballe?: number;
  qteRetouche?: number;
  quantite?: number;
  tailleId?: number;
  version?: number;
}
