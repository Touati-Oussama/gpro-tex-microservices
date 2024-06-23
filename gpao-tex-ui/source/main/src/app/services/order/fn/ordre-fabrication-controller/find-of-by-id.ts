/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { OrdreFabricationValue } from '../../models/ordre-fabrication-value';

export interface FindOfById$Params {
  id: number;
}

export function findOfById(http: HttpClient, rootUrl: string, params: FindOfById$Params, context?: HttpContext): Observable<StrictHttpResponse<OrdreFabricationValue>> {
  const rb = new RequestBuilder(rootUrl, findOfById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<OrdreFabricationValue>;
    })
  );
}

findOfById.PATH = '/api/order/of/find/by/{id}';
