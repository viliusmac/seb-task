export enum AgeRangeEnum {
  TEENAGER = 'TEENAGER',
  ADULT = 'ADULT',
  SENIOR = 'SENIOR',
}

export const AgeRange2LabelMapping: Record<AgeRangeEnum, string> = {
  [AgeRangeEnum.TEENAGER]: "0-17",
  [AgeRangeEnum.ADULT]: "18-64",
  [AgeRangeEnum.SENIOR]: "65+",
};

export const OfferAgeRange2LabelMapping: Record<AgeRangeEnum, string> = {
  [AgeRangeEnum.TEENAGER]: "< 18",
  [AgeRangeEnum.ADULT]: "> 17",
  [AgeRangeEnum.SENIOR]: ">= 65",
};
