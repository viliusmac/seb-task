package com.sebtask.sebproducts.service;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebtask.sebproducts.model.Product;
import com.sebtask.sebproducts.model.search.ProductSearch;
import com.sebtask.sebproducts.model.enums.AgeRange;
import com.sebtask.sebproducts.model.enums.Income;

@Service
public class ProductService {

    public List<Product> getProductsFromFile(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            return Arrays.asList(mapper.readValue(Paths.get(path).toFile(), Product[].class));

        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Product> findProductsByParams(ProductSearch params, List<Product> list) {
        return list.stream()
                // Age range filtering
                .filter(product -> product.getAgeRange() == params.getAgeRange() || params.getAgeRange() == AgeRange.SENIOR && product.getAgeRange() == AgeRange.ADULT)
                // Income filtering
                .filter(product -> {
                    switch (product.getIncome()) {
                        case MORETHANZERO:
                            return params.getIncome() != Income.ZERO && params.getIncome() != Income.IRRELEVANT;
                        case LESSTHAN12K:
                            return params.getIncome() == Income.UPTO12K || params.getIncome() == Income.ZERO;
                        case MORETHAN12K:
                            return params.getIncome() == Income.FROM12TO40K || params.getIncome() == Income.FROM40KUP;
                        case MORETHAN40K:
                            return params.getIncome() == Income.FROM40KUP;
                        default:
                            return true;
                    }
                })
                // is person a student filtering
                .filter(product -> !product.isStudent() || params.isStudent())
                .collect(Collectors.toList());
    }

}
