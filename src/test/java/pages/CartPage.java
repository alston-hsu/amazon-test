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

    public void changeQuantity(WebDriver driver, String quantityOfProduct) {
        WebUtil.waitForElementBeforeClicking(driver, By.cssSelector(".sc-action-quantity select"));
        WebUtil.moveToElementAndClick(driver, By.cssSelector(".sc-action-quantity select"));
        WebUtil.waitForElementToLoad(driver, By.id("dropdown1_" + quantityOfProduct));
        WebUtil.click(driver, By.id("dropdown1_" + quantityOfProduct));
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

    public boolean wasProductRemovedFromCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']/h2"));
        return WebUtil.doesElementHaveSpecificText(driver, By.xpath("//div[@class='a-row sc-your-amazon-cart-is-empty']/h2"), "empty");
    }

    public boolean wasProductSavedForLater(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("sc-saved-cart-list-caption-text"));
        return WebUtil.doesElementHaveSpecificText(driver, By.id("sc-saved-cart-list-caption-text"), "1");
    }

    public void clickDelete(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("//input[@value='Delete']"));
        WebUtil.click(driver, By.xpath("//input[@value='Delete']"));
    }

    public boolean wasQuantityIncreased(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@class='a-dropdown-prompt']"));
        return WebUtil.getElementTextToNum(driver, By.xpath("//span[@class='a-dropdown-prompt']")) == 2;
    }

    public boolean didSubtotalMatchExpectedValue(WebDriver driver, String expectedSubtotal) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
        String actualSubtotal = WebUtil.getElementTextToCurrency(driver, By.xpath("//span[@id='sc-subtotal-amount-buybox']/span"));
        return actualSubtotal.contains(expectedSubtotal);
    }

    public boolean wasSavedItemMovedBackToCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-action-save-for-later"));
        return WebUtil.doElementsExist(driver, By.cssSelector("span.sc-action-save-for-later"));
    }

    public boolean wasSandstoneEchoDotWithSmartPlugInCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-product-title"));
        return WebUtil.doesElementHaveSpecificText(driver, By.cssSelector("span.sc-product-title"), "Sandstone Bundle with TP-Link");
    }

    public boolean wasSandstoneEchoDotWithClockAndEchoAutoInCart(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.cssSelector("span.sc-product-title"));
        return WebUtil.doesElementHaveSpecificText(driver, By.cssSelector("span.sc-product-title"), "(Sandstone) Bundle with Echo Auto");
    }

    public boolean wasLimitOfTwoTextDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.className("a-alert-content"));
        return WebUtil.doesElementHaveSpecificText(driver, By.className("a-alert-content"), "limit of 2");
    }
}
