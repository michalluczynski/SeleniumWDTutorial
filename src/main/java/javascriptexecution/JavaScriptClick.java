package javascriptexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptClick {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/p/practice";

        js = (JavascriptExecutor) driver;
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void testWindowSize() throws InterruptedException {
        driver.get (baseURL);
        Thread.sleep (1500);

        WebElement checkbox = driver.findElement (By.id ("bmwcheck") );

        js.executeScript ("arguments[0].click();", checkbox);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (1500);
        driver.quit ();
    }

}
