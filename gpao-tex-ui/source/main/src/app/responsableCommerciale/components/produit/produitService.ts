import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {BehaviorSubject, Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Produit, ProduitValue} from 'app/services/product/models';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  constructor(private http: HttpClient) {
  }

  private backendUrl: string = 'http://localhost:4444/api/produit/pd';
  dataChange: BehaviorSubject<Produit[]> = new BehaviorSubject<Produit[]>(
    []
  );
  dialogData!: Produit;

  getDialogData() {
    return this.dialogData;
  }

  getAll(): Observable<Produit[]> {
    const token = localStorage.getItem('access_token');
    if (!token) {
      return throwError('No access token found');
    }
    const formattedToken = token.replace(/^"(.*)"$/, '$1');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${formattedToken}`);
    return this.http.get<Produit[]>(`${this.backendUrl}/find/all`, {headers})
      .pipe(
        catchError(this.handleError)
      );
  }

  findById(id: number): Observable<Produit> {
    const token = localStorage.getItem('access_token');
    if (!token) {
      return throwError('No access token found');
    }
    const formattedToken = token.replace(/^"(.*)"$/, '$1');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${formattedToken}`);
    return this.http.get<Produit>(`${this.backendUrl}/find/by/${id}`, {headers})
      .pipe(
        catchError(this.handleError)
      );
  }

  delete(id: number): Observable<void> {
    const token = localStorage.getItem('access_token');
    if (!token) {
      return throwError('No access token found');
    }
    const formattedToken = token.replace(/^"(.*)"$/, '$1');
    const headers = new HttpHeaders().set('Authorization', `Bearer ${formattedToken}`);
    return this.http.delete<void>(`${this.backendUrl}/delete/${id}`, {headers})
      .pipe(
        catchError(this.handleError)
      );
  }

  create(request: ProduitValue): Observable<Produit> {
    const token = localStorage.getItem('access_token');
    if (!token) {
      return throwError('No access token found');
    }
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token.replace(/^"(.*)"$/, '$1')}`,
      ContentType: 'application/json'
    });
    return this.http.post<any>(`${this.backendUrl}/createProduit`, request, {headers})
      .pipe(catchError(this.handleError));
  }

  updatePi(request: ProduitValue): Observable<Produit> {
    const token = localStorage.getItem('access_token');
    if (!token) {
      return throwError('No access token found');
    }
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token.replace(/^"(.*)"$/, '$1')}`,
      ContentType: 'application/json'
    });
    return this.http.put<Produit>(`${this.backendUrl}/updatePi`, request, {headers})
      .pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(() => new Error('Something went wrong. Please try again later.'));
  }
}
