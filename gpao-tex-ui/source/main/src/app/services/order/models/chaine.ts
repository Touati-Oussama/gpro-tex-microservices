/* tslint:disable */
/* eslint-disable */
import { FicheEclatement } from '../models/fiche-eclatement';
import { OrdreFabrication } from '../models/ordre-fabrication';
export interface Chaine {
  archived?: boolean;
  creationDate?: string;
  creatorIdentifier?: string;
  dateLibre?: string;
  defaut1?: string;
  deletionDate?: string;
  designation?: string;
  designationClient?: string;
  developpement?: boolean;
  ficheEclatement?: FicheEclatement;
  id?: number;
  latestUpdaterId?: string;
  modificationDate?: string;
  nbDefaut1?: number;
  ordre?: OrdreFabrication;
  planning?: boolean;
  posteQualite1?: string;
  production?: boolean;
  siteId?: number;
  version?: number;
}
