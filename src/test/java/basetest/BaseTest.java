package basetest;

import commonaction.CommonAction;
import page.accountpage.AccountPage;
import page.homepage.HomePage;
import page.loginpage.LoginPage;
import page.recoverypasswordpage.RecoveryPasswordPage;
import page.registrationpage.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class BaseTest {

//Смена
    protected WebDriver driver = CommonAction.createDriver("mac_yandex");
    protected HomePage homePage = new HomePage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected RegistrationPage registrationPage = new RegistrationPage(driver);
    protected RecoveryPasswordPage recoveryPasswordPage = new RecoveryPasswordPage(driver);
    protected AccountPage accountPage = new AccountPage(driver);


    public BaseTest() throws InterruptedException {
    }
}
