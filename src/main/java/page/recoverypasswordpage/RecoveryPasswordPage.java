package page.recoverypasswordpage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.basepage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class RecoveryPasswordPage extends BasePage {
    public RecoveryPasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonEntrance = By.xpath("//*[@id='root']/div/main/div/div/p/a");


    public void clickButtonEntrance(){
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(buttonEntrance));
        driver.findElement(buttonEntrance).click();
    }


}
