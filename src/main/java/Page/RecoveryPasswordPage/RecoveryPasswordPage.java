package Page.RecoveryPasswordPage;

import Page.BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage extends BasePage {
    public RecoveryPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonEntrance = By.xpath("//*[@id='root']/div/main/div/div/p/a");


    public void clickButtonEntrance() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonEntrance).click();
    }


}
