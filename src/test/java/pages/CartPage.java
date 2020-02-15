package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtil;

public class CartPage {

    public int getQuantity(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.className("a-dropdown-prompt"));
        return WebUtil.getElementTextToNum(driver, By.className("a-dropdown-prompt"));
    }

    public void increaseQuantity(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.cssSelector(".sc-action-quantity select"));
        WebUtil.moveToElementAndClick(driver, By.cssSelector(".sc-action-quantity select"));
        WebUtil.waitForElementToLoad(driver, By.id("dropdown1_2"));
        WebUtil.click(driver, By.id("dropdown1_2"));
    }

    public boolean wereProductsAddedToCart(WebDriver driver) {
        WebUtil.waitForElementsToLoad(driver, By.className("sc-product-image"));
        return WebUtil.doElementsExist(driver, By.className("sc-product-image"));
    }

    public boolean wasEchoDotInCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-product-title"));
        return WebUtil.doesElementHaveSpecificText(driver, By.cssSelector("span.sc-product-title"), "Plum");
    }

    public void saveForLater(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.cssSelector("span.sc-action-save-for-later"));
        WebUtil.click(driver, By.cssSelector("span.sc-action-save-for-later"));
    }

    public void moveToCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-action-move-to-cart"));
        WebUtil.click(driver, By.cssSelector("span.sc-action-move-to-cart"));
    }

    public boolean didSubtotalMatchValue(WebDriver driver, Double valueSelected) {
        WebUtil.waitForElementToLoad(driver, By.id("sc-subtotal-amount-buybox"));
        return WebUtil.getElementTextToCurrency(driver, By.id("sc-subtotal-amount-buybox")) == valueSelected;
    }

    public boolean wasProductRemovedFromCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//h1[@class='sc-empty-cart-header']"));
        return WebUtil.doesElementHaveSpecificText(driver, By.xpath("//h1[@class='sc-empty-cart-header']"), "empty");
    }

    public boolean wasProductSavedForLater(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("sc-saved-cart-list-caption-text"));
        return WebUtil.doesElementHaveSpecificText(driver, By.id("sc-saved-cart-list-caption-text"), "1");
    }

    public PlaystationGiftCardPage clickPlaystationGiftCardLink(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("//span[@class='a-list-item']/a"));
        WebUtil.click(driver, By.xpath("//span[@class='a-list-item']/a"));
        return PageFactory.initElements(driver, PlaystationGiftCardPage.class);
    }

    public void clickDelete(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("//input[@value='Delete']"));
        WebUtil.click(driver, By.xpath("//input[@value='Delete']"));
    }

    public boolean wasQuantityIncreased(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='a-dropdown-prompt']"));
        return WebUtil.getElementTextToNum(driver, By.xpath("//span[@class='a-dropdown-prompt']")) == 2;
    }

    public boolean doesSubtotalUpdateWithProductsAdded(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("sc-subtotal-amount-buybox"));
        return WebUtil.getElementTextToCurrency(driver, By.id("sc-subtotal-amount-buybox")) == 20.00;
    }

    public boolean wasSavedItemMovedBackToCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-action-save-for-later"));
        return WebUtil.doElementsExist(driver, By.cssSelector("span.sc-action-save-for-later"));
    }

    public boolean wasSandstoneEchoDotWith10HueInCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-product-title"));
        return WebUtil.doesElementHaveSpecificText(driver, By.cssSelector("span.sc-product-title"), "Sandstone Bundle with Philips");
    }

    public boolean wasSandstoneEchoDotWithClockAndEchoAutoInCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-product-title"));
        return WebUtil.doesElementHaveSpecificText(driver, By.cssSelector("span.sc-product-title"), "(Sandstone) Bundle with Echo Auto");
    }
}
