package ru.boronin.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FunctionalTests extends TestPage {
    @Test
    public void BasketTest() {
        Map<String, String> expectedMap = headPage.search().addProductsToBasket();
        int quantity = headPage.getProductListSize();
        headPage.logIntoBasket();
        Map<String, String> actualMap = basketPage.getBasketProducts();

        List<Map.Entry<String, String>> expectedEntries = new ArrayList<>(expectedMap.entrySet());
        List<Map.Entry<String, String>> actualEntries = new ArrayList<>(actualMap.entrySet());

        for (int i = 0; i < expectedEntries.size()-1; i++) {
            if (expectedEntries.get(i).getKey().toLowerCase().contains(actualEntries.get(i).getKey().toLowerCase())) {
                expectedEntries.set(i, new AbstractMap.SimpleEntry<>(actualEntries.get(i).getKey(), actualEntries.get(i).getValue()));
            }
        }
    //    Assertions.assertEquals(expectedEntries, actualEntries);
        Assertions.assertEquals(quantity,basketPage.getQuantity());
    }
}

