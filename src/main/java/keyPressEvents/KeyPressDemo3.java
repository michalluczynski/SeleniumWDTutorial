package keyPressEvents;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class KeyPressDemo3 {

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
    public void test() throws InterruptedException {
        driver.get (baseURL);
        Thread.sleep (3000);

        Actions action = new Actions (driver);

        action.keyDown (Keys.COMMAND).sendKeys ("a").keyUp(Keys.COMMAND).perform ();


        Thread.sleep (3000);
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
