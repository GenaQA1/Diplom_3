package toppingconstructortest;

import basetest.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static urls.URLs.URL_BASE;

public class ToppingConstructorTest extends BaseTest {

    @Before
    public void setUp(){
        driver.get(URL_BASE);
    }


    @Test
    @DisplayName("Check that the transitions to the sections 'Sauces'")
    public void checkVisibleSauce() throws InterruptedException {
        homePage.clickButtonToppingSauce();
        homePage.checkToppingSauce();
    }


    @Test
    @DisplayName("Check that the transitions to the sections 'Bun'")
    public void checkVisibleBun() throws InterruptedException {
        homePage.clickButtonToppingSauce();
        homePage.clickButtonToppingBun();
        homePage.checkToppingBun();
    }


    @Test
    @DisplayName("Check that the transitions to the sections 'Fillings'")
    public void checkVisibleFillings() throws InterruptedException {
        homePage.clickButtonToppinFillings();
        homePage.checkToppingFillings();
    }
}
