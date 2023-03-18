package page.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static staticvalues.StaticValues.URL_PAGE_LOGIN;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private final By buttonRegistration= By.xpath("//*[@id='root']/div/main/div/div/p[1]/a");
    private final By fieldEmail = By.xpath("//*[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']");
    private final By fieldPassword = By.xpath("//*[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@name='Пароль']");
    private final By buttonAcceptLogin = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/button[text()='Войти']");
    private final By buttonRecoveryPassword = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");





    public void clickBtnRegistration(){
        driver.findElement(buttonRegistration).click();
    }

    public void sendTextFieldEmail(String Email) throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(fieldEmail).sendKeys(Email);
    }

    public void sendTextFieldPassword(String password){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(fieldPassword));
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void clickButtonAcceptLogin() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(buttonAcceptLogin).click();
    }
    public void clickButtonRecoveryPassword() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(buttonRecoveryPassword).click();
    }

    public void checkExitAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlContains(URL_PAGE_LOGIN));
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, URL_PAGE_LOGIN);
    }
}
