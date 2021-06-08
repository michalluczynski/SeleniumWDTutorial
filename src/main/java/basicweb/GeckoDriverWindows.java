package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeckoDriverWindows {

    public static void main(String[] args) {

        System.setProperty ("webdriver.gecko.driver", "C:\\Users\\micha\\Tools\\drivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver (  );
        String baseURL = "https://www.google.com/";
        driver.get(baseURL);
        driver.close ();
    }
}
