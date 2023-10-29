import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Category } from '../common/category';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/v1/products';

  private categoryUrl = 'http://localhost:8080/api/v1/categories';

  constructor(private http:HttpClient) { }


   // http://localhost:8080/api/v1/products?id=1
  // getProductList(theCategoryId:number):Observable<Product[]>{
  //    const searchUrl = `${this.baseUrl}?id=${theCategoryId}`
  //    return this.http.get<GetResponseProduct>(searchUrl).pipe(
  //     map(response => response.content)
  //    )
  // }


  // http://localhost:8080/api/v1/products/search?name=<productName>
  // searchProducts(keyword:string):Observable<Product[]>{
  //   return this.http.get<GetResponseProduct>(`${this.baseUrl}/search?name=${keyword}`).pipe(
  //     map(response => response.content)
  //   )
  // }


  // http://localhost:8080/api/v1/products?id=1&page=0&size=5
  getProductListPaginate(theCategoryId:number,page:number, size:number):Observable<GetResponseProduct>{
    const searchUrl = `${this.baseUrl}?id=${theCategoryId}&page=${page}&size=${size}`;
    return this.http.get<GetResponseProduct>(searchUrl).pipe(
      map(response => response)
    );
 }


 // http://localhost:8080/api/v1/products/search?name=<productName>&page=0&size=5
 searchProductsPaginate(keyword:string, page:number, size:number):Observable<GetResponseProduct>{
  return this.http.get<GetResponseProduct>(`${this.baseUrl}/search?name=${keyword}&page=${page}&size=${size}`).pipe(
    map(response => response)
  )
}



  getCategories():Observable<Category[]>{
     return this.http.get<GetResponseCategory>(`${this.categoryUrl}/get-all`).pipe(
      map(response => response.content)
     )
  }





  // http://localhost:8080/api/v1/products/<productId>
  getProduct(id:number):Observable<Product>{
    return this.http.get<Product>(`${this.baseUrl}/${id}`).pipe(
      map(response => response)
    )
  }





}

interface GetResponseProduct{
  content: Product[],
  totalPages: number,
  totalElements: number,
  size: number,
  number: number
}


interface GetResponseCategory{
  content: Category[],
  totalPages: number,
  totalElements: number,
  size: number,
  number: number
}
