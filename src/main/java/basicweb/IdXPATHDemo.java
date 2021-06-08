package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IdXPATHDemo {

    public static void main(String[] args) {

        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver (  );
        String baseURL = "https://learn.letskodeit.com/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.get (baseURL);
        //driver.close ();

        driver.findElement (By.xpath ("//a[@href='/sign_in']")).click ();

        driver.findElement (By.id ("user_email")).sendKeys ("test@email.com");

    }
}
