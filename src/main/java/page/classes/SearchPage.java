package page.classes;

import org.openqa.selenium.*;

import java.util.List;



public class SearchPage {

    JavascriptExecutor jse;

    public static WebElement element = null;

    /**
     * Returns the flight origin text box element
     *
     * @param driver
     * @return
     */
    public static WebElement originTextBox(WebDriver driver) {
        element = driver.findElement (By.xpath ("//button[@aria-label='Leaving from']"));
        return element;
    }

    public static WebElement fillOriginTextBox(WebDriver driver, String origin) {
        element = originTextBox (driver);
        element.sendKeys (origin);
        return element;
    }

    public static WebElement selectFirstResultOriginTextBox(WebDriver driver){
        WebElement firstResult = driver.findElement (By.xpath ("//li[@data-index='0']"));
        firstResult.click ();
        return element;
    }

    /**
     * Returns the flight destination text box element
     * @param driver
     * @return
     */
    public static WebElement destinationTextBox(WebDriver driver){
        element = driver.findElement (By.id ("location-field-leg1-destination-menu"));
        element.click ();
        System.out.println (element.isEnabled ());
        System.out.println (element.isSelected ());
        System.out.println (element.isDisplayed ());

        System.out.println (element.getTagName ());

        return element;
    }

    public static WebElement fillDestinationTextBox(WebDriver driver, String destination){
        element = destinationTextBox (driver);
        element.sendKeys(destination);
        return element;
    }

    public static WebElement selectFirstResultDestinationTextBox(WebDriver driver) {
        WebElement firstResult = driver.findElement (By.xpath ("//button[@data-stid=\"location-field-leg1-destination-result-item-button\"]"));
        firstResult.click ( );
        return element;
    }

    /**
     * Returns the departure date text box element
     * @param driver
     * @return
     */
    public static WebElement depoartureDate(WebDriver driver){
        element = driver.findElement (By.xpath ("//button[@data-name='startDate']") );
        return element;
    }

    /**
     * Returns the return date text box element
     * @param driver
     * @return
     */
    public static WebElement returnDate(WebDriver driver){
        element = driver.findElement (By.xpath ("//button[@data-name='endDate']") );
        return element;
    }

    /**
     * Returns the search button box element
     * @param driver
     * @return
     */
    public static WebElement searchButton(WebDriver driver){
        element = driver.findElement (By.xpath ("//button[@data-testid='submit-button']") );
        return element;
    }

    /**
     * Click on search button
     * @param driver
     * @return
     */
    public static WebElement clickOnSearchButton(WebDriver driver){
        element = searchButton (driver);
        element.click ();
        return element;
    }

    /**
     * Navigate to flights tab
     * @param driver
     * @return
     */
    public static WebElement navigateToFlightsTab(WebDriver driver){
        driver.findElement (By.xpath ("//img[@alt='expedia logo']") ).click ();
        element = driver.findElement (By.xpath ("//a[@href='?pwaLob=wizard-flight-pwa']") );
        element.click ();
        return element;
    }

    public static WebElement resultSelector(WebDriver driver, String locator){
        WebElement listOfResults = driver.findElement (By.xpath (locator) );
        List<WebElement> results = listOfResults.findElements (By.tagName ("strong"));

        for(WebElement element : results){
            element.click ();
            break;
        }
        return element;
    }


}
