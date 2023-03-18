package page.registrationpage;


import page.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private final By fieldName = By.xpath("//label[text()='Имя']/../input");
    private final By fieldEmail = By.xpath("//label[text()='Email']/../input");
    private final By fieldPassword = By.xpath("//label[text()='Пароль']/../input");
    private final By buttonAcceptRegistration = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/button[text()='Зарегистрироваться']");
    private final By fieldTextIncorrectWritePassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/p");
    private final By buttonEntrance = By.xpath("//*[@id='root']/div/main/div/div/p/a");


    public void sendTextInFieldName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    public void sendTextInFieldEmail(String Email) {
        driver.findElement(fieldEmail).sendKeys(Email);
    }

    public void sendTextInFieldPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }

    public void sendTextIncorrectFieldPassword(String incorrectPassword){
        driver.findElement(fieldPassword).sendKeys(incorrectPassword);
    }

    public void checkVisibleTextIncorrectFieldPassword() {
       String exception =  driver.findElement(fieldTextIncorrectWritePassword).getText();
        Assert.assertEquals("Некорректный пароль",exception);
    }
    public void clickButtonAcceptRegistration() {
        driver.findElement(buttonAcceptRegistration).click();
    }

    public void clickButtonEntrance(){
        driver.findElement(buttonEntrance).click();
    }
}
