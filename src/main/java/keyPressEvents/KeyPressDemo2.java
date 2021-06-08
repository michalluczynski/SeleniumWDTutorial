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

public class KeyPressDemo2 {

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
    public void testSelectAll(){
        driver.get (baseURL);
        // Find any element
        WebElement openWindow = driver.findElement ( By.id ("openwindow"));
        //openWindow.sendKeys (Keys.CONTROL + "a");
        //openWindow.sendKeys (Keys.chord (Keys.COMMAND, "a"));
        String selectAll = Keys.chord (Keys.COMMAND, "a");
        openWindow.sendKeys (selectAll);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (3000);
        driver.quit ();
    }

}
