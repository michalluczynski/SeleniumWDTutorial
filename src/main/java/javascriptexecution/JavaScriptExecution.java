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

public class JavaScriptExecution {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://learn.letskodeit.com/p/practice";

        js = (JavascriptExecutor)driver;

        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void testJavaScriptExecution(){
        //Navigation
        //driver.get (baseURL);
        //JS alternative
        js.executeScript ("window.location = 'https://learn.letskodeit.com/p/practice';");

        //Finding element
        //WebElement textBox = driver.findElement (By.id ("name") );
        //JS alternative
        WebElement textBox = (WebElement) js.executeScript ("return document.getElementById('name');");

        textBox.sendKeys ("test");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (1500);
        driver.quit ();
    }

}
