import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;


public class AllTests {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    String homePage = "https://www.amazon.com/";
    String playstationGiftCardPage = "https://www.amazon.com/gp/product/B00GAC1D2G/ref=ox_sc_act_title_1?smid=A3ODHND3J0WMC8&th=1";
    // This method is needed since product detail pages can take quite some time to load for elements to be interactable (elementToBeClickable, visibilityOfElementLocated, etc do not work for clicking the quantity dropdown).
    // Other methods to wait were done without success, since the condition to wait for is not clear, otherwise an explicit wait would be used
    public void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {
        WebDriverWait wait = new WebDriverWait(driver, specifiedTimeout);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
                .equals("complete"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Home Page tests
    @Test
    public void clickLeftHeroCarousel() {
        // 1. Go to the home page
        driver.get(homePage);
        String currentImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        // 2. Click on the left arrow for the hero carousel
        WebElement leftArrowCarousel = driver.findElement(By.className("a-carousel-goto-prevpage"));
        wait.until(ExpectedConditions.elementToBeClickable(leftArrowCarousel));
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
        WebElement rightArrowCarousel = driver.findElement(By.className("a-carousel-goto-nextpage"));
        wait.until(ExpectedConditions.elementToBeClickable(rightArrowCarousel));
        rightArrowCarousel.click();

        // 3. Verify that the next slide in the carousel was displayed
        String nextImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentImage != nextImage);
    }

    // Product Detail Page (PDP) tests
    @Test
    public void playstationGiftCardImage() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Verify that there is a main image displayed in the product's detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("superleafHeroImage")));
        WebElement playstationGiftCardImage = driver.findElement(By.id("superleafHeroImage"));

        Assert.assertTrue("The next picture for the hero carousel should be displayed", playstationGiftCardImage.getSize().getWidth() != 0);
    }

    @Test
    public void playstationGiftCardFirstBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Click on the "Video Games" breadcrumb
        WebElement videoGamesBreadcrumb = driver.findElement(By.xpath("(//span[@class='a-list-item'])[1]//a"));
        wait.until(ExpectedConditions.elementToBeClickable(videoGamesBreadcrumb));
        videoGamesBreadcrumb.click();

