package pages;

import org.openqa.selenium.WebDriver;

public interface ProductDetailsPage {

    void clickAddToCartButton(WebDriver driver);

    void changeQuantity(WebDriver driver, String quantityOfProduct);

    CartPage clickCartButton(WebDriver driver);

    boolean wasMainImageDisplayed(WebDriver driver);

    boolean wasPriceDisplayed(WebDriver driver);

    boolean wereDetailsDisplayed(WebDriver driver);

    boolean wereReviewsAvailable(WebDriver driver);

    boolean didCartCountIncrease(WebDriver driver, int quantityOfProductAdded);

    boolean wasCartAddConfirmationDisplayed(WebDriver driver);
}
