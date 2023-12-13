package ru.boronin.test;

import org.junit.jupiter.api.Test;
import ru.boronin.pages.BasketPage;

import java.util.Map;

public class FunctionalTests extends TestPage {
    @Test
    public void BasketTest() {
       Map <String,String> expectedMap = headPage.search().addProductsToBasket();
        for (Map.Entry<String,String> e:expectedMap.entrySet()
             ) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        headPage.logIntoBasket();
        System.out.println("===================================");

        Map <String,String> actualMap = basketPage.getBasketProducts();
        System.out.println(actualMap.size());
        for (Map.Entry<String,String> e:actualMap.entrySet()
        ) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}

