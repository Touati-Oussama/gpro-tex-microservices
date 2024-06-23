/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PartieInteresseValue } from '../../models/partie-interesse-value';

export interface GetAbbreviationClient$Params {
  id: number;
}

export function getAbbreviationClient(http: HttpClient, rootUrl: string, params: GetAbbreviationClient$Params, context?: HttpContext): Observable<StrictHttpResponse<PartieInteresseValue>> {
  const rb = new RequestBuilder(rootUrl, getAbbreviationClient.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PartieInteresseValue>;
    })
  );
}

getAbbreviationClient.PATH = '/api/operations/pi/AbreviationClient/{id}';
