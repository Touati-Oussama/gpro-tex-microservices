/* tslint:disable */
/* eslint-disable */
import { Chaine } from '../models/chaine';
import { DetailOf } from '../models/detail-of';
export interface OrdreFabrication {
  archived?: boolean;
  chaine?: Chaine;
  creationDate?: string;
  creatorIdentifier?: string;
  dateDebut?: string;
  dateFin?: string;
  deletionDate?: string;
  detailOfs?: Array<DetailOf>;
  id?: number;
  informationsStock?: string;
  latestUpdaterId?: string;
  modificationDate?: string;
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
  version?: number;
}
