/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ProductionJour } from '../../models/production-jour';
import { ProductionJourValue } from '../../models/production-jour-value';

export interface CreateProdJour$Params {
      body: ProductionJourValue
}

export function createProdJour(http: HttpClient, rootUrl: string, params: CreateProdJour$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionJour>> {
  const rb = new RequestBuilder(rootUrl, createProdJour.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ProductionJour>;
    })
  );
}

createProdJour.PATH = '/api/production/prodJour/createProdJour';
