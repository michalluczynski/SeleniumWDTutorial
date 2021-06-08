package switchWindowAndIFrames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/p/practice";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (2, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get (baseURL);

        //Get the handle
        String parentHandle = driver.getWindowHandle ();
        System.out.println ("Parent handle is: " + parentHandle );

        //Find Open Window Button
        WebElement openWindow = driver.findElement (By.id ("openwindow") );
        openWindow.click ();

        //Get all handles
        Set<String> handles = driver.getWindowHandles ();

        //Switching between handles
        for (String handle : handles){
            System.out.println (handle );
            if (!handle.equals (parentHandle)){
                driver.switchTo ().window (handle);
                Thread.sleep (2000);
                WebElement searchBoxNewWindow = driver.findElement (By.id ("search-courses"));
                searchBoxNewWindow.sendKeys ("Henlo");
                Thread.sleep (2000);
                driver.close (); //closes current focused window
                Thread.sleep (2000);
                break;
            }
        }
        //Switch back to the parent window
        driver.switchTo ().window (parentHandle);

        WebElement textBox = driver.findElement (By.id ("name") );
        textBox.sendKeys ("Henlo");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (2000);
        driver.quit ();
    }

}
