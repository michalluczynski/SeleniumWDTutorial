package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class basicActionsStateOfElement {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception{
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://www.google.com/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        System.out.println ("Driver is set up" );
        driver.get (baseURL);
        System.out.println ("Driver is running" );
    }

    @Test
    public void test() throws InterruptedException {
        /*driver.findElement (By.xpath ("//input[@title='Szukaj']")).sendKeys ("Hello");
        Thread.sleep (1000);*/

        WebElement googleSzukaj = driver.findElement (By.xpath ("//input[@title='Szukaj']") );
        //WebElement googleSzukajDisabled = driver.findElement (By.id ("gs_htif0"));
        System.out.println ("Is googleSzukaj enagled? " + googleSzukaj.isEnabled () );

        googleSzukaj.sendKeys ("Hello");

        Thread.sleep (1000);

        if (googleSzukaj.isEnabled ()){
            System.out.println ("WebElement is enabled" );
        }else{
            System.out.println ("WebElement is disabled" );
        }
    }

    @After
    public void tearDown() throws Exception{
        driver.quit ();
        System.out.println ("Driver closed" );
    }

}
