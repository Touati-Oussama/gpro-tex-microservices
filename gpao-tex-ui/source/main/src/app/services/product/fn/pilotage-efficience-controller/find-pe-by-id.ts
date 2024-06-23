/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PilotageEfficienceValue } from '../../models/pilotage-efficience-value';

export interface FindPeById$Params {
  id: number;
}

export function findPeById(http: HttpClient, rootUrl: string, params: FindPeById$Params, context?: HttpContext): Observable<StrictHttpResponse<PilotageEfficienceValue>> {
  const rb = new RequestBuilder(rootUrl, findPeById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PilotageEfficienceValue>;
    })
  );
}

findPeById.PATH = '/api/produit/pilotage/find/by/{id}';
