package advancedInteractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumMethodsAndProperties.GenericMethods;

import java.util.concurrent.TimeUnit;

public class CalendarDemo {

    WebDriver driver;
    String baseURL;
    GenericMethods gm;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://www.expedia.com/";
        gm = new GenericMethods (driver);
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (2, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get (baseURL);

        WebElement searchButton = driver.findElement (By.xpath ("//button[@type='submit']"));
        WebElement fromMonth = driver.findElement (By.id ("d1-btn"));
        //WebElement datePick = driver.findElement (By.xpath ("//button[@data-day='30']") );
        //WebElement doneButton = driver.findElement (By.xpath ("//button[@data-stid='apply-date-picker']") );

        searchButton.click ();
        Thread.sleep (1000);
        fromMonth.click ();
        Thread.sleep (1000);
        driver.findElement (By.xpath ("//button[@data-day='30']") ).click ();
        Thread.sleep (1000);
        driver.findElement (By.xpath ("//button[@data-stid='apply-date-picker']") ).click ();

        /*gm.clickWhenReadyWebElement (searchButton, 3);
        gm.clickWhenReadyWebElement (fromMonth,3);
        gm.clickWhenReadyWebElement (datePick,3);
        gm.clickWhenReadyWebElement (doneButton,3);*/
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (1000);
        driver.quit ();
    }

}
