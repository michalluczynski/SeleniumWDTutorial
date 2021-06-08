package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FindByClassDemo {

    public static void main(String[] args) {

        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver (  );

        String baseURL = "https://learn.letskodeit.com/p/practice";
        driver.get (baseURL);
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);

        driver.findElement (By.className ("btn-style")).click ();


    }



}
