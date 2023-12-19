package ru.boronin.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class FunctionalTests extends TestPage {
    @Test
    public void BasketTest() {
        List<Map.Entry<String, String>> productsCardFromHeadPage = headPage.search().getProductsDataFromHeadPage();
        headPage.addProductsToBasket();
        headPage.logIntoBasket();
        List<Map.Entry<String, String>> productCardsFromBasket = basketPage.getBasketProducts();
        productsCardFromHeadPage = utils.castNames(productsCardFromHeadPage,productCardsFromBasket);

        Assertions.assertEquals(productsCardFromHeadPage, productCardsFromBasket);

        int actualQuantity = Integer.parseInt(basketPage.getQuantity());
        int expectedQuantity = productsCardFromHeadPage.size();
        Assertions.assertEquals(expectedQuantity,actualQuantity);

        int actualSum = utils.stringToInt(basketPage.getResultSum());
        int expectedSum = utils.getSumFromProductList(productsCardFromHeadPage);
        Assertions.assertEquals(expectedSum,actualSum);
        }
}

