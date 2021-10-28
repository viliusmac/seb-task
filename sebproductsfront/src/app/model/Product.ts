import {AgeRangeEnum} from "./enums/AgeRange.enum";
import {OfferIncomeEnum} from "./enums/OfferIncome.enum";

export interface Product {
  id: number;
  name: string;
  ageRange: AgeRangeEnum;
  income: OfferIncomeEnum;
  student: boolean;
}
