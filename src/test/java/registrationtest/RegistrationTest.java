package registrationtest;

import api.apiauthuser.ApiAuthUser;
import api.apicreateuser.ApiCreateUser;
import basetest.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static staticvalues.StaticValues.URL_BASE;

public class RegistrationTest extends BaseTest {


    public RegistrationTest() throws InterruptedException {
    }

    ApiCreateUser createUser = new ApiCreateUser();
    ApiAuthUser authUser = new ApiAuthUser();

    @Before
    public void setUp(){
        driver.get(URL_BASE);
        RestAssured.baseURI = URL_BASE;
        createUser.deleteUser(authUser.responseAuthUser(createUser.getCorrectUser()));
    }

    @After
    public void setDown(){
        createUser.deleteUser(authUser.responseAuthUser(createUser.getCorrectUser()));
        createUser.deleteUser(authUser.responseAuthUser(createUser.getIncorrectUserPassword()));
    }

    @Test
    @DisplayName("Verification of Successful registration")
    public void checkRegistration() throws InterruptedException {
        homePage.clickButtonLogInAccount();
        loginPage.clickBtnRegistration();
        registrationPage.sendTextInFieldName("MusicApple1");
        registrationPage.sendTextInFieldEmail("gena.chebotar@mail.ru");
        registrationPage.sendTextInFieldPassword("GoLittleRockStar");
        registrationPage.clickButtonAcceptRegistration();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
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
        registrationPage.sendTextInFieldName("MusicApple1");
        registrationPage.sendTextInFieldEmail("gena.chebotar@mail.ru");
        registrationPage.sendTextIncorrectFieldPassword("12345");
        registrationPage.clickButtonAcceptRegistration();
        registrationPage.checkVisibleTextIncorrectFieldPassword();
    }



}
