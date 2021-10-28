
export enum IncomeEnum {
  IRRELEVANT = 'IRRELEVANT',
  ZERO = 'ZERO',
  UPTO12K = 'UPTO12K',
  FROM12TO40K = 'FROM12TO40K',
  FROM40KUP = 'FROM40KUP'
}

export const Income2LabelMapping: Record<IncomeEnum, string> = {
  [IncomeEnum.IRRELEVANT]: "",
  [IncomeEnum.ZERO]: "0",
  [IncomeEnum.UPTO12K]: "1-12000",
  [IncomeEnum.FROM12TO40K]: "12001-40000",
  [IncomeEnum.FROM40KUP]: "40001+"
};
