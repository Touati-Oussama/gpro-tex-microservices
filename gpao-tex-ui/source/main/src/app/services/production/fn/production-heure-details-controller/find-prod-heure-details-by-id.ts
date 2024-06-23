/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ProductionHeureDetailsValue } from '../../models/production-heure-details-value';

export interface FindProdHeureDetailsById$Params {
  id: number;
}

export function findProdHeureDetailsById(http: HttpClient, rootUrl: string, params: FindProdHeureDetailsById$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionHeureDetailsValue>> {
  const rb = new RequestBuilder(rootUrl, findProdHeureDetailsById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ProductionHeureDetailsValue>;
    })
  );
}

findProdHeureDetailsById.PATH = '/api/production/prodHeureDetails/find/by/{id}';
