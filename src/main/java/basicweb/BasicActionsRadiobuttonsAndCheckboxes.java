package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicActionsRadiobuttonsAndCheckboxes {

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
        //radiobuttons

        WebElement bmwRadio = driver.findElement (By.id ("bmwradio"));
        WebElement benzRadio = driver.findElement (By.id ("benzradio"));
        WebElement hondaRadio = driver.findElement (By.id ("hondaradio"));
        bmwRadio.click ();

        //Thread.sleep (1000);
        benzRadio.click ();

        //checkboxes

        WebElement bmwCheckBox = driver.findElement (By.id ("bmwcheck"));
        WebElement benzCheckBox = driver.findElement (By.id ("benzcheck"));
        WebElement hondaCheckBox = driver.findElement (By.id ("hondacheck"));

        bmwCheckBox.click ();
        benzCheckBox.click ();

        //Is selected property
        System.out.println ("BMW Radio is selected? " + bmwRadio.isSelected ());
        System.out.println ("Benz Radio is selected? " + benzRadio.isSelected ());
        System.out.println ("Honda Radio is selected? " + hondaRadio.isSelected ());

        System.out.println ("BMW CheckBox is selected? " + bmwCheckBox.isSelected ());
        System.out.println ("Benz CheckBox is selected? " + benzCheckBox.isSelected ());
        System.out.println ("Honda CheckBox is selected? " + hondaCheckBox.isSelected ());
    }

    @After
    public void tearDown() throws Exception{
        Thread.sleep (2000);
        driver.quit ();
        System.out.println ("Driver closed" );
    }

}
