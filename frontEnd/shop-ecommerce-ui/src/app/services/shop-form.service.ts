import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Country } from '../common/country';
import { HttpClient } from '@angular/common/http';
import { State } from '../common/state';

@Injectable({
  providedIn: 'root'
})
export class ShopFormService {

  private countriesUrl = 'http://localhost:8080/api/v1/countries';
  private statesUrl = 'http://localhost:8080/api/v1/states';

  constructor(private http:HttpClient) { }

  getCreditCardMonths(startMonth:number):Observable<number[]>{

    let data: number[] = [];

    // build an array for "Mothe" dropdown list
    // - start at current month and loop until

    for(let theMonth = startMonth; theMonth <= 12; theMonth++){
      data.push(theMonth);
    }

    return of(data);
  }


  getCreditCardYears():Observable<number[]>{

    let data: number[] = [];

    // build an array for "Year" dropdown list
    // - start at current year and loop for next 10 year

    const startYear:number = new Date().getFullYear();
    const endYear:number = startYear + 10;

    for(let theYear = startYear; theYear <= endYear; theYear++){
      data.push(theYear);
    }

    return of(data);
  }

  // http://localhost:8080/api/v1/countries/get-all
  getContries():Observable<Country[]>{
    return this.http.get<Country[]>(`${this.countriesUrl}/get-all`)
  }


  // http://localhost:8080/api/v1/states/countryCode?code=<country code>
  getStates(theContryCode:string):Observable<State[]>{
    return this.http.get<State[]>(`${this.statesUrl}/countryCode?code=${theContryCode}`)
  }





}
