package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebUtil;

public class EchoDotPage {

    public void clickPlumColor(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("color_name_2"));
        WebUtil.click(driver, By.id("color_name_2"));
    }

    public void clickSandstoneColor(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("color_name_3"));
        WebUtil.click(driver, By.id("color_name_3"));
    }

    public void clickAddToCartButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("add-to-cart-button"));
        WebUtil.click(driver, By.id("add-to-cart-button"));
    }

    public void clickCloseButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.cssSelector("button.a-button-close"));
        WebUtil.click(driver, By.cssSelector("button.a-button-close"));
    }

    public void click10HueConfig(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("configuration_1"));
        WebUtil.click(driver, By.id("configuration_1"));
    }

    public void clickEchoAutoConfig(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("configuration_3"));
        WebUtil.click(driver, By.id("configuration_3"));
    }

    public void clickWithClockStyle(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("style_name_1"));
        WebUtil.click(driver, By.id("style_name_1"));
    }

    public CartPage clickCartButton(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("hlb-view-cart-announce"));
        WebUtil.click(driver, By.id("hlb-view-cart-announce"));
        return PageFactory.initElements(driver, CartPage.class);
    }

    public void waitForPageUpdate(WebDriver driver, String optionSelected) {
        WebUtil.waitForElementToHaveSpecificText(driver, By.id("productTitle"), optionSelected);
    }

    public boolean wereMultipleColorsAvailable(WebDriver driver) {
        WebUtil.waitForElementsToLoad(driver, By.xpath("//div[@id='variation_color_name']//li"));
        return WebUtil.doesMoreThanOneElementExist(driver, By.xpath("//div[@id='variation_color_name']//li"));
    }

    public boolean wereMultipleConfigurationsAvailable(WebDriver driver) {
        WebUtil.waitForElementsToLoad(driver, By.xpath("//div[@id='variation_configuration']//li"));
        return WebUtil.doesMoreThanOneElementExist(driver, By.xpath("//div[@id='variation_configuration']//li"));
    }
}
