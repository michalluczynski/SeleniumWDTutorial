package interviewQuestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NoSuchElementDemo {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUpo(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );

        driver.manage ().window ().maximize ();
        //driver.manage ().timeouts ().implicitlyWait (2, TimeUnit.SECONDS);

        baseURL = "https://letskodeit.teachable.com/";
    }

    @Test
    public void test(){
        driver.get (baseURL);

        // 1. Timing issues --> use implicitly wait or explicitly wait for very long loads
        WebElement loginLink = driver.findElement (By.xpath ("//a[@href='/sign_in']") );
        loginLink.click ();
        //WebElement emailField = driver.findElement (By.id ("user_email") );
        //emailField.sendKeys ("wut");
        WebDriverWait wait = new WebDriverWait (driver, 3);
        WebElement emailField = wait.until((
                ExpectedConditions.visibilityOfElementLocated (By.id ("user_email"));
        emailField.sendKeys ("henlo");

        // 2. Incorrect locator or type of locator

        //loginLink.click ();

        // Make sure locator and it's type are okay

        // 3. Element is in iFrame

        driver.get ("https://letskodeit.teachable.com/p/practice");
        WebElement iFrameWindow = driver.findElement (By.id ("courses-iframej") );
        driver.switchTo ().frame (iFrameWindow);

        driver.findElement (By.id ("search-courses"));

    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
