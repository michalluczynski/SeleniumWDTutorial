package javascriptexecution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WindowSize {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "";

        js = (JavascriptExecutor) driver;
        //driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void testWindowSize(){
        //Navigation - JS
        js.executeScript ("window.location = 'https://learn.letskodeit.com/p/practice';");

        //Size of window
        long height = (Long) js.executeScript ("return window.innerHeight;");
        long width = (Long) js.executeScript ("return window.innerWidth;");

        System.out.println ("Height of the window: " + height);
        System.out.println ("Width of the window: " + width);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (1500);
        driver.quit ();
    }

}
