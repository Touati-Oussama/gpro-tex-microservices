/* tslint:disable */
/* eslint-disable */
import { CouleurValue } from '../models/couleur-value';
import { ElementTraitementValue } from '../models/element-traitement-value';
import { MesureProduitValue } from '../models/mesure-produit-value';
import { PilotageEfficienceValue } from '../models/pilotage-efficience-value';
import { ProduitGoshippementValue } from '../models/produit-goshippement-value';
import { TailleValue } from '../models/taille-value';
export interface ProduitValue {
  cadence?: number;
  codeConception?: string;
  couleurs?: Array<CouleurValue>;
  designation?: string;
  elementTraitements?: Array<ElementTraitementValue>;
  etat?: string;
  ficheBesoin?: boolean;
  id?: number;
  ligneProduitId?: number;
  mesureProduits?: Array<MesureProduitValue>;
  partieInteresseId?: number;
  pilotageEfficiences?: Array<PilotageEfficienceValue>;
  prixMajore?: number;
  prixUnitaire?: number;
  produitGoShippements?: Array<ProduitGoshippementValue>;
  quantite?: number;
  reference?: string;
  sansCouleur?: boolean;
  sansTaille?: boolean;
  siteId?: number;
  sousFamilleProduitId?: number;
  tailles?: Array<TailleValue>;
}
