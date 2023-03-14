package authorizationtest;

import basetest.BaseTest;
import org.junit.Test;

public class AuthorizationTest extends BaseTest {


    @Test
    public void authorizationByButtonAccountUserPageHome() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmailAuth();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();

    }

    @Test
    public void authorizationByButtonLoginUserPageHome() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickButtonLogInAccount();
        loginPage.sendTextFieldEmailAuth();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
    @Test
    public void authorizationByButtonEntrancePageRegist() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonLogInAccount();
        loginPage.clickBtnRegistration();
        registrationPage.clickButtonEntrance();
        loginPage.sendTextFieldEmailAuth();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
    @Test
    public void authorizationByButtonEntrancePageRecovery() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonLogInAccount();
        loginPage.clickButtonRecoveryPassword();
        recoveryPasswordPage.clickButtonEntrance();
        loginPage.sendTextFieldEmailAuth();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }



}
