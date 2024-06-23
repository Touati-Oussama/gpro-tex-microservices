/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Taille } from '../../models/taille';
import { TailleValue } from '../../models/taille-value';

export interface CreateTaille$Params {
      body: TailleValue
}

export function createTaille(http: HttpClient, rootUrl: string, params: CreateTaille$Params, context?: HttpContext): Observable<StrictHttpResponse<Taille>> {
  const rb = new RequestBuilder(rootUrl, createTaille.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Taille>;
    })
  );
}

createTaille.PATH = '/api/produit/taille/createTaille';
