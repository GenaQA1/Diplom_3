package registrationtest;

import api.apiauthuser.ApiAuthUser;
import api.apicreateuser.ApiUserClient;
import basetest.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static datauser.DataUser.*;
import static urls.URLs.URL_BASE;

public class RegistrationTest extends BaseTest {

    ApiUserClient createUser = new ApiUserClient();
    ApiAuthUser authUser = new ApiAuthUser();

    @Before
    public void setUp(){
        driver.get(URL_BASE);
        RestAssured.baseURI = URL_BASE;
    }

    @After
    public void setDown(){
        createUser.deleteUser(authUser.authUser(createUser.getCorrectUser()));
        createUser.deleteUser(authUser.authUser(createUser.getIncorrectUserPassword()));
    }

    @Test
    @DisplayName("Verification of Successful registration")
    public void checkRegistration() throws InterruptedException {
        homePage.clickButtonLogInAccount();
        loginPage.clickBtnRegistration();
        registrationPage.sendTextInFieldName(NAME_USER);
        registrationPage.sendTextInFieldEmail(EMAIL_USER);
        registrationPage.sendTextInFieldPassword(PASSWORD_USER);
        registrationPage.clickButtonAcceptRegistration();
        loginPage.sendTextFieldEmail(EMAIL_USER);
        loginPage.sendTextFieldPassword(PASSWORD_USER);
        loginPage.clickButtonAcceptLogin();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }


    @Test
    @DisplayName("Checking the error for an incorrect password")
    public void checkIncorrectRegistration() throws InterruptedException {
        homePage.clickButtonLogInAccount();
        loginPage.clickBtnRegistration();
        registrationPage.sendTextInFieldName(NAME_USER);
        registrationPage.sendTextInFieldEmail(EMAIL_USER);
        registrationPage.sendTextIncorrectFieldPassword(INCORRECT_PASSWORD_USER);
        registrationPage.clickButtonAcceptRegistration();
        registrationPage.checkVisibleTextIncorrectFieldPassword();
    }



}
