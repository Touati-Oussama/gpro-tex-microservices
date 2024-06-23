/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Chaine } from '../../models/chaine';
import { ChaineValue } from '../../models/chaine-value';

export interface CreateChaine$Params {
      body: ChaineValue
}

export function createChaine(http: HttpClient, rootUrl: string, params: CreateChaine$Params, context?: HttpContext): Observable<StrictHttpResponse<Chaine>> {
  const rb = new RequestBuilder(rootUrl, createChaine.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Chaine>;
    })
  );
}

createChaine.PATH = '/api/order/chaine/creerChaine';
