package tutorial.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.classes.StaysPage;

import java.util.concurrent.TimeUnit;

public class FrameworkTest {

    WebDriver driver;
    String baseURL;
    StaysPage staysPage; // initializes PageFactory class to test class

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://www.expedia.com/";

        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (2, TimeUnit.SECONDS);

        staysPage = new StaysPage (driver);

        driver.get (baseURL);
    }

    @Test
    public void test(){
        staysPage.clickStaysTab ();
        staysPage.fillGoingToField ("New York");
        staysPage.clickSubmit ();
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
