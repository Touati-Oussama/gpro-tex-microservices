/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ProductionHeure } from '../../models/production-heure';
import { ProductionHeureValue } from '../../models/production-heure-value';

export interface CreateProdHeure$Params {
      body: ProductionHeureValue
}

export function createProdHeure(http: HttpClient, rootUrl: string, params: CreateProdHeure$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionHeure>> {
  const rb = new RequestBuilder(rootUrl, createProdHeure.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ProductionHeure>;
    })
  );
}

createProdHeure.PATH = '/api/production/prodHeure/createProdHeure';