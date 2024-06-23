/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Paquet } from '../../models/paquet';
import { PaquetValue } from '../../models/paquet-value';

export interface CreerPaquet$Params {
      body: PaquetValue
}

export function creerPaquet(http: HttpClient, rootUrl: string, params: CreerPaquet$Params, context?: HttpContext): Observable<StrictHttpResponse<Paquet>> {
  const rb = new RequestBuilder(rootUrl, creerPaquet.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Paquet>;
    })
  );
}

creerPaquet.PATH = '/api/order/paquet/creerPaquet';
