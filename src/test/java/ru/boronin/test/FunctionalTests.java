package ru.boronin.test;

import org.junit.jupiter.api.Test;
import ru.boronin.pages.HeadPage;

public class FunctionalTests extends TestPage {
    @Test
    public void BasketTest() {
        headPage.search().addProductsToBasket();
    }
}

