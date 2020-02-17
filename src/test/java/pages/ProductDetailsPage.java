package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtil;

public interface ProductDetailsPage {

    public void clickAddToCartButton(WebDriver driver);

    public void increaseQuantityToTwo(WebDriver driver);

    public CartPage clickCartButton(WebDriver driver);

    public boolean wasMainImageDisplayed(WebDriver driver);

    public boolean wasPriceDisplayed(WebDriver driver);

    public boolean wereDetailsDisplayed(WebDriver driver);

    public boolean wereReviewsAvailable(WebDriver driver);

    public boolean didCartCountIncrease(WebDriver driver, int quantityOfProductAdded);

    public boolean wasCartAddConfirmationDisplayed(WebDriver driver);
}
