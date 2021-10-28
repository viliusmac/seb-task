
export enum OfferIncomeEnum {
  IRRELEVANT = 'IRRELEVANT',
  MORETHANZERO = 'MORETHANZERO',
  LESSTHAN12K = 'LESSTHAN12K',
  MORETHAN12K = 'MORETHAN12K',
  MORETHAN40K = 'FROM40KUP'
}

export const OfferIncome2LabelMapping: Record<OfferIncomeEnum, string> = {
  [OfferIncomeEnum.IRRELEVANT]: "",
  [OfferIncomeEnum.MORETHANZERO]: "Income > 0",
  [OfferIncomeEnum.LESSTHAN12K]: "Income < 12001",
  [OfferIncomeEnum.MORETHAN12K]: "Income > 12000",
  [OfferIncomeEnum.MORETHAN40K]: "Income > 40000"
};
