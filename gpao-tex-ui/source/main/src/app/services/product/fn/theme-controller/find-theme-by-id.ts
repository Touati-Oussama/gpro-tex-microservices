/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ThemeValue } from '../../models/theme-value';

export interface FindThemeById$Params {
  id: number;
}

export function findThemeById(http: HttpClient, rootUrl: string, params: FindThemeById$Params, context?: HttpContext): Observable<StrictHttpResponse<ThemeValue>> {
  const rb = new RequestBuilder(rootUrl, findThemeById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ThemeValue>;
    })
  );
}

findThemeById.PATH = '/api/produit/theme/find/by/{id}';
