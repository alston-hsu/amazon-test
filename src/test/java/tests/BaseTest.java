package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.net.MalformedURLException;
import java.net.URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    RemoteWebDriver driver;

    @BeforeEach
    public void setup() throws MalformedURLException {

        try {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("enableVNC", true);
            options.setCapability("enableVideo", false);

            URL remoteUrl = new URL("http://localhost:4444/wd/hub");
            driver = new RemoteWebDriver(remoteUrl, options);
        } catch(UnreachableBrowserException failedConnection) {
            driver = new ChromeDriver();
        }
    }

    @AfterEach
    public void tearDown() { driver.quit(); }
}