package seleniumMethodsAndProperties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.namespace.QName;
import java.util.concurrent.TimeUnit;

public class GenericMethodsDemo {

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

        WebElement element = gm.getElement ("name", "id");
        element.sendKeys ("Henlo");

    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep (2000);
        System.out.println ("@After" );
        driver.quit ();
    }

}
