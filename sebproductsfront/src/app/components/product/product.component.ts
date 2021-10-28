import {Component, Input, OnInit} from '@angular/core';
import {Product} from "../../model/Product";
import {AgeRange2LabelMapping, OfferAgeRange2LabelMapping} from "../../model/enums/AgeRange.enum";
import {Income2LabelMapping} from "../../model/enums/Income.enum";
import {OfferIncome2LabelMapping} from "../../model/enums/OfferIncome.enum";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit{

  @Input()
  product: Product | undefined;

  public AgeRange2LabelMapping = AgeRange2LabelMapping;
  public Income2LabelMapping = Income2LabelMapping;
  public OfferAgeRange2LabelMapping = OfferAgeRange2LabelMapping;

  public chosenProduct = false;

  ngOnInit(): void {
    if (this.product && sessionStorage.getItem(this.product.id.toString()) === 'true') {
      this.chosenProduct = true;
    }
  }

  prepareAgeRange() {
    return this.product?.ageRange
      ? 'Age range: ' + OfferAgeRange2LabelMapping[this.product?.ageRange]
      : '';
  }

  prepareIncome() {
    return this.product?.income
      ? OfferIncome2LabelMapping[this.product?.income]
      : '';
  }

  toggleChosenProduct() {
    this.chosenProduct = !this.chosenProduct;
    if (this.product) {
      this.chosenProduct
        ? sessionStorage.setItem(this.product.id.toString(), 'true')
        : sessionStorage.removeItem(this.product.id.toString());
    }
  }
}
