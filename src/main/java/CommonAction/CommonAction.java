package CommonAction;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonAction {

    private static WebDriver driver;


    public static final int IMPLICIT_WAIT = 20;

    public CommonAction(WebDriver driver) {
    }

    //На данный момент пробовал и с Хромом, но выдает ошибку 403. Возможно из за того что Крым, но ранее все работало, всегда. Включал Впн не помогло.
    @Before
    public static WebDriver createDriver(String browser) {
        if (driver == null) {
            if (browser == "mac_chrome") {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
            } else if (browser == "mac_yandex") {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandex");
               ChromeOptions options = new ChromeOptions();
               options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                driver = new ChromeDriver(options);
            } else {
                Assert.fail("Incorrect platform or browser name: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        }
        return driver;
    }


}
