/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { SiteValue } from '../../models/site-value';

export interface FindSiteById$Params {
  id: number;
}

export function findSiteById(http: HttpClient, rootUrl: string, params: FindSiteById$Params, context?: HttpContext): Observable<StrictHttpResponse<SiteValue>> {
  const rb = new RequestBuilder(rootUrl, findSiteById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<SiteValue>;
    })
  );
}

findSiteById.PATH = '/api/produit/site/find/by/{id}';
