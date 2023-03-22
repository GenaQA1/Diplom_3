package page.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By buttonLogInAccount = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private final By buttonCreateOrder = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private final By buttonAccountUser = By.xpath("//*[@id='root']/div/header/nav/a/p");
    private final By logoHomePage = By.xpath("//*[@id='root']/div/header/nav/div");
    private final By buttonConstructor = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    private final By activityTopping = By.xpath("//div[starts-with(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]//span");
    private final By activityToppingFillings = By.xpath("//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private final By buttonToppingBun = By.xpath("//span[@class='text text_type_main-default'][text()='Булки']");
    private final By buttonToppingSauce = By.xpath("//span[@class='text text_type_main-default'][text()='Соусы']");
    private final By buttonToppingFillings = By.xpath("//span[@class='text text_type_main-default'][text()='Начинки']");







    public void clickButtonLogInAccount() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(buttonLogInAccount));
        driver.findElement(buttonLogInAccount).click();
    }

    public void checkButtonCreateOrder() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(buttonCreateOrder));
        String buttonOrder = driver.findElement(buttonCreateOrder).getText();
        Assert.assertEquals("Оформить заказ",buttonOrder);
    }

    public void clickButtonAccountUser() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(buttonAccountUser));
        driver.findElement(buttonAccountUser).click();
    }

    public void clickLogoHomePage() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(logoHomePage));
        driver.findElement(logoHomePage).click();
    }

    public void clickButtonConstructor() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(buttonConstructor));
        driver.findElement(buttonConstructor).click();
    }

    public void clickButtonToppingBun() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(buttonToppingBun).click();
    }

    public void clickButtonToppingSauce() throws InterruptedException {
        Thread.sleep(500);

        driver.findElement(buttonToppingSauce).click();
    }

    public void clickButtonToppinFillings() throws InterruptedException {
        Thread.sleep(500);

        driver.findElement(buttonToppingFillings).click();
    }

    public void checkToppingBun() throws InterruptedException {
        Thread.sleep(500);
        String countActivity = driver.findElement(activityTopping).getText();
        Assert.assertEquals(countActivity,"Булки");
    }

    public void checkToppingSauce() throws InterruptedException {
        Thread.sleep(500);
        String countActivity = driver.findElement(activityTopping).getText();
        Assert.assertEquals(countActivity,"Соусы");
    }

    public void checkToppingFillings() throws InterruptedException {
        Thread.sleep(1000);
        String countActivity = driver.findElement(activityTopping).getText();
        Assert.assertEquals(countActivity,"Начинки");
    }

}
