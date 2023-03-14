package registrationtest;

import basetest.BaseTest;
import org.junit.Test;

public class RegistrationTest extends BaseTest {


    @Test
    public void checkRegistration() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonLogInAccount();
        loginPage.clickBtnRegistration();
        registrationPage.sendTextInFieldName();
        registrationPage.sendTextInFieldEmail();
        registrationPage.sendTextInFieldPassword();
        registrationPage.clickButtonAcceptRegistration();
        loginPage.sendTextFieldEmail();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }


    @Test
    public void checkIncorrectRegistration() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonLogInAccount();
        loginPage.clickBtnRegistration();
        registrationPage.sendTextInFieldName();
        registrationPage.sendTextInFieldEmail();
        registrationPage.sendTextIncorrectFieldPassword();
        registrationPage.clickButtonAcceptRegistration();
        registrationPage.checkVisibleTextIncorrectFieldPassword();
    }



}
