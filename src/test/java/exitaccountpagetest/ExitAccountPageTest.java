package exitaccountpagetest;

import api.apiauthuser.ApiAuthUser;
import api.apicreateuser.ApiCreateUser;
import basetest.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static staticvalues.StaticValues.URL_BASE;

public class ExitAccountPageTest extends BaseTest {



    ApiCreateUser createUser = new ApiCreateUser();
    ApiAuthUser authUser = new ApiAuthUser();

    public ExitAccountPageTest() throws InterruptedException {
    }

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
    @DisplayName("Check the exit by clicking the 'Exit' button in your personal account")
    public void checkExitAccountUser() throws InterruptedException {
        homePage.clickButtonAccountUser();
        loginPage.sendTextFieldEmail("gena.chebotar@mail.ru");
        loginPage.sendTextFieldPassword("GoLittleRockStar");
        loginPage.clickButtonAcceptLogin();
        homePage.clickButtonAccountUser();
        accountPage.clickButtonExitAccount();
        loginPage.checkExitAccount();
    }
}
