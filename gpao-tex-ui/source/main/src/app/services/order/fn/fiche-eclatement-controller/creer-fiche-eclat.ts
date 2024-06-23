/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { FicheEclatement } from '../../models/fiche-eclatement';
import { FicheEclatementValue } from '../../models/fiche-eclatement-value';

export interface CreerFicheEclat$Params {
      body: FicheEclatementValue
}

export function creerFicheEclat(http: HttpClient, rootUrl: string, params: CreerFicheEclat$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheEclatement>> {
  const rb = new RequestBuilder(rootUrl, creerFicheEclat.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<FicheEclatement>;
    })
  );
}

creerFicheEclat.PATH = '/api/order/ficheEclat/creerFicheEclat';
