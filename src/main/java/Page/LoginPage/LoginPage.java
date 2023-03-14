package Page.LoginPage;

import Page.BasePage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private final By buttonRegistration= By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");
    private final By fieldEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By fieldPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By buttonAcceptLogin = By.xpath("//*[@id='root']/div/main/div/form/button");
    private final By buttonRecoveryPassword = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");







    public void clickBtnRegistration(){
        driver.findElement(buttonRegistration).click();
    }

    public void sendTextFieldEmail() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fieldEmail).sendKeys("gena.chebotar011@mail.ru");
    }

    public void sendTextFieldEmailAuth() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fieldEmail).sendKeys("gena.chebotar0112@mail.ru");
    }

    public void sendTextFieldPassword() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fieldPassword).sendKeys("GoLittleRockStar");
    }

    public void clickButtonAcceptLogin() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonAcceptLogin).click();
    }
    public void clickButtonRecoveryPassword() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonRecoveryPassword).click();
    }

    public void checkExitAccount() throws InterruptedException {
        Thread.sleep(100);
        int buttonEntrance = driver.findElements(buttonAcceptLogin).size();
        Assert.assertEquals(buttonEntrance, 1);
    }


}
