package exitaccountpagetest;

import basetest.BaseTest;
import org.junit.Test;

public class ExitAccountPageTest extends BaseTest {


    @Test
    public void checkExitAccountUser() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmailAuth();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
}
