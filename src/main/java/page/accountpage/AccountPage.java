package page.accountpage;

import page.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }


    private final By buttonExitAccount = By.xpath("//*[@id='root']/div/main/div/nav/ul/li[3]/button");


    public void clickButtonExitAccount() {
        driver.findElement(buttonExitAccount).click();
    }

    public void checkButtonExitAccount()  {
        int buttonExitAccountInPage = driver.findElements(buttonExitAccount).size();
        Assert.assertEquals(buttonExitAccountInPage,1);
    }
}
