package workingWithActionClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SliderActions {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://jqueryui.com/slider/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get (baseURL);
        driver.switchTo ().frame (0);
        Thread.sleep (2000);

        WebElement slider = driver.findElement (By.xpath ("//div[@id='slider']/span"));
        Actions action = new Actions(driver);
        action.dragAndDropBy (slider,150,0).perform ();

        Thread.sleep (3000);
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
