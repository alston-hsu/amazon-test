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

public class WebUtil {

    public static HomePage goToHomePage(WebDriver driver) {
        driver.get("https://www.amazon.com/");
        return PageFactory.initElements(driver, HomePage.class);
    }

    public static PlaystationGiftCardPage goToPlayStationGiftCardPage(WebDriver driver) {
        driver.get("https://www.amazon.com/gp/product/B00GAC1D2G");
        return PageFactory.initElements(driver, PlaystationGiftCardPage.class);
    }

    public static EchoDotPage goToEchoDotPage(WebDriver driver) {
        driver.get("https://www.amazon.com/Echo-Dot-3rd-Gen-speaker/dp/B07FZ8S74R");
        return PageFactory.initElements(driver, EchoDotPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement elementToClick = driver.findElement(by);
        elementToClick.click();
    }

    public static void type(WebDriver driver, By by, String text) {
        WebElement inputElement = driver.findElement(by);
        inputElement.sendKeys(text);
    }

    public static void waitForElementToLoad(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementsToLoad(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void waitForElementBeforeClicking(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToHaveSpecificText(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
    }

    public static boolean doesImageElementExist(WebDriver driver, By by) {
        WebElement imageElement = driver.findElement(by);
        return imageElement.getSize().getWidth() != 0;
    }

    public static String getPageTitle(WebDriver driver) {
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
        int elementTextToNum = Integer.parseInt(element.getText().replaceAll("[^\\d.]", ""));
        return elementTextToNum;
    }

    public static String getElementTextToCurrency(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        String elementToText = element.getText();
        if (elementToText.contains("\r?\n")) {
            String[] elementTextParts = elementToText.split("\r?\n");
            String elementText1 = elementTextParts[0];
            String elementText2 = elementTextParts[1];
            String elementTextToCurrency = elementText1 + "." + elementText2;
            return elementTextToCurrency;
        } else {
            return elementToText;
        }
    }

    public static String getElementAttributeValue(WebDriver driver, By by, String attribute) {
        WebElement element = driver.findElement(by);
        String elementAttributeValue = element.getAttribute(attribute);
        return elementAttributeValue;
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
