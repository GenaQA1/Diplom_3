package transitionpagetest;

import api.apiauthuser.ApiAuthUser;
import api.apicreateuser.ApiCreateUser;
import basetest.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static staticvalues.StaticValues.URL_BASE;

public class TransitionPageTest extends BaseTest {


    public TransitionPageTest() throws InterruptedException {
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
    @DisplayName("Check the click-through to the Stellar Burgers logo")
    public void transitionInAccountPage() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
        loginPage.clickButtonAcceptLogin();
        homePage.clickLogoHomePage();
        homePage.clickButtonAccountUser();
        accountPage.checkButtonExitAccount();
        accountPage.clickButtonExitAccount();
    }

    @Test
    @DisplayName("Check the transition by clicking on the 'Constructor'")
    public void transitionInHomePageFromAccountPage() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
        loginPage.clickButtonAcceptLogin();
        homePage.clickButtonConstructor();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }



}
