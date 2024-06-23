/* tslint:disable */
/* eslint-disable */
import { ProductionHeureDetailsValue } from '../models/production-heure-details-value';
export interface ProductionHeureValue {
  chaineId?: number;
  date?: string;
  elementPlanningId?: number;
  id?: number;
  observation?: string;
  ofId?: number;
  partieInterreseId?: number;
  periode?: string;
  productionHeureDetails?: Array<ProductionHeureDetailsValue>;
  produitId?: number;
  quantite?: number;
}
