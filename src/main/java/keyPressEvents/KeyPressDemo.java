package keyPressEvents;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get (baseURL);
        WebElement login = driver.findElement (By.linkText ("Login" ) );
        login.click ();
        WebElement emailField = driver.findElement (By.id ("user_email") );
        emailField.sendKeys ("test@email.com");
        Thread.sleep (1000);
        WebElement pswdField = driver.findElement (By.id ("user_password") );
        pswdField.sendKeys ("123123");
        Thread.sleep (1000);
        WebElement submitButton = driver.findElement (By.name ("commit") );
        submitButton.sendKeys (Keys.ENTER);
        Thread.sleep (1000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get (baseURL);
        WebElement login = driver.findElement (By.linkText ("Login" ) );
        login.click ();
        WebElement emailField = driver.findElement (By.id ("user_email") );
        emailField.sendKeys ("test@email.com");
        Thread.sleep (1000);
        emailField.sendKeys (Keys.TAB);
        Thread.sleep (1000);
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
