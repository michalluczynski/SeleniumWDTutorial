package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindByNameDemo {

    public static void main(String[] args) {

        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");

        WebDriver driver= new ChromeDriver (  );
        String baseURL = "https://learn.letskodeit.com/p/practice";

        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10,TimeUnit.SECONDS);

        driver.get (baseURL);
        driver.findElement (By.name ("enter-name")).sendKeys ("bangbang");

        // Xpath = "//*[@name='enter-name']";


    }
}
