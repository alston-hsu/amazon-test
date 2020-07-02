package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtil;

public class PlaystationGiftCardPage implements ProductDetailsPage {

    public void waitForPageUpdate(WebDriver driver, String optionSelected) {
        WebUtil.waitForElementToHaveSpecificText(driver, By.id("productTitle"), optionSelected);
    }

    public void waitForPageToLoad(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.className("nav-signin-tt"));
    }

    public void clickVideoGamesBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[1]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[1]//a"));
    }

    public void clickOnlineGameServicesBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[2]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[2]//a"));
    }

    public void clickPlaystationNetworkBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[3]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[3]//a"));
    }

    public void clickPlaystationStoreCurrencyCardsBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[4]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[4]//a"));
    }

    public void clickAddToCartButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("add-to-cart-button"));
        WebUtil.click(driver, By.id("add-to-cart-button"));
    }

    public void selectOneHundredAsValue(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("denomination_1"));
        WebUtil.click(driver, By.id("denomination_1"));
    }

    public void changeQuantity(WebDriver driver, String quantityOfProduct) {
        // Unable to select with Select due to element being obscured by the span element
        WebUtil.waitForElementBeforeClicking(driver, By.id("quantity"));
        WebUtil.moveToElementAndClick(driver, By.id("quantity"));
        // Quantity desired starts with 0 (0 = 1, 1 = 2, etc.)
        WebUtil.waitForElementBeforeClicking(driver, By.id("quantity_" + quantityOfProduct));
        WebUtil.click(driver, By.id("quantity_" + quantityOfProduct));
    }

    public CartPage clickCartButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("hlb-view-cart-announce"));
        WebUtil.click(driver, By.id("hlb-view-cart-announce"));
        return PageFactory.initElements(driver, CartPage.class);
    }

    public boolean wasMainImageDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("landingImage"));
        return WebUtil.doesImageElementExist(driver, By.id("landingImage"));
    }

    public boolean doesVideoGamesBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("div.pageBanner"));
        return WebUtil.getPageTitle(driver).contains("Video Games");
    }

    public boolean doesOnlineGameServicesBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='nav-search-label']"));
        return WebUtil.getElementText(driver, By.xpath("//span[@class='nav-search-label']")).contains("Online Video Game Services");
    }

    public boolean doesPlaystationNetworkBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='nav-search-label']"));
        return WebUtil.getElementText(driver, By.xpath("//span[@class='nav-search-label']")).contains("PlayStation Network");
    }

    public boolean doesPlaystationStoreCurrencyCardsBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='nav-search-label']"));
        return WebUtil.getElementText(driver, By.xpath("//span[@class='nav-search-label']")).contains("Store Currency Cards");
    }

    public boolean wasPriceDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("price"));
        return WebUtil.doElementsExist(driver, By.id("price"));
    }

    public boolean wereDetailsDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("productDescription"));
        return WebUtil.getElementText(driver, By.id("productDescription")) != "";
    }

    public boolean wereReviewsAvailable(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("acrCustomerReviewText"));
        return WebUtil.getElementTextToNum(driver, By.id("acrCustomerReviewText")) > 0;
    }

    public boolean didCartCountIncrease(WebDriver driver, int quantityOfProductAdded) {
        WebUtil.waitForElementToLoad(driver, By.id("nav-cart-count"));
        return WebUtil.getElementTextToNum(driver, By.id("nav-cart-count")) == quantityOfProductAdded;
    }

    public boolean wasCartAddConfirmationDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("huc-v2-order-row-confirm-text"));
        return WebUtil.doesElementHaveSpecificText(driver, By.id("huc-v2-order-row-confirm-text"), "Added to Cart");
    }
}
