/* tslint:disable */
/* eslint-disable */
import { Produit } from '../models/produit';
import { Site } from '../models/site';
export interface PilotageEfficience {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  deletionDate?: string;
  efficienceJour1?: number;
  efficienceJour2?: number;
  efficienceJour3?: number;
  efficienceJour4?: number;
  efficienceJour5?: number;
  efficienceJour6?: number;
  efficienceJour7?: number;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  produit?: Produit;
  site?: Site;
  version?: number;
}
