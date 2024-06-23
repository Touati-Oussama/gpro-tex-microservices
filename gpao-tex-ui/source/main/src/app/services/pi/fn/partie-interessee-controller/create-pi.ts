/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PartieInteresse } from '../../models/partie-interesse';
import { PartieInteresseValue } from '../../models/partie-interesse-value';

export interface CreatePi$Params {
      body: PartieInteresseValue
}

export function createPi(http: HttpClient, rootUrl: string, params: CreatePi$Params, context?: HttpContext): Observable<StrictHttpResponse<PartieInteresse>> {
  const rb = new RequestBuilder(rootUrl, createPi.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PartieInteresse>;
    })
  );
}

createPi.PATH = '/api/operations/pi/creerPi';
