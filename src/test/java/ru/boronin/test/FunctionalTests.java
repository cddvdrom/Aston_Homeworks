package ru.boronin.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class FunctionalTests extends TestPage {
    @Test
    public void BasketTest() {
        Map<String, String> expectedMap = headPage.search().addProductsToBasket();
        headPage.logIntoBasket();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> actualMap = basketPage.getBasketProducts();
        List<Map.Entry<String, String>> expectedEntries = new ArrayList<>(expectedMap.entrySet());
        List<Map.Entry<String, String>> actualEntries = new ArrayList<>(actualMap.entrySet());
        for (int j = 0; j < expectedEntries.size() - 1; j++) {
            if (expectedEntries.get(j).getKey().toLowerCase().
                    contains(actualEntries.get(j).getKey().toLowerCase())) {
                expectedEntries.set(j,
                        new AbstractMap.SimpleEntry<>(actualEntries.get(j).getKey(), actualEntries.get(j).getValue()));
            }
        }
        Assertions.assertEquals(expectedEntries, actualEntries);
        Assertions.assertEquals(expectedMap.size(), Integer.parseInt(basketPage.getQuantity()));

        int actualSum = utils.stringToInt(basketPage.getResultSum());
        int expectedSum = 0;
        for (Map.Entry <String, String> m : expectedEntries) {
            String a = m.getValue();
            expectedSum+= utils.stringToInt(a);
            }
        Assertions.assertEquals(expectedSum,actualSum);
        }
}

