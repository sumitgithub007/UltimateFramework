package com.fujitsu.tests;

import static com.fujitsu.core.factories.PageFactory.createPage;

import java.util.Map;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import com.fujitsu.core.pages.CartPage;
import com.fujitsu.core.pages.LandingPage;

/**
 * @author sumit
 * @since 26/06/23 8:21 pm
 */
@Epic ("Product purchase for demo Blaze")
@Feature ("Going To select a product from demoblaze and do the payment")
public final class ProductPurchaseTest extends BaseTest {

    private ProductPurchaseTest () {

    }
    @Test ()
    @Description("Purchasing the order from Demo Blaze")
    public void productPurchaseTest (Map<String, String> data) {
        createPage(LandingPage.class).Login (data.get ("UserName"), data.get ("Password"));
        createPage (CartPage.class).addToCart ()
            .placeOrder ()
            .enterName (data.get ("UserName"))
            .enterCountry (data.get ("Country"))
            .enterCity (data.get ("City"))
            .enterCreditCard (data.get ("CreditCard"))
            .enterMonth (data.get ("Month"))
            .enterYear (data.get ("Year"))
            .ClickPurchaseButton ();
    }

}
