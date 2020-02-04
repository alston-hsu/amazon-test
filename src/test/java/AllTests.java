import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AllTests {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    String homePage = "https://www.amazon.com/";

    // Home Page tests
    @Test
    public void clickLeftHeroCarousel() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the left arrow for the hero carousel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='a-icon a-icon-previous-rounded']")));
        WebElement leftArrowCarousel = driver.findElement(By.xpath("//i[@class='a-icon a-icon-previous-rounded']"));
        leftArrowCarousel.click();

        // 3. Verify that the previous slide in the carousel was displayed
        WebElement previousImage = driver.findElement(By.xpath("//div[@id='gw-ftGr-desktop-tall-hero-H']//img"));

        Assert.assertTrue("The previous picture for the hero carousel should be displayed", previousImage.getSize().width != 0);
    }

    @Test
    public void clickRightHeroCarousel() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the right arrow for the hero carousel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='a-icon a-icon-next-rounded']")));
        WebElement rightArrowCarousel = driver.findElement(By.xpath("//i[@class='a-icon a-icon-next-rounded']"));
        rightArrowCarousel.click();

        // 3. Verify that the next slide in the carousel was displayed
        WebElement nextImage = driver.findElement(By.xpath("//div[@id='gw-ftGr-desktop-tall-hero-G']//img"));

        Assert.assertTrue("The next picture for the hero carousel should be displayed", nextImage.getSize().width != 0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
