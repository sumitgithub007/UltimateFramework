package com.fujitsu.core.pages;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private final By SonyXperiaMob      = xpath ("//*[text()='Sony xperia z5']");
    private final By addToCart          = xpath ("//*[text()='Add to cart']");
    private final By cartPageOpen       = xpath ("//*[text()='Cart']");
    private final By city               = cssSelector ("#city");
    private final By country            = cssSelector ("#country");
    private final By creditcard         = cssSelector ("#card");
    private final By month              = cssSelector ("#month");
    private final By name               = cssSelector ("#name");
    private final By placeOrderButton   = xpath ("//button[@data-target='#orderModal']");
    private final By purchaseItemButton = cssSelector ("button[onclick='purchaseOrder()']");
    private final By year               = cssSelector ("#year");

    public void ClickPurchaseButton () {
        click (purchaseItemButton);
    }

    @Step ("Click the addToCart")
    public CartPage addToCart () {
        scrollIntoView(SonyXperiaMob);
        clickWithRetries (SonyXperiaMob);
        click (addToCart);
        waitandAcceptAlert ();
        return this;
    }

    @Step ("Enter the city as {city}")
    public CartPage enterCity (String city) {
        type (this.city, city);
        return this;
    }

    @Step ("Enter the country as {country}")
    public CartPage enterCountry (String country) {
        type (this.country, country);
        return this;
    }

    @Step ("Enter the creditcard as {creditcard}")
    public CartPage enterCreditCard (String creditcard) {
        type (this.creditcard, creditcard);
        return this;
    }

    @Step ("Enter the month as {month}")
    public CartPage enterMonth (String month) {
        type (this.month, month);
        return this;
    }

    @Step ("Enter the name as {name}")
    public CartPage enterName (String name) {
        type (this.name, name);
        return this;
    }

    @Step ("Enter the year as {year}")
    public CartPage enterYear (String year) {
        type (this.country, year);
        return this;
    }

    @Step ("Clicked the cart page to place the order;")
    public CartPage placeOrder () {
        click (cartPageOpen);
        click (placeOrderButton);
        return this;
    }
}
