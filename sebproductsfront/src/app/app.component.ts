import {Component, OnInit} from '@angular/core';
import {Product} from "./model/Product";
import {ProductService} from "./services/product.service";
import {AgeRange2LabelMapping, AgeRangeEnum} from "./model/enums/AgeRange.enum";
import {Income2LabelMapping, IncomeEnum} from "./model/enums/Income.enum";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  public products: Product[];

  ageChosen: AgeRangeEnum;
  incomeChosen: IncomeEnum;
  isStudentChosen: boolean = false;

  public AgeRange2LabelMapping = AgeRange2LabelMapping;
  public ageRanges = Object.values(AgeRangeEnum)
  public Income2LabelMapping = Income2LabelMapping;
  public income = Object.values(IncomeEnum)

  constructor(private personService: ProductService) {}

  ngOnInit(): void {
  const ageRangeTemp = sessionStorage.getItem('ageRange');
    if (ageRangeTemp !== 'undefined' && ageRangeTemp !== null) {
    // @ts-ignore
    this.ageChosen = AgeRangeEnum[ageRangeTemp]
  }
    const incomeTemp = sessionStorage.getItem('income');
    if (incomeTemp !== 'undefined' && incomeTemp !== null) {
      // @ts-ignore
      this.incomeChosen = IncomeEnum[incomeTemp]
    }
    if (sessionStorage.getItem('isStudent') === 'true')
    {
      this.isStudentChosen = true;
    }

    this.search();
  }

  search() {
    if (this.ageChosen) {
      this.personService.getFilteredProducts(this.ageChosen, this.incomeChosen, this.isStudentChosen).subscribe(products => this.products = products);
      sessionStorage.setItem('ageRange', this.ageChosen);
      sessionStorage.setItem('income', this.incomeChosen);
      sessionStorage.setItem('isStudent', String(this.isStudentChosen));
    }
  }

}
