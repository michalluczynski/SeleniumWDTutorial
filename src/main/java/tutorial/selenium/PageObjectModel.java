package tutorial.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.classes.SearchPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageObjectModel {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://www.expedia.com/";

        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (2, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get (baseURL);
        SearchPage.navigateToFlightsTab (driver);
        SearchPage.fillOriginTextBox (driver, "New York");
        SearchPage.selectFirstResultOriginTextBox (driver);
        Thread.sleep (1000);
        SearchPage.fillDestinationTextBox (driver, "Chicago");
        SearchPage.selectFirstResultDestinationTextBox (driver);

        Thread.sleep (1000);

        // Due to changes done in the page this won't work

        //SearchPage.departureDate (driver).sendKeys ();
        //SearchPage.returnDate (driver).sendKeys ();

        SearchPage.clickOnSearchButton (driver);

        Thread.sleep (1000);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get (baseURL);

        SearchPage.navigateToFlightsTab (driver);
        SearchPage.fillOriginTextBox (driver, "New York");

        // Declaration of web element - ul box with li elements

        WebElement results = driver.findElement(By.xpath ("//ul[@data-stid='location-field-leg1-origin-results']"));

        // Declaration of list of those elements

        List<WebElement> resultsList = results.findElements(By.tagName("strong"));

        for (WebElement listElement : resultsList){
            System.out.println ("Current item: " + listElement.getText ());
            listElement.click ();
            break;
            /*if(listElement.getText ( ) == "New York (NYC - All Airports)"){
                listElement.click ();
                break;
            }*/
        }


        Thread.sleep (2000);

        SearchPage.clickOnSearchButton (driver);
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get (baseURL);

        SearchPage.navigateToFlightsTab (driver);
        SearchPage.fillOriginTextBox (driver, "New York");
        SearchPage.resultSelector (driver, "//ul[@data-stid='location-field-leg1-origin-results']");
        //SearchPage.clickOnSearchButton (driver);
        SearchPage.destinationTextBox (driver);

        Thread.sleep (2000);

        //SearchPage.fillDestinationTextBox (driver, "Chicago");
        SearchPage.resultSelector (driver, "//ul[@data-stid='location-field-leg1-destination-results']");
        //SearchPage.clickOnSearchButton (driver);

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep (2000);
        driver.quit ();
    }

}
