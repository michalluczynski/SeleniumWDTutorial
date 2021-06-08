package switchWindowAndIFrames;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumMethodsAndProperties.GenericMethods;

import java.util.concurrent.TimeUnit;

public class SwitchAlert {

    WebDriver driver;
    String baseURL;
    GenericMethods gm;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://letskodeit.teachable.com/p/practice";
        gm = new GenericMethods(driver);
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get (baseURL);
        Thread.sleep (1000);
        WebElement textBox = driver.findElement (By.id ("name"));
        textBox.sendKeys ("Anil");
        WebElement alertButton = driver.findElement (By.id ("alertbtn"));
        alertButton.click ();

        Thread.sleep (2000);

        Alert alert = driver.switchTo ( ).alert ( );
        alert.accept ();
        //alertPopup.dismiss();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get (baseURL);

        Thread.sleep (1000);
        WebElement textBox = driver.findElement (By.id ("name"));
        textBox.sendKeys ("Anil");
        WebElement confirmButton = driver.findElement (By.id ("confirmbtn"));
        confirmButton.click ();

        Thread.sleep (2000);

        Alert alert = driver.switchTo ( ).alert ( );
        alert.accept ();

        Thread.sleep (2000);

        confirmButton.click ();

        Thread.sleep (2000);

        driver.switchTo ( ).alert ( );
        alert.dismiss ();
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get (baseURL);

        Thread.sleep (1000);
        WebElement textBox = driver.findElement (By.id ("name"));
        textBox.sendKeys ("Anil");
        WebElement alertButton = driver.findElement (By.id ("alertbtn"));
        alertButton.click ();

        Thread.sleep (2000);

        gm.acceptAlert ();
    }

    @Test
    public void test4() throws InterruptedException {
        driver.get (baseURL);

        Thread.sleep (1000);
        WebElement textBox = driver.findElement (By.id ("name"));
        textBox.sendKeys ("Anil");
        WebElement confirmButton = driver.findElement (By.id ("confirmbtn"));
        confirmButton.click ();

        Thread.sleep (2000);

        gm.acceptAlert ();

        Thread.sleep (2000);

        confirmButton.click ();

        Thread.sleep (2000);

        gm.dismissAlert ();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (2000);
        driver.quit ();
    }

}
