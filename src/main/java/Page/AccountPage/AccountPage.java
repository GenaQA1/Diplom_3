package Page.AccountPage;

import Page.BasePage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }


    private final By buttonExitAccount = By.xpath("//*[@id='root']/div/main/div/nav/ul/li[3]/button");



    public void clickButtonExitAccount() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(buttonExitAccount).click();
        Thread.sleep(500);
    }

    public void checkButtonExitAccount() throws InterruptedException {
        Thread.sleep(1000);
        int buttonExitAccountInPage = driver.findElements(buttonExitAccount).size();
        Assert.assertEquals(buttonExitAccountInPage,1);
    }
}
