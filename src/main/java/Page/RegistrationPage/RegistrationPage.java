package Page.RegistrationPage;

import Page.BasePage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By fieldName = By.xpath("//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    private final By fieldEmail = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    private final By fieldPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    private final By buttonAcceptRegistration = By.xpath("//*[@id='root']/div/main/div/form/button");
    private final By fieldTextIncorrectWritePassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/p");
    private final By buttonEntrance = By.xpath("//*[@id='root']/div/main/div/div/p/a");


    public void sendTextInFieldName() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fieldName).sendKeys("MusicApple1");
    }

    public void sendTextInFieldEmail() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fieldEmail).sendKeys("gena.chebotar011@mail.ru");
    }

    public void sendTextInFieldPassword() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fieldPassword).sendKeys("GoLittleRockStar");
    }

    public void sendTextIncorrectFieldPassword() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fieldPassword).sendKeys("12345");
    }

    public void checkVisibleTextIncorrectFieldPassword() throws InterruptedException {
        Thread.sleep(1000);
       String exception =  driver.findElement(fieldTextIncorrectWritePassword).getText();
        Assert.assertEquals(exception,"Некорректный пароль");
    }
    public void clickButtonAcceptRegistration() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonAcceptRegistration).click();
    }

    public void clickButtonEntrance() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonEntrance).click();
    }
}
