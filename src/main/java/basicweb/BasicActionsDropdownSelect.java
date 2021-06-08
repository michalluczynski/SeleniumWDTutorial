package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicActionsDropdownSelect {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://learn.letskodeit.com/p/practice";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        System.out.println ("Driver is set up" );
        driver.get (baseURL);
        System.out.println ("Driver is running" );
    }

    @Test
    public void test() throws InterruptedException {
        WebElement element = driver.findElement (By.id ("carselect"));
        Select sel = new Select (element);

        Thread.sleep (2000);
        System.out.println ("Select Benz by value" );
        sel.selectByValue ("benz");

        Thread.sleep (2000);
        System.out.println ("Select Honda by index" );
        sel.selectByIndex (2);

        Thread.sleep (2000);
        System.out.println ("Select BMW by visible text" );
        sel.selectByVisibleText ("BMW");

        Thread.sleep (2000);
        System.out.println ("Print the list of all options" );
        List<WebElement> options = sel.getOptions ();
        int size = options.size ();

        for (int i = 0; i<size; i++){
            String optionName = options.get (i).getText ();
            System.out.println ("Option name = " + optionName );
        }

    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep (2000);
        driver.quit ();
        System.out.println ("Driver closed" );
    }

}