        // 3. Verify that the user was navigated back to the Best Sellers web page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.pageBanner")));
        String currentPageTitle = driver.getTitle();

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentPageTitle.contains("Video Games"));
    }

    @Test
    public void playstationGiftCardSecondBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Click on the "Online Game Services" breadcrumb
        WebElement onlineGameServicesBreadcrumb = driver.findElement(By.xpath("(//span[@class='a-list-item'])[2]//a"));
        wait.until(ExpectedConditions.elementToBeClickable(onlineGameServicesBreadcrumb));
        onlineGameServicesBreadcrumb.click();

        // 3. Verify that the user was navigated back to the Best Sellers web page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']")));
        String currentPageTitle = driver.getTitle();

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentPageTitle.contains("Online Game Services"));
    }

    @Test
    public void playstationGiftCardThirdBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Click on the "PlayStation Network" breadcrumb
        WebElement onlineGameServicesBreadcrumb = driver.findElement(By.xpath("(//span[@class='a-list-item'])[3]//a"));
        wait.until(ExpectedConditions.elementToBeClickable(onlineGameServicesBreadcrumb));
        onlineGameServicesBreadcrumb.click();

        // 3. Verify that the user was navigated back to the Best Sellers web page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']")));
        String currentPageTitle = driver.getTitle();

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentPageTitle.contains("PlayStation Network"));
    }

    @Test
    public void playstationGiftCardFourthBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Click on the "Store Currency Cards" breadcrumb
        WebElement onlineGameServicesBreadcrumb = driver.findElement(By.xpath("(//span[@class='a-list-item'])[4]//a"));
        wait.until(ExpectedConditions.elementToBeClickable(onlineGameServicesBreadcrumb));
        onlineGameServicesBreadcrumb.click();

        // 3. Verify that the user was navigated back to the Best Sellers web page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']")));
        String currentPageTitle = driver.getTitle();

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentPageTitle.contains("Store Currency Cards"));
    }

    @Test
    public void playstationGiftCardPrice() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Verify that there is a price displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price")));
        List<WebElement> giftCardPrice = driver.findElements(By.id("price"));

        Assert.assertTrue("There should be a price displayed next to the product image", giftCardPrice.size() != 0);
    }

    @Test
    public void playstationGiftCardDetails() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Verify that there is a description displayed in the product's detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productDescription")));
        String productDescriptionText = driver.findElement(By.id("productDescription")).getText();

        Assert.assertTrue("There should be text displayed in the product description", productDescriptionText != "");
    }

    @Test
    public void playstationGiftCardRatings() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Verify that there are reviews in the product's detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acrCustomerReviewText")));
        int numOfProductRatings = Integer.parseInt(driver.findElement(By.id("acrCustomerReviewText")).getText().replaceAll("[^\\d.]", ""));

        Assert.assertTrue("There should be ratings available for a best selling product", numOfProductRatings > 0);
    }

    @Test
    public void cartCount1() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Add the item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 3. Verify that the cart count via navigation bar has increased
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
        int cartCount = Integer.parseInt(driver.findElement(By.id("nav-cart-count")).getText());

        Assert.assertTrue("Cart count should be increased to 1", cartCount == 1);
    }

    @Test
    public void cartCount2() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Change the quantity to 2
        // This wait is used for the savings button to finish loading before interacting with the quantity dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instantsavings-button-text")));
        WebElement quantityDropdown = driver.findElement(By.id("quantity"));
        // Unable to select with Select due to element being obscured by the span element
        Actions action = new Actions(driver);
        action.moveToElement(quantityDropdown).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_1")));
        WebElement quantityTwo = driver.findElement(By.id("quantity_1"));
        quantityTwo.click();

        // 3. Add the products to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 4. Verify that the cart count via navigation bar has increased
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
        int cartCount = Integer.parseInt(driver.findElement(By.id("nav-cart-count")).getText());

        Assert.assertTrue("Cart count should be increased to 1", cartCount == 2);
    }

    // Cart tests
    @Test
    public void playstationGiftCardAddToCart() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Add the item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 3. Verify that there was confirmation that the item was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("huc-v2-order-row-confirm-text")));
        String addedToCartConfirmation = driver.findElement(By.id("huc-v2-order-row-confirm-text")).getText();

        Assert.assertTrue("Confirmation should be displayed that the product was added to cart", addedToCartConfirmation.contains("Added to Cart"));

        // 4. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 5. Verify that the item was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-buybox")));
        String subtotal = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
        double numOfSubtotal = Double.parseDouble(subtotal.replace("$", ""));

        Assert.assertTrue("Subtotal should include the price of the item added", numOfSubtotal > 0);
    }

    @Test
    public void playstationGiftCardOneHundredAddToCart() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Open the gift card denomination dropdown
        // This wait is used for the savings button to finish loading before interacting with the denomination dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instantsavings-button-text")));
        WebElement giftCardValueDropdown = driver.findElement(By.id("vodd-button-denomination"));
        giftCardValueDropdown.click();

        // 3. Select $100 as the denomination
        // This xpath was used since there is a bug where the tr element can not be scrolled into view (https://bugzilla.mozilla.org/show_bug.cgi?id=1448825)
        WebElement giftCardValueOneHundred = driver.findElement(By.xpath("//tr[@id='denomination_1']//td"));
        wait.until(ExpectedConditions.elementToBeClickable(giftCardValueOneHundred));
        // Actions used due to element being obscured
        Actions action = new Actions(driver);
        action.moveToElement(giftCardValueOneHundred).click().perform();

        // 4. Add the item to cart
        // This wait is used for the digital price to be updated, so that once its updated, clicking on the "Add to Cart" button will be responsive
        WebElement digitalPriceUpdate = driver.findElement(By.xpath("//span[@id='digital-button-price']//span[@class='majorValue']"));
        wait.until(ExpectedConditions.textToBePresentInElement(digitalPriceUpdate,"100"));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 5. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 6. Verify that the $100 gift card was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-buybox")));
        String subtotal = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
        double subtotalNum = Double.parseDouble(subtotal.replace("$", ""));

        Assert.assertTrue("Subtotal should include the price of the item added", subtotalNum == 100.00);
    }

    @Test
    public void playstationGiftCardQuantityTwoAddToCart() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Change the quantity to 2
        // This wait is used for the savings button to finish loading before interacting with the quantity dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instantsavings-button-text")));
        WebElement quantityDropdown = driver.findElement(By.id("quantity"));
        // Unable to select with Select due to element being obscured by the span element
        Actions action = new Actions(driver);
        action.moveToElement(quantityDropdown).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quantity_1")));
        driver.findElement(By.id("quantity_1")).click();

        // 3. Add the products to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 4. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 5. Verify that the item was added to cart with a quantity of 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-dropdown-prompt")));
        int itemQuantity = Integer.parseInt(driver.findElement(By.className("a-dropdown-prompt")).getText());

        Assert.assertEquals(2, itemQuantity);
    }

    @Test
    public void playstationGiftCardCartDelete() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Add the item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 3. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 4. Delete the item from cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Delete']")));
        WebElement deleteLink = driver.findElement(By.xpath("//input[@value='Delete']"));
        deleteLink.click();

        // 5. Verify that the item was deleted from cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='sc-empty-cart-header']")));
        String emptyShoppingCartText = driver.findElement(By.xpath("//h1[@class='sc-empty-cart-header']")).getText();

        Assert.assertTrue("There should be text stating that the user's shopping cart is empty", emptyShoppingCartText.contains("empty"));
    }

    @Test
    public void playstationGiftCardCartQuantity2() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Add the item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 3. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 4. Increase the quantity of the product to 2
        WebElement quantityDropdown = driver.findElement(By.cssSelector(".sc-action-quantity select"));
        wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown));
        Actions action = new Actions(driver);
        action.moveToElement(quantityDropdown).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown1_2")));
        driver.findElement(By.id("dropdown1_2")).click();

        // 5. Verify that the quantity of the product is now 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-dropdown-prompt']")));
        int productQuantity = Integer.parseInt(driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText());

        Assert.assertTrue("The user should be able to change the quantity of the product to 2 via cart", productQuantity == 2);
    }

    @Test
    public void playstationGiftCardQuantity2CartPrice() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Add the item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 3. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 4. Increase the quantity of the product to 2
        WebElement quantityDropdown = driver.findElement(By.cssSelector(".sc-action-quantity select"));
        wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown));
        Actions action = new Actions(driver);
        action.moveToElement(quantityDropdown).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown1_2")));
        driver.findElement(By.id("dropdown1_2")).click();

        // 5. Verify that the subtotal includes the price for 2 of the same product
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-quantity='2']")));
        String subtotalText = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();

        Assert.assertTrue("The user should be able to change the quantity of the product to 2 via cart", subtotalText.contains("2"));
    }

    @Test
    public void playstationGiftCardCartSave() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Add the item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 3. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 4. Save the product for later
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-save-for-later")));
        WebElement saveForLaterLink = driver.findElement(By.cssSelector("span.sc-action-save-for-later"));
        saveForLaterLink.click();

        // 5. Verify that the item was saved for later
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-saved-cart-list-caption-text")));
        String savedForLaterHeader = driver.findElement(By.id("sc-saved-cart-list-caption-text")).getText();

        Assert.assertTrue("There should be 1 item saved for later", savedForLaterHeader.contains("1"));
    }

    @Test
    public void playstationGiftCardCartSaveMoveToCart() {
        // 1. Go to the PlayStation gift card url
        driver.get(playstationGiftCardPage);

        // 2. Add the item to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        // 3. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 4. Save the product for later
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-save-for-later")));
        WebElement saveForLaterLink = driver.findElement(By.cssSelector("span.sc-action-save-for-later"));
        saveForLaterLink.click();

        // 5. Move the saved item back to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-move-to-cart")));
        WebElement moveToCartLink = driver.findElement(By.cssSelector("span.sc-action-move-to-cart"));
        moveToCartLink.click();

        // 6. Verify that the item that was saved for later was moved back in the cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-save-for-later")));
        List<WebElement> saveForLaterLinkShouldExist = driver.findElements(By.cssSelector("span.sc-action-save-for-later"));

        Assert.assertTrue("There should be 1 item saved for later", saveForLaterLinkShouldExist.size() != 0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
