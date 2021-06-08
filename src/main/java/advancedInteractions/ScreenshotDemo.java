package advancedInteractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumMethodsAndProperties.GenericMethods;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotDemo {

    WebDriver driver;
    String baseURL;
    GenericMethods gm;


    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://www.facebook.com/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
        driver.get (baseURL);
        gm = new GenericMethods (driver);
    }

    @Test
    public void testScreenshot(){
        WebElement akceptujWszystkie = driver.findElement (By.xpath ("//*[text()='Akceptuj wszystkie']"));
        akceptujWszystkie.click ();

        WebElement loginButton = driver.findElement (By.xpath ("//*[@data-testid='royal_login_button']") );
        loginButton.click ();
    }

    @After
    public void tearDown() throws InterruptedException, IOException {
        Thread.sleep (3000);

        //from course
        /*String filename = gm.getRandomString (10) + ".png";
        String directory = System.getProperty ("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs (OutputType.FILE);
        FileUtils.copyFile (sourceFile, new File(directory + filename));*/

        //additional method
        gm.takeScreenshot ();
        driver.quit ();
    }

}
