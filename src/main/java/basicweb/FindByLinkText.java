package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FindByLinkText {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty ("webdriver.gecko.driver", "C:\\Users\\micha\\Tools\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver (  );

        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);

        String baseURL = "https://letskodeit.teachable.com/";

        driver.get (baseURL);
        driver.findElement (By.linkText ("Login")).click ();
        Thread.sleep (3000);
        driver.get (baseURL);
        driver.findElement (By.partialLinkText ("Pract")).click();

    }

}
