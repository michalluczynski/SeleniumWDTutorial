package basicweb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicActionsNavigatingBetweenPages {

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
    public void test() throws InterruptedException {
        driver.get (baseURL);
        String title = driver.getTitle ();
        System.out.println ("Title = " + title );

        String currentURL = driver.getCurrentUrl ();
        System.out.println ("Current URL is " + currentURL );

        // Navigating

        //driver.findElement (By.xpath ("//a[@href='/sign_in']"));

        String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
        driver.navigate ().to (urlToNavigate);

        currentURL = driver.getCurrentUrl ();
        System.out.println ("Current URL = " + currentURL );

        Thread.sleep (1000);

        driver.navigate ().back ();
        currentURL = driver.getCurrentUrl ();
        System.out.println ("Current URL = " + currentURL );

        Thread.sleep (1000);

        driver.navigate ().forward ();
        currentURL = driver.getCurrentUrl ();
        System.out.println ("Current URL = " + currentURL );

        Thread.sleep (1000);

        driver.navigate ().back ();
        currentURL = driver.getCurrentUrl ();
        System.out.println ("Current URL = " + currentURL );

        driver.navigate ().refresh ();
        System.out.println ("Refresh" );
        driver.get (currentURL);
        System.out.println ("Refreshing by getting current URL" );

        String pageSource = driver.getPageSource ();
        System.out.println (pageSource );
    }

    @After
    public void tearDown() throws Exception{
        driver.quit ();
        System.out.println ("Driver closed" );
    }

}
