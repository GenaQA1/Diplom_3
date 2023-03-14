package toppingconstructortest;

import basetest.BaseTest;
import org.junit.Test;

public class ToppingConstructorTest extends BaseTest {

//Обратил внимание что переключатели активируются еще и отображении одной категории в видимости. Т.е. если мы видим только соусы то его класс меняется
    //то можно сказать что система в данном случае отрабатывает правильно. Сложно зацепиться за что-то в этом задании. Хотел проверить на нажатие,но происходит скролл а его убрать нельзя.
    @Test
    public void checkVisibleBun() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonToppingBun();
        homePage.checkToppingBun();
    }

    @Test
    public void checkVisibleSauce() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonToppinFillings();
        homePage.checkToppingSauce();
    }

    @Test
    public void checkVisibleFillings() throws InterruptedException {
        driver.get("https://stellarburgers.nomoreparties.site");
        homePage.clickButtonToppingBun();
        homePage.checkToppingFillings();
    }
}
