package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebUtil;

public class EchoDotPage {

    public boolean wereMultipleColorsAvailable(WebDriver driver) {
        WebUtil.waitForElementsToLoad(driver, By.xpath("//div[@id='variation_color_name']//li"));
        return WebUtil.doesMoreThanOneElementExist(driver, By.xpath("//div[@id='variation_color_name']//li"));
    }

    public boolean wereMultipleConfigurationsAvailable(WebDriver driver) {
        WebUtil.waitForElementsToLoad(driver, By.xpath("//div[@id='variation_configuration']//li"));
        return WebUtil.doesMoreThanOneElementExist(driver, By.xpath("//div[@id='variation_configuration']//li"));
    }
}
