package basetest;

import CommonAction.CommonAction;
import Page.AccountPage.AccountPage;
import Page.HomePage.HomePage;
import Page.LoginPage.LoginPage;
import Page.RecoveryPasswordPage.RecoveryPasswordPage;
import Page.RegistrationPage.RegistrationPage;
import org.junit.After;
import org.openqa.selenium.WebDriver;

public class BaseTest {

//Смена
    protected WebDriver driver = CommonAction.createDriver("mac_yandex");
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected RegistrationPage registrationPage = new RegistrationPage(driver);
    protected RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
    protected AccountPage accountPage = new AccountPage(driver);

}
