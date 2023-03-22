package transitionpagetest;

import api.apiauthuser.ApiAuthUser;
import api.apicreateuser.ApiUserClient;
import basetest.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static datauser.DataUser.EMAIL_USER;
import static datauser.DataUser.PASSWORD_USER;
import static urls.URLs.URL_BASE;

public class TransitionPageTest extends BaseTest {

    ApiUserClient createUser = new ApiUserClient();
    ApiAuthUser authUser = new ApiAuthUser();

    @Before
    public void setUp(){
        driver.get(URL_BASE);
        RestAssured.baseURI = URL_BASE;
        createUser.createUser(createUser.getCorrectUser());
    }

    @After
    public void setDown(){
        createUser.deleteUser(authUser.authUser(createUser.getCorrectUser()));
    }

    @Test
    @DisplayName("Check the click-through to the Stellar Burgers logo")
    public void transitionInAccountPage() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmail(EMAIL_USER);
        loginPage.sendTextFieldPassword(PASSWORD_USER);
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
        loginPage.sendTextFieldEmail(EMAIL_USER);
        loginPage.sendTextFieldPassword(PASSWORD_USER);
        loginPage.clickButtonAcceptLogin();
        homePage.clickButtonConstructor();
        homePage.checkButtonCreateOrder();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }



}
