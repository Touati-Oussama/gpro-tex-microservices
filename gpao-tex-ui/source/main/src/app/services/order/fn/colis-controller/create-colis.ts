/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Colis } from '../../models/colis';
import { ColisValue } from '../../models/colis-value';

export interface CreateColis$Params {
      body: ColisValue
}

export function createColis(http: HttpClient, rootUrl: string, params: CreateColis$Params, context?: HttpContext): Observable<StrictHttpResponse<Colis>> {
  const rb = new RequestBuilder(rootUrl, createColis.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Colis>;
    })
  );
}

createColis.PATH = '/api/order/colis/creerChaine';
