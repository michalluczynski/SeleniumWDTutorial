package seleniumMethodsAndProperties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetTextDemo {


    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception{
        System.out.println ("@Before" );

        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://learn.letskodeit.com/p/practice";

        driver.get (baseURL);
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.manage ().window ().maximize ();
    }

    @Test
    public void testGetText() throws InterruptedException {

        WebElement openTab = driver.findElement (By.id ("opentab") );
        String openTabButtonName = openTab.getText ();
        System.out.println ("Open Tab button name is " + openTabButtonName);

    }

    @After
    public void tearDown() throws Exception{
        System.out.println ("@After" );
        driver.quit ();
    }

}
