package switchWindowAndIFrames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchFrame {

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

        Thread.sleep (2000);

        //Switch to iFrame
        WebElement iFrameWindow = driver.findElement (By.id ("courses-iframe") );
        driver.switchTo ().frame (iFrameWindow);

        Thread.sleep (2000);

        //Find element on iFrame
        WebElement searchBox = driver.findElement (By.id ("search-courses") );
        searchBox.sendKeys ("Python");

        Thread.sleep (2000);

        //Switch to default window
        driver.switchTo ().defaultContent ();

        Thread.sleep (2000);

        //Sendkeys to prove focus is on default window
        WebElement textBox = driver.findElement (By.id ("name"));
        textBox.sendKeys ("Henlo");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (2000);
        driver.quit ();
    }

}
