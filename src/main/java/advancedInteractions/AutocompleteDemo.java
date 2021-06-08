package advancedInteractions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutocompleteDemo {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://www.goibibo.com/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
        driver.get (baseURL);
    }

    @Test
    public void test() throws InterruptedException {
        String partialText = "Del";
        String textToSelect = "Delhi, India(DEL)";

        WebElement textField = driver.findElement (By.id ("gosuggest_inputSrc" ) );
        textField.sendKeys (partialText);

        WebElement ulElement = driver.findElement (By.id ("react-autosuggest-1"));

        String innerHTML = ulElement.getAttribute ("innerHTML");
        System.out.println (innerHTML );

        List<WebElement> liElements = ulElement.findElements (By.tagName ("li"));
        Thread.sleep (3000);

        for(WebElement element : liElements){
            if (element.getText ().contains (textToSelect)){
                System.out.println ("Selected :" + element.getText ());
                element.click ();
                break;
            }
        }
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
