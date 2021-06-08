package basicweb;

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

public class BasicActionsMultipleSelect {

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
    public void testMultipleSelect() throws InterruptedException {
        System.out.println ("" );

        //WebElement element = driver.findElement (By.xpath ("//select[@id='multiple-select-example']"));
        WebElement element = driver.findElement (By.id ("multiple-select-example") );
        Select sel = new Select (element);

        Thread.sleep (1000);
        System.out.println ("Select orange by value" );
        sel.selectByValue ("orange");

        Thread.sleep (1000);
        System.out.println ("Deselect orange by value" );
        sel.deselectByValue ("orange");

        Thread.sleep (1000);
        System.out.println ("Select peach by index" );
        sel.selectByIndex (2);

        Thread.sleep (1000);
        System.out.println ("Select apple by visible text" );
        sel.selectByVisibleText ("Apple");

        Thread.sleep (1000);
        System.out.println ("Print all selected options" );

        List<WebElement> selectedOptions = sel.getAllSelectedOptions ();
        for (WebElement option : selectedOptions){
            System.out.println (option.getText () );
        }

        Thread.sleep (2000);
        System.out.println ("Deselect all selected options" );
        sel.deselectAll ();

    }

    @After
    public void tearDown() throws Exception{
        System.out.println ("@After" );
        driver.quit ();
    }

}
