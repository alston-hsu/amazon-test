package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebUtil;

public class HomePage {

    public String getImageAlternativeText(WebDriver driver) {
        return WebUtil.getElementAttributeValue(driver, By.xpath("//div[@id='desktop-banner']//img"), "alt");
    }

    public void clickLeftArrowCarousel(WebDriver driver) {
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.className("a-carousel-goto-prevpage"));
        WebUtil.click(driver, By.className("a-carousel-goto-prevpage"));
    }

    public void clickRightArrowCarousel(WebDriver driver) {
        WebUtil.waitForElementToLoadBeforeClicking(driver, By.className("a-carousel-goto-nextpage"));
        WebUtil.click(driver, By.className("a-carousel-goto-nextpage"));
    }

    public boolean didImageChange(WebDriver driver, String altText1, String altText2) {
        return altText1 != altText2;
    }
}
