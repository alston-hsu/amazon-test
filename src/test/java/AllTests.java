import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
        String currentImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        // 2. Click on the left arrow for the hero carousel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-carousel-goto-prevpage")));
        WebElement leftArrowCarousel = driver.findElement(By.className("a-carousel-goto-prevpage"));
        leftArrowCarousel.click();

        // 3. Verify that the previous slide in the carousel was displayed
        String previousImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        Assert.assertTrue("The previous picture for the hero carousel should be displayed", currentImage != previousImage);
    }

    @Test
    public void clickRightHeroCarousel() {
        // 1. Go to the home page
        driver.get(homePage);
        String currentImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        // 2. Click on the right arrow for the hero carousel
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-carousel-goto-nextpage")));
        WebElement rightArrowCarousel = driver.findElement(By.className("a-carousel-goto-nextpage"));
        rightArrowCarousel.click();

        // 3. Verify that the next slide in the carousel was displayed
        String nextImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentImage != nextImage);
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
