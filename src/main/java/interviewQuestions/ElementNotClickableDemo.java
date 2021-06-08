package interviewQuestions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ElementNotClickableDemo {

    WebDriver driver;
    String baseURL;
    JavascriptExecutor jse;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\\\Users\\\\micha\\\\Tools\\\\drivers\\\\chromedriver.exe");
        driver = new ChromeDriver (  );
        jse = (JavascriptExecutor) driver;
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void test(){

        // Site no longer available in form from the course

        // In this course, a button is overlapped by another layer, in this case, /div
        // You can overcome this by either creating method to wait until layer is
        // invisible, or click the button behind the layer the hard way, by JS execution


        driver.get ("https://freecrm.com/index.html");
        WebDriverWait wait = new WebDriverWait (driver,3);

        // Not hard-coded mode, boolean and if statement to check whether obscuring element is gone

        WebElement loginButton = wait.until (ExpectedConditions.visibilityOfElementLocated (By.id ("preloader" )));
        boolean invisible = wait.until (ExpectedConditions.invisibilityOfElementLocated (By.xpath ("//input[@value='Login']")));
        if (invisible){
            loginButton.click ();
        }

        // Hard-coded way, JS execution

        jse.executeScript ("arguments[0].click()", loginButton);

    }

    @After
    public void tearDown(){
        driver.quit ();
    }



}
