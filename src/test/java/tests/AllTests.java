package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
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

        assertTrue(homePage.didImageChange(driver, currentImage, previousImage), "The previous picture for the hero carousel should be displayed");
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

        assertTrue(homePage.didImageChange(driver, currentImage, nextImage), "The next picture for the hero carousel should be displayed");
    }

    // Product Detail Page (PDP) tests (low customization)
    @Test
    public void playstationGiftCardImageCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there is a main image displayed in the product's detail page
        assertTrue(playstationGiftCardPage.wasMainImageDisplayed(driver), "The PlayStation gift card's main image should be displayed");
    }

    @Test
    public void playstationGiftCardFirstBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Video Games" breadcrumb
        playstationGiftCardPage.clickVideoGamesBreadcrumb(driver);

        // 3. Verify that the user was navigated to the Video Games web page
        assertTrue(playstationGiftCardPage.doesVideoGamesBreadcrumbNavigateProperly(driver), "Clicking the first breadcrumb should navigate to the Video Games webpage");
    }

    @Test
    public void playstationGiftCardSecondBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Online Game Services" breadcrumb
        playstationGiftCardPage.clickOnlineGameServicesBreadcrumb(driver);

        // 3. Verify that the user was navigated to the Online Game Services web page
        assertTrue(playstationGiftCardPage.doesOnlineGameServicesBreadcrumbNavigateProperly(driver), "Clicking the second breadcrumb should navigate to the Online Game Services webpage");
    }

    @Test
    public void playstationGiftCardThirdBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "PlayStation Network" breadcrumb
        playstationGiftCardPage.clickPlaystationNetworkBreadcrumb(driver);

        // 3. Verify that the user was navigated back to the Best Sellers web page
        assertTrue(playstationGiftCardPage.doesPlaystationNetworkBreadcrumbNavigateProperly(driver), "Clicking the third breadcrumb should navigate to the PlayStation Network webpage");
    }

    @Test
    public void playstationGiftCardFourthBreadcrumb() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Click on the "Store Currency Cards" breadcrumb
        playstationGiftCardPage.clickPlaystationStoreCurrencyCardsBreadcrumb(driver);

        // 3. Verify that the user was navigated back to the Best Sellers web page
        assertTrue(playstationGiftCardPage.doesPlaystationStoreCurrencyCardsBreadcrumbNavigateProperly(driver), "Clicking the fourth breadcrumb should navigate to the PlayStation Store Currency Cards webpage");
    }

    @Test
    public void playstationGiftCardPriceCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there is a price displayed
        assertTrue(playstationGiftCardPage.wasPriceDisplayed(driver), "There should be a price displayed next to the product image");
    }

    @Test
    public void playstationGiftCardDetailsCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there is a description displayed in the product's detail page
        assertTrue(playstationGiftCardPage.wereDetailsDisplayed(driver), "There should be text displayed for the product description");
    }

    @Test
    public void playstationGiftCardRatingsCheck() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Verify that there are reviews in the product's detail page
        assertTrue(playstationGiftCardPage.wereReviewsAvailable(driver), "There should be ratings available for a best selling product");
    }

    @Test
    public void cartCountOne() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Add the item to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 3. Verify that the cart count via navigation bar has increased
        assertTrue(playstationGiftCardPage.didCartCountIncrease(driver, 1), "Cart count should be increased to 1");
    }

    @Test
    public void cartCountTwo() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2... Quantity desired starts with 0 (0 = 1, 1 = 2, etc.)
        playstationGiftCardPage.waitForPageToLoad(driver);
        playstationGiftCardPage.changeQuantity(driver, "1");

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Verify that the cart count via navigation bar has increased
        assertTrue(playstationGiftCardPage.didCartCountIncrease(driver, 2), "Cart count should be increased to 2");
    }

    // Product Detail Page tests with lots of customization
    @Test
    public void echoDotColorsCheck() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Verify that there are multiple colors available
        assertTrue(echoDotPage.wereMultipleColorsAvailable(driver), "There should be more than one color available for the Echo Dot");
    }

    @Test
    public void echoDotConfigurationsCheck() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Verify that there are multiple configurations available
        assertTrue(echoDotPage.wereMultipleConfigurationsAvailable(driver), "There should be multiple configurations available for the Echo Dot");
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
        assertTrue(cartPage.wereProductsAddedToCart(driver), "The PlayStation gift card should be added to cart");
    }

    @Test
    public void playstationGiftCardOneHundredDenominationAddToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Select $100 as the denomination
        playstationGiftCardPage.selectOneHundredAsValue(driver);

        // 3. Add the item to cart
        playstationGiftCardPage.waitForPageUpdate(driver, "100");
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Verify that the $100 gift card was added to cart
        assertTrue(cartPage.didSubtotalMatchExpectedValue(driver, "$100"), "There should be a PlayStation gift card worth $100 in cart");
    }

    @Test
    public void playstationGiftCardQuantityTwoAddToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2... Quantity desired starts with 0 (0 = 1, 1 = 2, etc.)
        playstationGiftCardPage.waitForPageToLoad(driver);
        playstationGiftCardPage.changeQuantity(driver, "1");

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Verify that the item was added to cart with a quantity of 2
        assertEquals(2, cartPage.getQuantity(driver));
    }

    @Test
    public void playstationGiftCardQuantityMaxTwoAddToCart() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2...Quantity desired starts with 0 (0 = 1, 1 = 2, etc.)
        playstationGiftCardPage.waitForPageToLoad(driver);
        playstationGiftCardPage.changeQuantity(driver, "1");

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Try to change the quantity via cart
        cartPage.changeQuantity(driver, "3");

        // 6. Verify that the item is limited to a max quantity of 2
        assertTrue(cartPage.wasLimitOfTwoTextDisplayed(driver), "There should be a message stating that a limit of 2 PlayStation gift cards are only available per customer");
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
        assertTrue(cartPage.wasProductRemovedFromCart(driver), "Removing the PlayStation gift card from cart should be possible");
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
        cartPage.changeQuantity(driver, "2");

        // 5. Verify that the quantity of the product is now 2
        assertTrue(cartPage.wasQuantityIncreased(driver), "Changing the PlayStation gift card's quantity to 2 should be possible via cart webpage");
    }

    @Test
    public void playstationGiftCardQuantityTwoCartPrice() {
        // 1. Go to the PlayStation gift card url
        PlaystationGiftCardPage playstationGiftCardPage = WebUtil.goToPlayStationGiftCardPage(driver);

        // 2. Change the quantity to 2... Quantity desired starts with 0 (0 = 1, 1 = 2, etc.)
        playstationGiftCardPage.waitForPageToLoad(driver);
        playstationGiftCardPage.changeQuantity(driver, "1");

        // 3. Add the products to cart
        playstationGiftCardPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = playstationGiftCardPage.clickCartButton(driver);

        // 5. Verify that the subtotal includes the price for 2 of the same product
        assertTrue(cartPage.didSubtotalMatchExpectedValue(driver, "$20"), "Adding 2 $10 PlayStation gift cards to cart should have a subtotal of $20");
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
        assertTrue(cartPage.wasProductSavedForLater(driver), "The PlayStation gift card should be saved for later");
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
        assertTrue(cartPage.wasSavedItemMovedBackToCart(driver), "The PlayStation gift card should be able to be saved for later, and then moved back into cart");
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
        echoDotPage.clickContinueAndCloseForProtectionPlanModal(driver);

        // 5. Navigate to cart
        CartPage cartPage = echoDotPage.clickCartButton(driver);

        // 6. Verify that the product was added to cart
        assertTrue(cartPage.wasPlumEchoDotInCart(driver), "There should be a plum colored Echo Dot added to cart");
    }

    @Test
    public void echoDotSandstoneColorWithSmartPlugAddToCart() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Click on the sandstone color
        echoDotPage.clickSandstoneColor(driver);

        // 3. Select "with $5 Smart Plug" as the configuration
        echoDotPage.waitForPageUpdate(driver, "Sandstone");
        echoDotPage.clickFiveDollarSmartPlugConfig(driver);

        // 4. Add the item to cart
        echoDotPage.waitForPageUpdate(driver, "with TP-Link");
        echoDotPage.clickAddToCartButton(driver);

        // 5. Close the optional protection plans modal
        echoDotPage.clickContinueAndCloseForProtectionPlanModal(driver);

        // 6. Navigate to cart
        CartPage cartPage = echoDotPage.clickCartButton(driver);

        // 7. Verify that the product was added to cart
        assertTrue(cartPage.wasSandstoneEchoDotWithSmartPlugInCart(driver), "There should be a sandstone colored Echo Dot with a $5 Smart Plug added to cart");
    }

    @Test
    public void echoDotCharcoalColorWithEchoAutoAddToCart() {
        // 1. Go to the Echo Dot url
        EchoDotPage echoDotPage = WebUtil.goToEchoDotPage(driver);

        // 2. Select "with Echo Auto" as the configuration
        echoDotPage.clickEchoAutoConfig(driver);

        // 3. Add the item to cart
        echoDotPage.waitForPageUpdate(driver, "with Echo Auto");
        echoDotPage.clickAddToCartButton(driver);

        // 4. Navigate to cart
        CartPage cartPage = echoDotPage.clickCartButton(driver);

        // 5. Verify that the product was added to cart
        assertTrue(cartPage.wasCharcoalEchoDotWithEchoAutoInCart(driver), "There should be a charcoal Echo Dot with Echo Auto in cart");
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
        assertTrue(homePage.wasAuthenticationMessageDisplayed(driver), "There should be a message stating authentication is required");
    }
}