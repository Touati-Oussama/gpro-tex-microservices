/* tslint:disable */
/* eslint-disable */
import { ProductionHeureDetails } from '../models/production-heure-details';
export interface ProductionHeure {
  archived?: boolean;
  chaineId?: number;
  creationDate?: string;
  creatorIdentifier?: string;
  date?: string;
  deletionDate?: string;
  elementPlanningId?: number;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  observation?: string;
  ofId?: number;
  partieInterreseId?: number;
  periode?: string;
  productionHeureDetails?: Array<ProductionHeureDetails>;
  produitId?: number;
  quantite?: number;
  version?: number;
}
