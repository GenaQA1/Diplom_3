package transitionpagetest;

import basetest.BaseTest;
import org.junit.Test;

public class TransitionPageTest extends BaseTest {



    @Test
    public void transitionInAccountPage() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmailAuth();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.clickLogoHomePage();
        homePage.clickButtonAccountUser();
        accountPage.checkButtonExitAccount();
        accountPage.clickButtonExitAccount();
    }

    @Test
    public void transitionInHomePageFromAccountPage() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonLogInAccount();
        loginPage.sendTextFieldEmailAuth();
        loginPage.sendTextFieldPassword();
        loginPage.clickButtonAcceptLogin();
        homePage.clickButtonConstructor();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();

    }



}
