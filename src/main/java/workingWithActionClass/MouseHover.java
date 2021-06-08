package workingWithActionClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import seleniumMethodsAndProperties.GenericMethods;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class MouseHover {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor jse;
    GenericMethods gm;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/p/practice";
        jse = (JavascriptExecutor) driver;
        gm = new GenericMethods (driver);
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void testMouseHover() throws InterruptedException {
        driver.get (baseURL);
        jse.executeScript ("window.scrollBy(0,600);");

        Thread.sleep (2000);

        WebElement mouseHover = driver.findElement (By.id ("mousehover") );

        Actions action = new Actions(driver);
        action.moveToElement (mouseHover).perform ();

        Thread.sleep (2000);

        WebElement topHover = driver.findElement (By.xpath ("//*[text()='Top']") );
        topHover.click ();

        Thread.sleep (2000);
    }

    @Test
    public void testMouseHover2() throws InterruptedException {
        driver.get (baseURL);
        gm.scrollBy (0,600);

        Thread.sleep (2000);

        WebElement mouseHover = driver.findElement (By.id ("mousehover") );

        gm.hover (mouseHover);

        Thread.sleep (2000);

        WebElement topHover = driver.findElement (By.xpath ("//*[text()='Top']") );
        topHover.click ();

        Thread.sleep (2000);
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
