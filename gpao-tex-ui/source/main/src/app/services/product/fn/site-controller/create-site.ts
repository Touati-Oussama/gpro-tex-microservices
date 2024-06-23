/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Site } from '../../models/site';
import { SiteValue } from '../../models/site-value';

export interface CreateSite$Params {
      body: SiteValue
}

export function createSite(http: HttpClient, rootUrl: string, params: CreateSite$Params, context?: HttpContext): Observable<StrictHttpResponse<Site>> {
  const rb = new RequestBuilder(rootUrl, createSite.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Site>;
    })
  );
}

createSite.PATH = '/api/produit/site/createSite';
