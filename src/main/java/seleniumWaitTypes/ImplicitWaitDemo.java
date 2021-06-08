package seleniumWaitTypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitDemo {

    private WebDriver driver;
    private String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get (baseURL);
        WebElement loginLink = driver.findElement (By.linkText ("Login"));
        loginLink.click ();

        WebElement userEmail = driver.findElement (By.id ("user_email"));
        userEmail.sendKeys ("henlo");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (2000);
        driver.quit();
    }
}
