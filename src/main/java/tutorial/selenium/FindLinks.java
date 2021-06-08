package tutorial.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.classes.SearchPage;

import java.net.URL;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindLinks {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );

        //baseURL = "https://www.expedia.com/";
        baseURL = "https://www.udemy.com";

        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (2, TimeUnit.SECONDS);
    }

    @Test
    public void testFindLinks(){
        driver.get (baseURL);

        //SearchPage.navigateToFlightsTab (driver);

        List<WebElement> linksList = clickableLinks ();
        for(WebElement link : linksList){
            String href = link.getAttribute ("href");
            try{
                System.out.println ("URL " + href  + " return " + linksStatus (new URL (href)));
            } catch (Exception e) {
                System.out.println (e.getMessage () );
            }
        }
    }

    public List<WebElement> clickableLinks(){
        List<WebElement> linksToClick = new ArrayList<WebElement> (  );
        // elements - any element on website
        List<WebElement> elements = driver.findElements (By.tagName ("a"));
        elements.addAll (driver.findElements (By.tagName ("img")));

        for(WebElement e : elements){
            if(e.getAttribute ("href")!=null){
                linksToClick.add (e);
            }
        }
        return linksToClick;
    }

    public static String linksStatus(URL url){
        try{
            HttpURLConnection http = (HttpURLConnection) url.openConnection ();
            http.connect ();
            String responseMessage = http.getResponseMessage ();
            http.disconnect ();

            return responseMessage;
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

    @After
    public void tearDown(){
        driver.quit ();
    }

}
