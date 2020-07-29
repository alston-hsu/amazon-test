package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    RemoteWebDriver driver;

    @Before
    public void setup() throws MalformedURLException {

        try {
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("marionette", true);
            options.setCapability("enableVNC", true);
            options.setCapability("enableVideo", false);

            URL remoteUrl = new URL("http://localhost:4444/wd/hub");
            driver = new RemoteWebDriver(remoteUrl, options);
        } catch(UnreachableBrowserException failedConnection) {
            driver = new FirefoxDriver();
        }
    }

    @After
    public void tearDown() { driver.quit(); }
}