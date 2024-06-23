/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { CouleurValue } from '../../models/couleur-value';

export interface FindCouleurById$Params {
  id: number;
}

export function findCouleurById(http: HttpClient, rootUrl: string, params: FindCouleurById$Params, context?: HttpContext): Observable<StrictHttpResponse<CouleurValue>> {
  const rb = new RequestBuilder(rootUrl, findCouleurById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<CouleurValue>;
    })
  );
}

findCouleurById.PATH = '/api/produit/couleur/find/by/{id}';
