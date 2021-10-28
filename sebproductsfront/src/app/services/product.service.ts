import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/Product";
import {environment} from "../../environments/environment";
import {AgeRangeEnum} from "../model/enums/AgeRange.enum";
import {IncomeEnum} from "../model/enums/Income.enum";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getFilteredProducts(ageRange: AgeRangeEnum, income: IncomeEnum, isStudent: boolean): Observable<Product[]> {
    const filter = {
      ageRange: ageRange,
      income: income,
      student: isStudent
    }
    return this.http.post<Product[]>(`${this.apiServerUrl}/products/filtered`, filter);
  }
}
