package tutorial.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.classes.StaysPage;

import java.util.concurrent.TimeUnit;

public class NoFrameworkTest {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://www.expedia.com/";

        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (2, TimeUnit.SECONDS);

        driver.get (baseURL);

    }

    @Test
    public void test(){
        driver.findElement (By.xpath ("//span[text()='Stays']")).click();
        //driver.findElement (By.xpath ("//button[@aria-label='Going to']")).click ();
        //driver.findElement (By.xpath ("//button[@aria-label='Going to']")).sendKeys ( Keys.ENTER);

        driver.findElement (By.id ("add-car-switch")).click ();
        driver.findElement (By.xpath ("//button[@data-testid='submit-button']")).click ();
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
