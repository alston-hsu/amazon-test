package tests;

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
import pages.EchoDotPage;
import pages.HomePage;
import pages.PlaystationGiftCardPage;
import utils.WebUtil;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;


public class AllTests extends BaseTest {
    // Home Page tests
    @Test
    public void clickLeftArrowHeroCarousel() {
        // 1. Go to the home page
        HomePage homePage = WebUtil.goToHomePage(driver);

        // 2. Click on the left arrow for the hero carousel
        String currentImage = homePage.getImageAlternativeText(driver);
        homePage.clickLeftArrowCarousel(driver);

        // 3. Verify that the previous slide in the carousel was displayed
        String previousImage = homePage.getImageAlternativeText(driver);

        Assert.assertTrue("The previous picture for the hero carousel should be displayed", homePage.didImageChange(driver, currentImage, previousImage));
    }

    @Test
    public void clickRightArrowHeroCarousel() {
        // 1. Go to the home page
        HomePage homePage = WebUtil.goToHomePage(driver);

        // 2. Click on the right arrow for the hero carousel
        String currentImage = homePage.getImageAlternativeText(driver);
        homePage.clickRightArrowCarousel(driver);

        // 3. Verify that the next slide in the carousel was displayed
        String nextImage = homePage.getImageAlternativeText(driver);

        Assert.assertTrue("The next picture for the hero carousel should be displayed", homePage.didImageChange(driver, currentImage, nextImage));
    }

