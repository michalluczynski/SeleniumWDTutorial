package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicActionsClickAndSendKeys {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp() throws Exception{
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        driver.get (baseURL);
        driver.findElement (By.xpath ("//a[@href='/sign_in']")).click ();
        System.out.println ("Clicked on login" );
        driver.findElement (By.xpath ("//input[@id='user_email']")).clear ();
        System.out.println ("Clearing email field" );
        driver.findElement (By.xpath ("//input[@id='user_email']")).sendKeys ("some@email.com");
        System.out.println ("Sending input to email" );
        driver.findElement (By.xpath ("//input[@id='user_password']")).clear ();
        System.out.println ("Clearing pswd field" );
        driver.findElement (By.xpath ("//input[@id='user_password']")).sendKeys ("password");
        System.out.println ("Sending input to pswd" );
        driver.findElement (By.xpath ("//input[@value='Log In']")).click ();
        System.out.println ("Clicked on login" );
    }

    @After
    public void tearDown() throws Exception{
        driver.quit ();
        System.out.println ("Driver closed" );
    }
}
