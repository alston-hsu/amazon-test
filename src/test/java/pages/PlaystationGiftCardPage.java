package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebUtil;

public class PlaystationGiftCardPage {

    public boolean wasMainImageDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("superleafHeroImage"));
        return WebUtil.doesImageElementExist(driver, By.id("superleafHeroImage"));
    }

    public void clickVideoGamesBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[1]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[1]//a"));
    }

    public void clickOnlineGameServicesBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[2]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[2]//a"));
    }

    public void clickPlaystationNetworkBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[3]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[3]//a"));
    }

    public void clickPlaystationStoreCurrencyCardsBreadcrumb(WebDriver driver) {
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.xpath("(//span[@class='a-list-item'])[4]//a"));
        WebUtil.click(driver, By.xpath("(//span[@class='a-list-item'])[4]//a"));
    }

    public void clickAddToCartButton(WebDriver driver) {
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.id("add-to-cart-button"));
        WebUtil.click(driver, By.id("add-to-cart-button"));
    }

    public void increaseQuantityToTwo(WebDriver driver) {
        // This wait is used for the savings button to finish loading before interacting with the quantity dropdown
        WebUtil.waitForElementToLoad(driver, By.id("instantsavings-button-text"));
        // Unable to select with Select due to element being obscured by the span element
        WebUtil.moveToElementAndClick(driver, By.id("quantity"));
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.id("quantity_1"));
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
}
