package interviewQuestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StaleElementDemo {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get (baseURL);

        WebElement checkboxElement = driver.findElement (By.id ("bmwcheck") );
        driver.get (driver.getCurrentUrl ());
        checkboxElement.click ();
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
