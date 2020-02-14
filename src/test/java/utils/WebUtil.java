package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.PlaystationGiftCardPage;
import pages.EchoDotPage;

import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class WebUtil {

    public static HomePage goToHomePage(WebDriver driver) {
        driver.get("https://www.amazon.com/");
        return PageFactory.initElements(driver, HomePage.class);
    }

    public static PlaystationGiftCardPage goToPlayStationGiftCardPage(WebDriver driver) {
        driver.get("https://www.amazon.com/gp/product/B00GAC1D2G/ref=ox_sc_act_title_1?smid=A3ODHND3J0WMC8&th=1");
        return PageFactory.initElements(driver, PlaystationGiftCardPage.class);
    }

    public static EchoDotPage goToEchoDotPage(WebDriver driver) {
        driver.get("https://www.amazon.com/Echo-Dot-3rd-Gen-speaker/dp/B07FZ8S74R/ref=zg_bs_electronics_6?_encoding=UTF8&refRID=ZJ6C2BGXCDD7J13VW2W9&smid=ATVPDKIKX0DER&th=1");
        return PageFactory.initElements(driver, EchoDotPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement elementToClick = driver.findElement(by);
        elementToClick.click();
    }

    public static String type(WebDriver driver, By by, String text) {
        WebElement inputElement = driver.findElement(by);
        inputElement.sendKeys(text);
    }

    public static void waitForElementToLoad(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToLoadBeforeClicking(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToHaveSpecificText(WebDriver driver, By by, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static boolean doesImageElementExist(WebDriver driver, By by) {
        WebElement imageElement = driver.findElement(by));
        return imageElement.getSize().getWidth() != 0;
    }

    public static String getTitle(WebDriver driver) {
        String currentPageTitle = driver.getTitle();
        return currentPageTitle;
    }

    public static boolean doElementsExist(WebDriver driver, By by) {
        List<WebElement> elementsToCheck = driver.findElements(by);
        return elementsToCheck.size() != 0;
    }

    public static boolean doesMoreThanOneElementExist(WebDriver driver, By by) {
        List<WebElement> elementsToCheck = driver.findElements(by);
        return elementsToCheck.size() > 1;
    }

    public static boolean isTextPresent(WebDriver driver) {
        String elementToText = driver.findElement(By.id("productDescription")).getText();
        return elementToText != "";
    }

    public static String getElementText(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        String elementText = element.getText();
        return elementText;
    }

    public static int getElementTextToNum(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        int elementTextToNum = Integer.parseInt(element.getText());
        return elementTextToNum;
    }

    public static double getElementTextToCurrency(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        double elementTextToCurrency = Double.parseDouble(element.getText());
        return elementTextToCurrency;
    }

    public static void moveToElementAndClick(WebDriver driver, By by ) {
        WebElement elementToClick = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(elementToClick).click().perform();
    }

    public static boolean doesElementHaveSpecificText(WebDriver driver, By by, String text) {
        WebElement element = driver.findElement(by);
        String elementToText = element.getText();
        return elementToText.contains(text);
    }
}
