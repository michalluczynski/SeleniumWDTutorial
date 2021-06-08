package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverWindows {

    public static void main(String[] args) {

        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver (  );
        String baseURL = "https://www.google.com/";
        driver.get (baseURL);
        driver.close ();
    }

}
