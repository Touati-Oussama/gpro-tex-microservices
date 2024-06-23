/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PilotageEfficience } from '../../models/pilotage-efficience';
import { PilotageEfficienceValue } from '../../models/pilotage-efficience-value';

export interface CreatePilotageEfficience$Params {
      body: PilotageEfficienceValue
}

export function createPilotageEfficience(http: HttpClient, rootUrl: string, params: CreatePilotageEfficience$Params, context?: HttpContext): Observable<StrictHttpResponse<PilotageEfficience>> {
  const rb = new RequestBuilder(rootUrl, createPilotageEfficience.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PilotageEfficience>;
    })
  );
}

createPilotageEfficience.PATH = '/api/produit/pilotage/createPilotageEfficience';
