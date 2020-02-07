import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AllTests {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    String homePage = "https://www.amazon.com/";

    // Home Page tests
    @Test
    public void clickLeftHeroCarousel() {
        // 1. Go to the home page
        driver.get(homePage);
        String currentImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        // 2. Click on the left arrow for the hero carousel
        wait.until(ExpectedConditions.elementToBeClickable(By.className("a-carousel-goto-prevpage")));
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
        wait.until(ExpectedConditions.elementToBeClickable(By.className("a-carousel-goto-nextpage")));
        WebElement rightArrowCarousel = driver.findElement(By.className("a-carousel-goto-nextpage"));
        rightArrowCarousel.click();

        // 3. Verify that the next slide in the carousel was displayed
        String nextImage = driver.findElement(By.xpath("//div[@id='desktop-banner']//img")).getAttribute("alt");

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentImage != nextImage);
    }

    // Product Detail Page (PDP) tests
    @Test
    public void bestSellingToyImagePDP() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Verify that there is a main image displayed in the product's detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imgTagWrapperId")));
        WebElement firstBestSellingImagePDP = driver.findElement(By.id("imgTagWrapperId"));

        Assert.assertTrue("The next picture for the hero carousel should be displayed", firstBestSellingImagePDP.getSize().getWidth() != 0);
    }

    @Test
    public void bestSellingToyBreadcrumbPDP() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        String bestSellersUrl = driver.getCurrentUrl();
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Click on the "Back to results" breadcrumb
        wait.until(ExpectedConditions.elementToBeClickable(By.id("breadcrumb-back-link")));
        WebElement backToResultsLink = driver.findElement(By.id("breadcrumb-back-link"));
        backToResultsLink.click();

        // 5. Verify that the user was navigated back to the Best Sellers web page
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue("The next picture for the hero carousel should be displayed", currentUrl.contains(bestSellersUrl));
    }

    @Test
    public void bestSellingToyPricePDP() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Verify that there is a main image displayed in the product's detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("priceblock_ourprice")));
        List<WebElement> priceOutsideBuyBox = driver.findElements(By.id("priceblock_ourprice"));
        List<WebElement> priceInsideBuyBox = driver.findElements(By.id("price_inside_buybox"));

        Assert.assertTrue("There should be a price displayed next to the product image", priceOutsideBuyBox.size() != 0);
        Assert.assertTrue("There should be a price displayed next to the product image", priceInsideBuyBox.size() != 0);
    }

    @Test
    public void bestSellingToyDetailsPDP() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Verify that there is a description in the product's detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productDescription")));
        String productDescriptionText = driver.findElement(By.id("productDescription")).getText();

        Assert.assertTrue("There should be text displayed in the product description", productDescriptionText != "");
    }

    @Test
    public void bestSellingToyReviewsPDP() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Verify that there are reviews in the product's detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acrCustomerReviewText")));
        int numOfProductRatings = Integer.parseInt(driver.findElement(By.id("acrCustomerReviewText")).getText().replaceAll("[^\\d.]", ""));

        Assert.assertTrue("There should be ratings available for a best selling product", numOfProductRatings > 0);
    }

    @Test
    public void cartCount1() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Verify that the cart count via navigation bar has increased
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
        int cartCount = Integer.parseInt(driver.findElement(By.id("nav-cart-count")).getText());

        Assert.assertTrue("Cart count should be increased to 1", cartCount == 1);
    }

    // Cart tests
    @Test
    public void bestSellingToyAddToCart() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Verify that there was confirmation that the item was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("huc-v2-order-row-confirm-text")));
        String addedToCartConfirmation = driver.findElement(By.id("huc-v2-order-row-confirm-text")).getText();

        Assert.assertTrue("Confirmation should be displayed that the product was added to cart", addedToCartConfirmation.contains("Added to Cart"));

        // 6. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 7. Verify that the item was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-buybox")));
        String subtotal = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
        double numOfSubtotal = Double.parseDouble(subtotal.replace("$", ""));

        Assert.assertTrue("Subtotal should include the price of the item added", numOfSubtotal > 0);
    }

    @Test
    public void bestSellingToyQuantityTwoAddToCart() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Change the quantity to 2
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-dropdown-label']")));
        WebElement quantityDropdown = driver.findElement(By.xpath("//span[@class='a-dropdown-label']"));
        // Unable to select with Select due to element being obscured by the span element
        Actions action = new Actions(driver);
        action.moveToElement(quantityDropdown).click().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity_1")));
        driver.findElement(By.id("quantity_1")).click();

        // 5. Add the products to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Verify that there was confirmation that the item was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("huc-v2-order-row-confirm-text")));
        String addedToCartConfirmation = driver.findElement(By.id("huc-v2-order-row-confirm-text")).getText();

        Assert.assertTrue("Confirmation should be displayed that the product was added to cart", addedToCartConfirmation.contains("Added to Cart"));

        // 6. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 7. Verify that the item was added to cart with a quantity of 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-dropdown-prompt")));
        int itemQuantity = Integer.parseInt(driver.findElement(By.className("a-dropdown-prompt")).getText());

        Assert.assertEquals(2, itemQuantity);
    }

    @Test
    public void bestSellingToyCartDelete() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 6. Delete the item from cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Delete']")));
        WebElement deleteLink = driver.findElement(By.xpath("//input[@value='Delete']"));
        deleteLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='sc-empty-cart-header']")));
        String emptyShoppingCartText = driver.findElement(By.xpath("//h1[@class='sc-empty-cart-header']")).getText();

        Assert.assertTrue("There should be text stating that the user's shopping cart is empty", emptyShoppingCartText.contains("empty"));
    }

    @Test
    public void bestSellingToyCartQuantity2() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 6. Increase the quantity of the product to 2
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='a-autoid-0-announce']")));
        WebElement quantityDropdown = driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']"));
        Actions action = new Actions(driver);
        action.moveToElement(quantityDropdown).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown1_2")));
        driver.findElement(By.id("dropdown1_2")).click();

        // 7. Verify that the quantity of the product is now 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-dropdown-prompt']")));
        int productQuantity = Integer.parseInt(driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText());

        Assert.assertTrue("The user should be able to change the quantity of the product to 2 via cart", productQuantity == 2);
    }

    @Test
    public void bestSellingToyCartQuantity2Price() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 6. Increase the quantity of the product to 2
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".span.sc-action-quantity")));
        WebElement quantityDropdown = driver.findElement(By.cssSelector(".span.sc-action-quantity"));
        Actions action = new Actions(driver);
        action.moveToElement(quantityDropdown).click().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown1_2")));
        driver.findElement(By.id("dropdown1_2")).click();

        // 7. Verify that the subtotal includes the price for 2 of the same product
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-activecart")));
        double productPrice = Double.parseDouble(driver.findElement(By.cssSelector("span.sc-product-price")).getText().replace("$", ""));
        double cartSubtotal = Double.parseDouble(driver.findElement(By.id("sc-subtotal-amount-activecart")).getText().replace("$", ""));

        Assert.assertTrue("The user should be able to change the quantity of the product to 2 via cart", cartSubtotal == productPrice * 2);
    }

    @Test
    public void bestSellingToyCartGift() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 6. Mark the item as a gift
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sc-buy-box-gift-checkbox")));
        WebElement giftCheckbox = driver.findElement(By.id("sc-buy-box-gift-checkbox"));
        giftCheckbox.click();

        // 7. Verify that the gift checkboxes are checked
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@checked='']")));
        List<WebElement> checkedGiftCheckbox = driver.findElements(By.xpath("//input[@checked='']"));

        Assert.assertTrue("The user should be able to change the quantity of the product to 2 via cart", checkedGiftCheckbox.size() != 0);
    }

    @Test
    public void bestSellingToyCartSave() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 6. Save the product for later
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-save-for-later")));
        WebElement saveForLaterLink = driver.findElement(By.cssSelector("span.sc-action-save-for-later"));
        saveForLaterLink.click();

        // 7. Verify that the item was saved for later
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-saved-cart-list-caption-text")));
        String savedForLaterHeader = driver.findElement(By.id("sc-saved-cart-list-caption-text")).getText();

        Assert.assertTrue("There should be 1 item saved for later", savedForLaterHeader.contains("1"));
    }

    @Test
    public void bestSellingToyCartSaveMoveToCart() {
        // 1. Go to the home page
        driver.get(homePage);

        // 2. Click on the Best Sellers link via navigation bar
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-main']//a[@tabindex='48']")));
        WebElement bestSellersLink = driver.findElement(By.xpath("//div[@id='nav-main']//a[@tabindex='48']"));
        bestSellersLink.click();

        // 3. Click on the first best selling image
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='a-section a-spacing-mini']")));
        WebElement firstBestSellingImagePLP = driver.findElement(By.xpath("//div[@class='a-section a-spacing-mini']"));
        firstBestSellingImagePLP.click();

        // 4. Add the item to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 6. Save the product for later
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-save-for-later")));
        WebElement saveForLaterLink = driver.findElement(By.cssSelector("span.sc-action-save-for-later"));
        saveForLaterLink.click();

        // 7. Move the saved item back to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-move-to-cart")));
        WebElement moveToCartLink = driver.findElement(By.cssSelector("span.sc-action-move-to-cart"));
        moveToCartLink.click();

        // 8. Verify that the item that was saved for later was moved back in the cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-action-save-for-later")));
        List<WebElement> saveForLaterLinkShouldExist = driver.findElements(By.cssSelector("span.sc-action-save-for-later"));

        Assert.assertTrue("There should be 1 item saved for later", saveForLaterLinkShouldExist.size() != 0);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
