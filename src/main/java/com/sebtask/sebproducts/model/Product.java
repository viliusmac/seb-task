package com.sebtask.sebproducts.model;

import java.util.Objects;

import com.sebtask.sebproducts.model.enums.AgeRange;
import com.sebtask.sebproducts.model.enums.OfferIncome;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Product {

    private long id;

    private String name;

    private boolean student;

    private AgeRange ageRange;

    private OfferIncome income;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id && student == product.student && Objects.equals(name, product.name) && ageRange == product.ageRange && income == product.income;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, student, ageRange, income);
    }
}


