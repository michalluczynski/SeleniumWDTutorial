package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverWindows {

    public static void main(String[] args) {

        System.setProperty ("webdriver.edge.driver", "C:\\Users\\micha\\Tools\\drivers\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver (  );
        String baseURL = "http://www.google.com";
        driver.get (baseURL);
        driver.quit ( );

    }
}