    // Product Detail Page (PDP) tests (low customization)
    @Test
    public void playstationGiftCardImageCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there is a main image displayed in the product's detail page
        Assert.assertTrue("The next picture for the hero carousel should be displayed", playstationGiftCardPage.wasMainImageDisplayed(driver));
    }

    @Test
    public void playstationGiftCardFirstBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Video Games" breadcrumb
        playstationGiftCardPage.clickVideoGamesBreadcrumb(driver);

        // 3. Verify that the user was navigated to the Video Games web page
        Assert.assertTrue("The next picture for the hero carousel should be displayed", playstationGiftCardPage.doesVideoGamesBreadcrumbNavigateProperly(driver));
    }

    @Test
    public void playstationGiftCardSecondBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Online Game Services" breadcrumb
        playstationGiftCardPage.clickOnlineGameServicesBreadcrumb(driver);

        // 3. Verify that the user was navigated to the Online Game Services web page
        Assert.assertTrue("The next picture for the hero carousel should be displayed", playstationGiftCardPage.doesOnlineGameServicesBreadcrumbNavigateProperly(driver));
    }

    @Test
    public void playstationGiftCardThirdBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "PlayStation Network" breadcrumb
        playstationGiftCardPage.clickPlaystationNetworkBreadcrumb(driver);

        // 3. Verify that the user was navigated back to the Best Sellers web page
        Assert.assertTrue("The next picture for the hero carousel should be displayed", playstationGiftCardPage.doesPlaystationNetworkBreadcrumbNavigateProperly(driver));
    }

    @Test
    public void playstationGiftCardFourthBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Store Currency Cards" breadcrumb
        playstationGiftCardPage.clickPlaystationStoreCurrencyCardsBreadcrumb(driver);

        // 3. Verify that the user was navigated back to the Best Sellers web page
        Assert.assertTrue("The next picture for the hero carousel should be displayed", playstationGiftCardPage.doesPlaystationStoreCurrencyCardsBreadcrumbNavigateProperly(driver));
    }

    @Test
    public void playstationGiftCardPriceCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there is a price displayed
        Assert.assertTrue("There should be a price displayed next to the product image", playstationGiftCardPage.wasPriceDisplayed(driver));
    }

    @Test
    public void playstationGiftCardDetailsCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there is a description displayed in the product's detail page
        Assert.assertTrue("There should be text displayed in the product description", playstationGiftCardPage.wereDetailsDisplayed(driver));
    }

    @Test
    public void playstationGiftCardRatingsCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there are reviews in the product's detail page
        Assert.assertTrue("There should be ratings available for a best selling product", playstationGiftCardPage.wereReviewsAvailable(driver));
    }

    @Test
    public void cartCountOne() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Add the item to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 3. Verify that the cart count via navigation bar has increased
        Assert.assertTrue("Cart count should be increased to 1", playstationGiftCardPage.didCartCountIncrease(driver, 1));
    }

    @Test
    public void cartCountTwo() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2
        playstationGiftCardPage.increaseQuantityToTwo(driver);

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Verify that the cart count via navigation bar has increased
        Assert.assertTrue("Cart count should be increased to 2", playstationGiftCardPage.didCartCountIncrease(driver, 2));
    }

    // Product Detail Page tests with lots of customization
    @Test
    public void echoDotColorsCheck() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Verify that there are multiple colors available
        Assert.assertTrue("There should be more than one color available for the Echo Dot", echoDotPage.wereMultipleColorsAvailable(driver));
    }

    @Test
    public void echoDotConfigurationsCheck() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Verify that there are multiple configurations available
        Assert.assertTrue("There should be more than one color available for the Echo Dot", echoDotPage.wereMultipleConfigurationsAvailable(driver));
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
    public void playstationGiftCardOneHundredDenominationAddToCart() {
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
        WebElement quantityTwo = driver.findElement(By.id("quantity_1"));
        quantityTwo.click();

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
    public void playstationGiftCardQuantityMaxTwoAddToCart() {
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

        // 4. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 5. Navigate back to the product detail page
        WebElement productHyperlink = driver.findElement(By.xpath("//span[@class='a-list-item']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(productHyperlink));
        productHyperlink.click();

        // 6. Add the same product to cart again
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 7. Verify that the item is limited to a max quantity of 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-alert-content")));
        String problemAddingItemText = driver.findElement(By.className("a-alert-content")).getText();

        Assert.assertTrue("There should be an alert stating that there is a limit of 2 per customer for this product", problemAddingItemText.contains("limit of 2"));
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
    public void playstationGiftCardCartQuantityTwo() {
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
        WebElement quantityTwo = driver.findElement(By.id("dropdown1_2"));
        quantityTwo.click();

        // 5. Verify that the quantity of the product is now 2
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-dropdown-prompt']")));
        int productQuantity = Integer.parseInt(driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText());

        Assert.assertTrue("The user should be able to change the quantity of the product to 2 via cart", productQuantity == 2);
    }

    @Test
    public void playstationGiftCardQuantityTwoCartPrice() {
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

        // 4. Navigate to cart
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();

        // 5. Verify that the subtotal includes the price for 2 of the same product
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-subtotal-amount-buybox")));
        Double subtotal = Double.parseDouble(driver.findElement(By.id("sc-subtotal-amount-buybox")).getText().replace("$", ""));

        Assert.assertTrue("The subtotal should be updated to $20", subtotal == 20.00);
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
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.sc-action-save-for-later")));
        WebElement saveForLaterLink = driver.findElement(By.cssSelector("span.sc-action-save-for-later"));
        saveForLaterLink.click();

        // 5. Verify that the item was saved for later
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sc-saved-cart-list-caption-text")));
        String savedForLaterHeader = driver.findElement(By.id("sc-saved-cart-list-caption-text")).getText();

        Assert.assertTrue("There should be 1 item saved for later", savedForLaterHeader.contains("1"));
    }

    @Test
    public void playstationGiftCardCartSaveMoveBackToCart() {
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

    @Test
    public void echoDotPlumColorAddToCart() {
        // 1. Go to the Echo Dot url
        driver.get(echoDotPage);

        // 2. Click on the plum color
        WebElement plumColor = driver.findElement(By.id("color_name_2"));
        wait.until(ExpectedConditions.elementToBeClickable(plumColor));
        plumColor.click();

        // 3. Add the item to cart
        // Added a wait for the page to "refresh" after clicking on the plum color. Using "refreshed" as an ExpectedCondition for the Add To Cart button fails half of the time.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("productTitle"), "Plum"));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 4. Close the optional protection plans modal
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.a-button-close")));
        WebElement closeButton = driver.findElement(By.cssSelector("button.a-button-close"));
        closeButton.click();

        // 5. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 6. Verify that the product was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-product-title")));
        WebElement productTitleElement = driver.findElement(By.cssSelector("span.sc-product-title"));
        String productTitle = productTitleElement.getText();

        Assert.assertTrue("There should be a plum colored Echo Dot added to cart", productTitle.contains("Plum"));
    }

    @Test
    public void echoDotSandstoneColorTenHueSmartBulbsAddToCart() {
        // 1. Go to the Echo Dot url
        driver.get(echoDotPage);

        // 2. Click on the sandstone color
        WebElement sandstoneColor = driver.findElement(By.id("color_name_3"));
        wait.until(ExpectedConditions.elementToBeClickable(sandstoneColor));
        sandstoneColor.click();

        // 3. Select "with $10 Hue Smart Bulbs (white)" as the configuration
        WebElement tenHueSmartBulbsWhiteColor = driver.findElement(By.id("configuration_1"));
        // Waiting until the page updates with the color selected
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("productTitle"), "Sandstone"));
        tenHueSmartBulbsWhiteColor.click();

        // 4. Add the item to cart
        // Added a wait for the page to "refresh" after clicking on the "with $10 Hue Smart Bulbs (white)" configuration. Using "refreshed" as an ExpectedCondition for the Add To Cart button fails half of the time.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("productTitle"), "Bundle with Philips"));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Close the optional protection plans modal
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.a-button-close")));
        //WebElement closeButton = driver.findElement(By.cssSelector("button.a-button-close"));
        //closeButton.click();

        // 6. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 7. Verify that the product was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-product-title")));
        WebElement productTitleElement = driver.findElement(By.cssSelector("span.sc-product-title"));
        String productTitle = productTitleElement.getText();

        Assert.assertTrue("There should be a sandstone colored Echo Dot with a bundle of smart bulbs added to cart", productTitle.contains("Sandstone Bundle with Philips"));
    }

    @Test
    public void echoDotSandstoneColorWithClockAndEchoAutoAddToCart() {
        // 1. Go to the Echo Dot url
        driver.get(echoDotPage);

        // 2. Click on the "Echo Dot with clock (Sandstone only)" style
        WebElement echoDotWithClock = driver.findElement(By.id("style_name_1"));
        wait.until(ExpectedConditions.elementToBeClickable(echoDotWithClock));
        echoDotWithClock.click();

        // 3. Select "with Echo Auto" as the configuration
        WebElement echoAuto = driver.findElement(By.id("configuration_3"));
        // Waiting until the page updates with the style selected
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("productTitle"), "Sandstone"));
        echoAuto.click();

        // 4. Add the item to cart
        // Added a wait for the page to "refresh" after clicking on the "with $10 Hue Smart Bulbs (white)" configuration. Using "refreshed" as an ExpectedCondition for the Add To Cart button fails half of the time.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("productTitle"), "Bundle with Echo Auto"));
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        // 5. Close the optional protection plans modal
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.a-button-close")));
        //WebElement closeButton = driver.findElement(By.cssSelector("button.a-button-close"));
        //closeButton.click();

        // 6. Navigate to cart
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hlb-view-cart-announce")));
        WebElement cartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        cartButton.click();

        // 7. Verify that the product was added to cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sc-product-title")));
        WebElement productTitleElement = driver.findElement(By.cssSelector("span.sc-product-title"));
        String productTitle = productTitleElement.getText();

        Assert.assertTrue("There should be a sandstone colored Echo Dot (with clock) bundle with Echo Auto", productTitle.contains("(Sandstone) Bundle with Echo Auto"));
    }

    @Test
    public void loginTest() {
        // 1. Go to the home page
        //driver.get(homePage);

        // 2. Click on the account link via navigation bar
        WebElement accountLinkNavBar = driver.findElement(By.id("nav-link-accountList"));
        wait.until(ExpectedConditions.elementToBeClickable(accountLinkNavBar));
        accountLinkNavBar.click();

        // 3. Type in your username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        WebElement usernameField = driver.findElement(By.id("ap_email"));
        usernameField.sendKeys(username);

        // 4. Click on the Continue button
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        // 5. Type in your password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys(password);

        // 6. Click on the "Sign-In" button
        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();

        // 7. Verify that there is a authentication needed message displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-row a-spacing-small']/h1")));
        WebElement headerElement = driver.findElement(By.xpath("//div[@class='a-row a-spacing-small']/h1"));
        String headerText = headerElement.getText();

        Assert.assertTrue("There should be a message stating authentication is required", headerText.contains("Authentication required"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}