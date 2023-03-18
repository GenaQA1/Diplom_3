package authorizationtest;

import api.apiauthuser.ApiAuthUser;
import api.apicreateuser.ApiCreateUser;
import basetest.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static staticvalues.StaticValues.URL_BASE;

public class AuthorizationTest extends BaseTest {


    public AuthorizationTest() throws InterruptedException {
    }

    ApiCreateUser createUser = new ApiCreateUser();
    ApiAuthUser authUser = new ApiAuthUser();

    @Before
    public void setUp(){
        driver.get(URL_BASE);
        RestAssured.baseURI = URL_BASE;
        createUser.deleteUser(authUser.responseAuthUser(createUser.getCorrectUser()));
        createUser.responseCreateUsers(createUser.getCorrectUser());
    }

    @After
    public void setDown(){
        createUser.deleteUser(authUser.responseAuthUser(createUser.getCorrectUser()));
        createUser.deleteUser(authUser.responseAuthUser(createUser.getIncorrectUserPassword()));
    }


    @Test
    @DisplayName("log in using the 'Log in to account' button on the main page")
    public void authorizationByButtonAccountUserPageHome() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
    @Test
    @DisplayName("login via the 'Personal Account' button")
    public void authorizationByButtonLoginUserPageHome() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
    @Test
    @DisplayName("login by the button in the registration form")
    public void authorizationByButtonEntrancePageRegist() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.clickBtnRegistration();
        registrationPage.clickButtonEntrance();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
    @Test
    @DisplayName("login by the button in the password recovery form")
    public void authorizationByButtonEntrancePageRecovery() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.clickButtonRecoveryPassword();
        recoveryPasswordPage.clickButtonEntrance();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
}
