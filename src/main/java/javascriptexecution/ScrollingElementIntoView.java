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

public class ScrollingElementIntoView {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "";

        js = (JavascriptExecutor) driver;
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void testWindowSize() throws InterruptedException {
        //Navigation - JS
        js.executeScript ("window.location = 'https://learn.letskodeit.com/p/practice';");
        Thread.sleep (2000);

        //Scroll Down
        js.executeScript ("window.scrollBy(0,1900);");
        Thread.sleep (2000);

        //Scroll up
        js.executeScript ("window.scrollBy(0,-1900);");
        Thread.sleep (2000);

        //Scroll element into view
        //WebElement poweredBy = driver.findElement (By.className ("powered-by") );
        WebElement mouseHover = driver.findElement (By.id ("mousehover") );
        js.executeScript ("arguments[0].scrollIntoView(true);", mouseHover);

        Thread.sleep (2000);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (1500);
        driver.quit ();
    }

}
