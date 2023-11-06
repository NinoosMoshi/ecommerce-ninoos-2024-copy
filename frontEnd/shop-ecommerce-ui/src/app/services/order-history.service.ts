import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { OrderHistory } from '../common/order-history';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OrderHistoryService {

  private orderUrl = 'http://localhost:8080/api/v1/orders';

  constructor(private http:HttpClient) { }


  // http://localhost:8080/api/v1/orders/search?email=<customerEmail>&page=0&size=5
  getOrderHistory(customerEmail:string, page:number, size:number): Observable<GetResponseOrderHistory>{
    const searchUrl = `${this.orderUrl}/search?email=${customerEmail}&page=${page}&size=${size}`;
    return this.http.get<GetResponseOrderHistory>(searchUrl).pipe(
      map(response => response)
    );
  }


}


interface GetResponseOrderHistory{
  content: OrderHistory[],
  totalPages: number,
  totalElements: number,
  size: number,
  number: number
}
