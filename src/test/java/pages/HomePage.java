package pages;

import credentials.AmazonCredentialsManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebUtil;

public class HomePage {

    public String getImageAlternativeText(WebDriver driver) {
        return WebUtil.getElementAttributeValue(driver, By.xpath("//div[@id='desktop-banner']//img"), "alt");
    }

    public void clickLeftArrowCarousel(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.className("a-carousel-goto-prevpage"));
        WebUtil.click(driver, By.className("a-carousel-goto-prevpage"));
    }

    public void clickRightArrowCarousel(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.className("a-carousel-goto-nextpage"));
        WebUtil.click(driver, By.className("a-carousel-goto-nextpage"));
    }

    public void clickAccountNavBar(WebDriver driver) {
        WebUtil.waitForElementBeforeClicking(driver, By.id("nav-link-accountList"));
        WebUtil.click(driver, By.id("nav-link-accountList"));
    }

    public void clickContinueButton(WebDriver driver) {
        WebUtil.click(driver, By.id("continue"));
    }

    public void clickSignInButton(WebDriver driver) {
        WebUtil.click(driver, By.id("signInSubmit"));
    }

    public void enterUsername(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("ap_email"));
        WebUtil.type(driver, By.id("ap_email"), AmazonCredentialsManager.getUsername());
    }

    public void enterPassword(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.id("ap_password"));
        WebUtil.type(driver, By.id("ap_password"), AmazonCredentialsManager.getPassword());
    }

    public boolean didImageChange(WebDriver driver, String altText1, String altText2) {
        return altText1 != altText2;
    }

    public boolean wasAuthenticationMessageDisplayed(WebDriver driver) {
        WebUtil.waitForElementToLoad(driver, By.xpath("//div[@class='a-row a-spacing-small']/h1"));
        return WebUtil.doesElementHaveSpecificText(driver, By.xpath("//div[@class='a-row a-spacing-small']/h1"), "Authentication required");
    }
}
