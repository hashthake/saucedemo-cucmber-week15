package com.saucedemo.pages;

import com.saucedemo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends Utility {

    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement dropDown;


    @FindBy(className = "inventory_item_name")
    List<WebElement> allProducts;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Add to cart'])[1]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(id = "back-to-products")
    WebElement backToProducts;

    @CacheLookup
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cart;

    static List<String> items = new ArrayList<>();

    public void selectOptionFromDropdown(String visibleText) {
        selectByVisibleTextFromDropDown(dropDown, visibleText);
    }

    public void selectCostliestProductAndAddToTheBasket(String visibleText) {

        for (WebElement product : allProducts) {
            items.add(product.getText());
        }
        for (WebElement products : allProducts) {
            if (products.getText().equalsIgnoreCase(items.get(0))) {
                clickOnElement(products);
                clickOnElement(addToCart);
                break;
            }
        }
        clickOnElement(backToProducts);
        selectByVisibleTextFromDropDown(dropDown, visibleText);
    }

    public void selectCheapestProductAndAddToTheBasket(String visibleText) {

        for (WebElement product : allProducts) {
            items.add(product.getText());
        }
        for (WebElement products : allProducts) {
            if (products.getText().equalsIgnoreCase(items.get(5))) {
                clickOnElement(products);
                clickOnElement(addToCart);
                break;
            }
        }
    }

    public void openShoppingCart(){
        clickOnElement(cart);
    }
}
