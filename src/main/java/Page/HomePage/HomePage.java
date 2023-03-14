package Page.HomePage;

import Page.BasePage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By buttonLogInAccount = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private final By buttonCreateOrder = By.xpath("//*[@id='root']/div/main/section[2]/div/button");
    private final By buttonAccountUser = By.xpath("//*[@id='root']/div/header/nav/a/p");
    private final By logoHomePage = By.xpath("//*[@id='root']/div/header/nav/div");
    private final By buttonConstructor = By.xpath("//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    private final By activityToppingBun = By.xpath("//div[1][@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect' ]");
    private final By activityToppingSauce = By.xpath("//div[2][@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']");
    private final By activityToppingFillings = By.xpath("//div[3][@class = 'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect' ]");
    private final By buttonToppingBun = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[1]");
    private final By buttonToppingSauce = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[2]");
    private final By buttonToppingFillings = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div[3]");







    public void clickButtonLogInAccount() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonLogInAccount).click();
    }

    public void checkButtonCreateOrder() throws InterruptedException {
        Thread.sleep(1000);
        String buttonOrder = driver.findElement(buttonCreateOrder).getText();
        Assert.assertEquals("Оформить заказ",buttonOrder);
    }

    public void clickButtonAccountUser() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonAccountUser).click();
    }

    public void clickLogoHomePage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(logoHomePage).click();
    }

    public void clickButtonConstructor() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonConstructor).click();
    }

    public void clickButtonToppingSauce() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonToppingBun).click();
    }

    public void clickButtonToppingBun() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonToppingSauce).click();
    }

    public void clickButtonToppinFillings() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(buttonToppingFillings).click();
    }


    public void checkToppingBun() throws InterruptedException {
        Thread.sleep(200);
        int countActivity = driver.findElements(activityToppingBun).size();
        Assert.assertEquals(countActivity,1);
    }

    public void checkToppingSauce() throws InterruptedException {
        Thread.sleep(200);
        int countActivity = driver.findElements(activityToppingSauce).size();
        Assert.assertEquals(countActivity,1);
    }

    public void checkToppingFillings() throws InterruptedException {
        Thread.sleep(200);
        int countActivity = driver.findElements(activityToppingFillings).size();
        Assert.assertEquals(countActivity,1);
    }

}
