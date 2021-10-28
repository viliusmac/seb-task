package com.sebtask.sebproducts.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sebtask.sebproducts.model.Product;
import com.sebtask.sebproducts.model.search.ProductSearch;
import com.sebtask.sebproducts.model.enums.AgeRange;
import com.sebtask.sebproducts.model.enums.Income;
import com.sebtask.sebproducts.model.enums.OfferIncome;

class ProductServiceTest {

    ProductService service = new ProductService();

    @Test
    void getProductsFromFile_ConvertsFileToObject_Success() {
        Product product1 = new Product(1, "TEST1", true, AgeRange.SENIOR, OfferIncome.MORETHAN40K);

        assertEquals(product1, service.getProductsFromFile("src/test/mock/products.json").get(0));
    }

    @Test
    void getProductsFromFile_ConvertsFileToObject_Fail() {
        assertEquals(Collections.emptyList(), service.getProductsFromFile("src/test/mock/productswrong.json"));
    }

    @Test
    void findProductsByParams_TermStudent_Success() {
        Product product1 = new Product(1, "TEST1", false, AgeRange.SENIOR, OfferIncome.IRRELEVANT);
        Product product2 = new Product(2, "TEST2", true, AgeRange.SENIOR, OfferIncome.IRRELEVANT);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        ProductSearch terms = new ProductSearch(false, AgeRange.SENIOR, Income.IRRELEVANT);

        assertEquals(product1, service.findProductsByParams(terms, products).get(0));
    }

    @Test
    void findProductsByParams_OutOfIncomeBounds() {
        Product product1 = new Product(1, "TEST1", true, AgeRange.SENIOR, OfferIncome.MORETHAN12K);
        Product product2 = new Product(2, "TEST2", true, AgeRange.SENIOR, OfferIncome.MORETHAN40K);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        ProductSearch terms = new ProductSearch(false, AgeRange.SENIOR, Income.ZERO);

        assertEquals(0, service.findProductsByParams(terms, products).size());
    }

    @Test
    void findProductsByParams_OutOfAgeBounds() {
        Product product1 = new Product(1, "TEST1", true, AgeRange.SENIOR, OfferIncome.MORETHAN12K);
        Product product2 = new Product(2, "TEST2", true, AgeRange.SENIOR, OfferIncome.MORETHAN40K);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        ProductSearch terms = new ProductSearch(false, AgeRange.SENIOR, Income.ZERO);

        assertEquals(0, service.findProductsByParams(terms, products).size());
    }
}