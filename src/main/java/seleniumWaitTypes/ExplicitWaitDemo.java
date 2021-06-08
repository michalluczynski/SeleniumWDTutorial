package seleniumWaitTypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTypes;


public class ExplicitWaitDemo {

    private WebDriver driver;
    private String baseURL;
    private WaitTypes wt;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage ().window ().maximize ();
        wt = new WaitTypes (driver);
    }

    //test 1 without generic method

    @Test
    public void test1(){
        driver.get (baseURL);
        WebElement loginLink = driver.findElement (By.linkText ("Login"));
        loginLink.click ();

        WebDriverWait wait = new WebDriverWait (driver, 3);
        WebElement emailField = wait.until (
                ExpectedConditions.visibilityOfElementLocated (By.id ("user_email")));
        emailField.sendKeys ("henlo");

    }

    //test 2 with generic method

    @Test
    public void test2(){
        driver.get (baseURL);
        WebElement loginLink = driver.findElement (By.linkText ("Login"));
        loginLink.click ();
        WebElement emailField = wt.waitForElement (By.id ("user_email"),3);
        emailField.sendKeys ("henlo");

        wt.clickWhenReady (By.id ("opentab"),3);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (2000);
        driver.quit();
    }
}
