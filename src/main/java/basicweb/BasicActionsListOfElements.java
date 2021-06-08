package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicActionsListOfElements {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception{
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
        boolean isChecked = false;
        List<WebElement> radioButtons = driver.findElements (By.xpath ("//input[contains(@type,'radio') and contains (@name,'cars')]"));
        System.out.println (radioButtons );
        int size = radioButtons.size ();
        System.out.println ("Size of the list is = " + size);
        for (int i=0; i<size; i++){
            isChecked = radioButtons.get (i).isSelected ();

            if(!isChecked){
                radioButtons.get (i).click ();
                Thread.sleep (2000);
            }
        }

    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep (2000);
        driver.quit ();
        System.out.println ("Driver closed" );
    }

}
