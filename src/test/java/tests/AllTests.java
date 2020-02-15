package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.EchoDotPage;
import pages.HomePage;
import pages.PlaystationGiftCardPage;
import utils.WebUtil;


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
        Assert.assertTrue("The PlayStation gift card's main image should be displayed", playstationGiftCardPage.wasMainImageDisplayed(driver));
    }

    @Test
    public void playstationGiftCardFirstBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Video Games" breadcrumb
        playstationGiftCardPage.clickVideoGamesBreadcrumb(driver);

        // 3. Verify that the user was navigated to the Video Games web page
        Assert.assertTrue("Clicking the first breadcrumb should navigate to the Video Games webpage", playstationGiftCardPage.doesVideoGamesBreadcrumbNavigateProperly(driver));
    }

    @Test
    public void playstationGiftCardSecondBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Online Game Services" breadcrumb
        playstationGiftCardPage.clickOnlineGameServicesBreadcrumb(driver);

        // 3. Verify that the user was navigated to the Online Game Services web page
        Assert.assertTrue("Clicking the second breadcrumb should navigate to the Online Game Services webpage", playstationGiftCardPage.doesOnlineGameServicesBreadcrumbNavigateProperly(driver));
    }

    @Test
    public void playstationGiftCardThirdBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "PlayStation Network" breadcrumb
        playstationGiftCardPage.clickPlaystationNetworkBreadcrumb(driver);

        // 3. Verify that the user was navigated back to the Best Sellers web page
        Assert.assertTrue("Clicking the third breadcrumb should navigate to the PlayStation Network webpage", playstationGiftCardPage.doesPlaystationNetworkBreadcrumbNavigateProperly(driver));
    }

    @Test
    public void playstationGiftCardFourthBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Store Currency Cards" breadcrumb
        playstationGiftCardPage.clickPlaystationStoreCurrencyCardsBreadcrumb(driver);

        // 3. Verify that the user was navigated back to the Best Sellers web page
        Assert.assertTrue("Clicking the fourth breadcrumb should navigate to the PlayStation Store Currency Cards webpage", playstationGiftCardPage.doesPlaystationStoreCurrencyCardsBreadcrumbNavigateProperly(driver));
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
        Assert.assertTrue("There should be text displayed for the product description", playstationGiftCardPage.wereDetailsDisplayed(driver));
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
        Assert.assertTrue("There should be multiple configurations available for the Echo Dot", echoDotPage.wereMultipleConfigurationsAvailable(driver));
    }

    // Cart tests
    @Test
    public void playstationGiftCardAddToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Add the item to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 3. Verify that there was confirmation that the item was added to cart
        playstationGiftCardPage.wasCartAddConfirmationDisplayed(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Verify that the item was added to cart
        Assert.assertTrue("Product images should be displayed for anything added to cart", cartPage.wereProductsAddedToCart(driver));
    }

    @Test
    public void playstationGiftCardOneHundredDenominationAddToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Select $100 as the denomination
        playstationGiftCardPage.selectOneHundredAsValue(driver);

        // 3. Add the item to cart
        // This wait is used for the digital price to be updated, so that once its updated, clicking on the "Add to Cart" button will be responsive
        playstationGiftCardPage.waitForValueToUpdate(driver, "100");
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 5. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 6. Verify that the $100 gift card was added to cart
        Assert.assertTrue("There should be a PlayStation gift card worth $100 in cart", cartPage.didSubtotalMatchValue(driver, 100.00));
    }

    @Test
    public void playstationGiftCardQuantityTwoAddToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2
        playstationGiftCardPage.increaseQuantityToTwo(driver);

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Verify that the item was added to cart with a quantity of 2
        Assert.assertEquals(2, cartPage.getQuantity(driver));
    }

    @Test
    public void playstationGiftCardQuantityMaxTwoAddToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2
        playstationGiftCardPage.increaseQuantityToTwo(driver);

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Navigate back to the product detail page
        playstationGiftCardPage = cartPage.clickPlaystationGiftCardLink(driver);

        // 6. Add the same product to cart again
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 7. Verify that the item is limited to a max quantity of 2
        Assert.assertTrue("There should be a message stating that a limit of 2 PlayStation gift cards are only available per customer", playstationGiftCardPage.wasLimitOfTwoTextDisplayed(driver));
    }

    @Test
    public void playstationGiftCardCartDelete() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Add the item to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 3. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 4. Delete the item from cart
        cartPage.clickDelete(driver);

        // 5. Verify that the item was deleted from cart
        Assert.assertTrue("Removing the PlayStation gift card from cart should be possible", cartPage.wasProductRemovedFromCart(driver));
    }

    @Test
    public void playstationGiftCardCartQuantityTwo() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Add the item to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 3. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 4. Increase the quantity of the product to 2
        cartPage.increaseQuantity(driver);

        // 5. Verify that the quantity of the product is now 2
        Assert.assertTrue("Changing a product's quantity to 2 should be possible via cart webpage", cartPage.wasQuantityIncreased(driver));
    }

    @Test
    public void playstationGiftCardQuantityTwoCartPrice() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2
        playstationGiftCardPage.increaseQuantityToTwo(driver);

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Verify that the subtotal includes the price for 2 of the same product
        Assert.assertTrue("Adding 2 PlayStation gift cards worth $10 each to cart should increase the subtotal to $20", cartPage.doesSubtotalUpdateWithProductsAdded(driver));
    }

    @Test
    public void playstationGiftCardCartSave() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Add the item to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 3. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 4. Save the product for later
        cartPage.saveForLater(driver);

        // 5. Verify that the item was saved for later
        Assert.assertTrue("There should be 1 item saved for later", cartPage.wasProductSavedForLater(driver));
    }

    @Test
    public void playstationGiftCardCartSaveMoveBackToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Add the item to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 3. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 4. Save the product for later
        cartPage.saveForLater(driver);

        // 5. Move the saved item back to cart
        cartPage.moveToCart(driver);

        // 6. Verify that the item that was saved for later was moved back in the cart
        Assert.assertTrue("A product should be able to be saved for later, and then moved back into a cart", cartPage.wasSavedItemMovedBackToCart(driver));
    }

    @Test
    public void echoDotPlumColorAddToCart() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Click on the plum color
        echoDotPage.clickPlumColor(driver);

        // 3. Add the item to cart
        echoDotPage.waitForPageUpdate(driver, "Plum");
        echoDotPage.clickAddToCartButton(driver);

        // 4. Close the optional protection plans modal
        echoDotPage.clickCloseButton(driver);

        // 5. Navigate to cart
        CartPage cartPage = echoDotPage.clickCartButton(driver);

        // 6. Verify that the product was added to cart
        Assert.assertTrue("There should be a plum colored Echo Dot added to cart", cartPage.wasEchoDotInCart(driver));
    }

    @Test
    public void echoDotSandstoneColorTenHueSmartBulbsAddToCart() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Click on the sandstone color
        echoDotPage.clickSandstoneColor(driver);

        // 3. Select "with $10 Hue Smart Bulbs (white)" as the configuration
        echoDotPage.waitForPageUpdate(driver, "Sandstone");
        echoDotPage.click10HueConfig(driver);

        // 4. Add the item to cart
        echoDotPage.waitForPageUpdate(driver, "Bundle with Philips");
        echoDotPage.clickAddToCartButton(driver);

        // 5. Navigate to cart
        CartPage cartPage = echoDotPage.clickCartButton(driver);

        // 6. Verify that the product was added to cart
        Assert.assertTrue("There should be a sandstone colored Echo Dot with a bundle of Philips smart bulbs added to cart", cartPage.wasSandstoneEchoDotWith10HueInCart(driver));
    }

    @Test
    public void echoDotSandstoneColorWithClockAndEchoAutoAddToCart() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Click on the "Echo Dot with clock (Sandstone only)" style
        echoDotPage.clickWithClockStyle(driver);

        // 3. Select "with Echo Auto" as the configuration
        echoDotPage.waitForPageUpdate(driver, "Sandstone");
        echoDotPage.clickEchoAutoConfig(driver);

        // 4. Add the item to cart
        echoDotPage.waitForPageUpdate(driver, "Bundle with Echo Auto");
        echoDotPage.clickAddToCartButton(driver);

        // 5. Navigate to cart
        CartPage cartPage = echoDotPage.clickCartButton(driver);

        // 6. Verify that the product was added to cart
        Assert.assertTrue("There should be a sandstone colored Echo Dot (with clock) bundle with Echo Auto in cart", cartPage.wasSandstoneEchoDotWithClockAndEchoAutoInCart(driver));
    }

    @Test
    public void loginTest() {
        // 1. Go to the home page
        HomePage homePage = WebUtil.goToHomePage(driver);

        // 2. Click on the account link via navigation bar
        homePage.clickAccountNavBar(driver);

        // 3. Type in your username
        homePage.typeInUsername(driver);

        // 4. Click on the Continue button
        homePage.clickContinueButton(driver);

        // 5. Type in your password
        homePage.typeInPassword(driver);

        // 6. Click on the "Sign-In" button
        homePage.clickSignInButton(driver);

        // 7. Verify that there is a authentication needed message displayed
        Assert.assertTrue("There should be a message stating authentication is required", homePage.wasAuthenticationMessageDisplayed(driver));
    }
}