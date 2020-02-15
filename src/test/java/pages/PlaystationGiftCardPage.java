package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebUtil;

public class PlaystationGiftCardPage {

    public void waitForValueToUpdate(WebDriver driver, String valueSelected) {
        WebUtil.waitForElementToHaveSpecificText(driver, By.xpath("//span[@id='digital-button-price']//span[@class='majorValue']"), valueSelected);
    }

    public boolean wasMainImageDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("superleafHeroImage"));
        return WebUtil.doesImageElementExist(driver, By.id("superleafHeroImage"));
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

    public CartPage clickCartButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("hlb-view-cart-announce"));
        WebUtil.click(driver, By.id("hlb-view-cart-announce"));
        return PageFactory.initElements(driver, CartPage.class);
    }

    public void selectOneHundredAsValue(WebDriver driver) {
        // This wait is used for the savings button to finish loading before interacting with the denomination dropdown
        WebUtil.waitForElementToLoad(driver, By.id("instantsavings-button-text"));
        WebUtil.click(driver, By.id("vodd-button-denomination"));
        // This xpath was used since there is a bug where the tr element can not be scrolled into view (https://bugzilla.mozilla.org/show_bug.cgi?id=1448825)
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("//tr[@id='denomination_1']//td"));
        // Actions used due to element being obscured
        WebUtil.moveToElementAndClick(driver, By.xpath("//tr[@id='denomination_1']//td"));
    }

    public void increaseQuantityToTwo(WebDriver driver) {
        // This wait is used for the savings button to finish loading before interacting with the quantity dropdown
        WebUtil.waitForElementToLoad(driver, By.id("instantsavings-button-text"));
        // Unable to select with Select due to element being obscured by the span element
        WebUtil.moveToElementAndClick(driver, By.id("quantity"));
        WebUtil.waitForElementBeforeClicking(driver, By.id("quantity_1"));
        WebUtil.click(driver, By.id("quantity_1"));
    }

    public boolean doesVideoGamesBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("div.pageBanner"));
        return WebUtil.getPageTitle(driver).contains("Video Games");
    }

    public boolean doesOnlineGameServicesBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='a-color-state a-text-bold']"));
        return WebUtil.getPageTitle(driver).contains("Online Game Services");
    }

    public boolean doesPlaystationNetworkBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='a-color-state a-text-bold']"));
        return WebUtil.getPageTitle(driver).contains("PlayStation Network");
    }

    public boolean doesPlaystationStoreCurrencyCardsBreadcrumbNavigateProperly(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='a-color-state a-text-bold']"));
        return WebUtil.getPageTitle(driver).contains("Store Currency Cards");
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

    public boolean wasLimitOfTwoTextDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.className("a-alert-content"));
        return WebUtil.doesElementHaveSpecificText(driver, By.className("a-alert-content"), "limit of 2");
    }
}
