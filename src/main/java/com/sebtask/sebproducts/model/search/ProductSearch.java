package com.sebtask.sebproducts.model.search;

import com.sebtask.sebproducts.model.enums.AgeRange;
import com.sebtask.sebproducts.model.enums.Income;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductSearch {

        private boolean student;

        private AgeRange ageRange;

        private Income income;

}
