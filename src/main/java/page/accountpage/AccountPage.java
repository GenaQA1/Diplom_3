package page.accountpage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }


    private final By buttonExitAccount = By.xpath("//*[@id='root']/div/main/div/nav/ul/li[3]/button");


    public void clickButtonExitAccount() throws InterruptedException {

        driver.findElement(buttonExitAccount).click();


    }

    public void checkButtonExitAccount() throws InterruptedException {

        int buttonExitAccountInPage = driver.findElements(buttonExitAccount).size();
        Assert.assertEquals(buttonExitAccountInPage,1);
    }
}
