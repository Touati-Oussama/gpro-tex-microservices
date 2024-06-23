/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { FicheColisage } from '../../models/fiche-colisage';
import { FicheColisageValue } from '../../models/fiche-colisage-value';

export interface CreerFiche$Params {
      body: FicheColisageValue
}

export function creerFiche(http: HttpClient, rootUrl: string, params: CreerFiche$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheColisage>> {
  const rb = new RequestBuilder(rootUrl, creerFiche.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<FicheColisage>;
    })
  );
}

creerFiche.PATH = '/api/order/ficheColi/creerFiche';
