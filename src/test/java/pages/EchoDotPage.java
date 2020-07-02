package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtil;

public class EchoDotPage implements ProductDetailsPage {

    public void clickAddToCartButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("add-to-cart-button"));
        WebUtil.click(driver, By.id("add-to-cart-button"));
    }

    public void changeQuantity(WebDriver driver, String quantityOfProduct) {
        // Unable to select with Select due to element being obscured by the span element
        WebUtil.waitForElementBeforeClicking(driver, By.id("quantity"));
        WebUtil.moveToElementAndClick(driver, By.id("quantity"));
        // Quantity desired starts with 0 (0 = 1, 1 = 2, etc.)
        WebUtil.waitForElementBeforeClicking(driver, By.id("quantity_" + quantityOfProduct));
        WebUtil.click(driver, By.id("quantity_" + quantityOfProduct));
    }

    public void clickPlumColor(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("color_name_2"));
        WebUtil.click(driver, By.id("color_name_2"));
    }

    public void clickSandstoneColor(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("color_name_3"));
        WebUtil.click(driver, By.id("color_name_3"));
    }

    public void clickContinueAndCloseForProtectionPlanModal(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.xpath("//div[@id='abb-intl-pop-cta']//input[@class='a-button-input']"));
        // WebDriver needs to click both of these (otherwise it does nothing), since the load time is unknown for Amazon when this modal appears
        WebUtil.click(driver, By.xpath("//div[@id='abb-intl-pop-cta']//input[@class='a-button-input']"));
        WebUtil.click(driver, By.cssSelector("button.a-button-close"));
    }

    public void clickFiveDollarSmartPlugConfig(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("configuration_3"));
        WebUtil.click(driver, By.id("configuration_3"));
    }

    public void clickEchoAutoConfig(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("configuration_1"));
        WebUtil.click(driver, By.id("configuration_1"));
    }

    public void clickWithClockStyle(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("style_name_2"));
        WebUtil.click(driver, By.id("style_name_2"));
    }

    public void waitForPageUpdate(WebDriver driver, String optionSelected) {
        WebUtil.waitForElementToHaveSpecificText(driver, By.id("productTitle"), optionSelected);
    }

    public CartPage clickCartButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("hlb-view-cart-announce"));
        WebUtil.click(driver, By.id("hlb-view-cart-announce"));
        return PageFactory.initElements(driver, CartPage.class);
    }

    public boolean wasMainImageDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("superleafHeroImage"));
        return WebUtil.doesImageElementExist(driver, By.id("superleafHeroImage"));
    }

    public boolean wereMultipleColorsAvailable(WebDriver driver) {
        WebUtil.waitForElementsToLoad(driver, By.xpath("//div[@id='variation_color_name']//li"));
        return WebUtil.doesMoreThanOneElementExist(driver, By.xpath("//div[@id='variation_color_name']//li"));
    }

    public boolean wereMultipleConfigurationsAvailable(WebDriver driver) {
        WebUtil.waitForElementsToLoad(driver, By.xpath("//div[@id='variation_configuration']//li"));
        return WebUtil.doesMoreThanOneElementExist(driver, By.xpath("//div[@id='variation_configuration']//li"));
    }

    public boolean wasPriceDisplayed(WebDriver driver){
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
