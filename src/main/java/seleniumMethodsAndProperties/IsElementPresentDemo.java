package seleniumMethodsAndProperties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IsElementPresentDemo {

    WebDriver driver;
    String baseURL;
    private GenericMethods gm;


    @Before
    public void setUp() throws Exception{
        System.out.println ("@Before" );

        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://learn.letskodeit.com/p/practice";
        gm = new GenericMethods (driver);
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.manage ().window ().maximize ();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get (baseURL);

        boolean result1 = gm.isElementPresent ("name", "id" );
        System.out.println ("Result: " + result1);

        boolean result2 = gm.isElementPresent ("name-not-present", "id" );
        System.out.println ("Result: " + result2);
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep (1000);
        driver.quit ();
    }

}
