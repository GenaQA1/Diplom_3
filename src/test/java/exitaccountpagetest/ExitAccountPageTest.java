package exitaccountpagetest;

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

public class ExitAccountPageTest extends BaseTest {

    ApiUserClient createUser = new ApiUserClient();
    ApiAuthUser authUser = new ApiAuthUser();


    @Before
    public void setUp(){
        driver.get(URL_BASE);
        RestAssured.baseURI = URL_BASE;
        createUser.userClient(createUser.getCorrectUser());
    }

    @After
    public void setDown(){
        createUser.deleteUser(authUser.authUser(createUser.getCorrectUser()));
        createUser.deleteUser(authUser.authUser(createUser.getIncorrectUserPassword()));
    }

    @Test
    @DisplayName("Check the exit by clicking the 'Exit' button in your personal account")
    public void checkExitAccountUser() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmail(EMAIL_USER);
        loginPage.sendTextFieldPassword(PASSWORD_USER);
        loginPage.clickButtonAcceptLogin();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
}
