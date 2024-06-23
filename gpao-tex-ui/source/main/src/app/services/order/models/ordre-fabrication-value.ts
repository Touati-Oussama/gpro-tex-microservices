/* tslint:disable */
/* eslint-disable */
import { DetailOfValue } from '../models/detail-of-value';
export interface OrdreFabricationValue {
  chaineId?: number;
  dateDebut?: string;
  dateFin?: string;
  detailOfValues?: Array<DetailOfValue>;
  id?: number;
  informationsStock?: string;
  priorite?: string;
  produitId?: number;
  qtColisage?: number;
  qtCoupe?: number;
  qtEngagement?: number;
  qtExpedition?: number;
  qtFinition?: number;
  qtSortie?: number;
  qteEntreeAssemblage?: number;
  qteEntreeFinition?: number;
  qteEntreePreparation?: number;
  qtePriseCoupe?: number;
  qtePriseProd?: number;
  qteRecuCoupe?: number;
  qteRecueProd?: number;
  qteSortieAssemblage?: number;
  qteSortiePreparation?: number;
  quantite?: number;
  status?: string;
}
