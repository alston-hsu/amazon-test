package tests;

import credentials.AmazonCredentialsManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    String playstationGiftCardPage = "https://www.amazon.com/gp/product/B00GAC1D2G/ref=ox_sc_act_title_1?smid=A3ODHND3J0WMC8&th=1";
    String echoDotPage = "https://www.amazon.com/Echo-Dot-3rd-Gen-speaker/dp/B07FZ8S74R/ref=zg_bs_electronics_6?_encoding=UTF8&refRID=ZJ6C2BGXCDD7J13VW2W9&smid=ATVPDKIKX0DER&th=1";
    String username = AmazonCredentialsManager.getUsername();
    String password = AmazonCredentialsManager.getPassword();

    @After
    public void tearDown() {
        driver.quit();
    }
}
