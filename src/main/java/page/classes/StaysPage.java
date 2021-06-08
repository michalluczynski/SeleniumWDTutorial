package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaysPage {

    WebDriver driver;

    @FindBy (xpath = "//span[text()='Stays']")
    WebElement staysTab;

    @FindBy (xpath = "//button[@aria-label='Going to']")
    WebElement goingToField;

    @FindBy (xpath = "//button[@data-testid='submit-button']")
    WebElement submitButton;

    @FindBy(id = "add-flight-switch")
    WebElement addFlightCheckbox;

    @FindBy(id = "add-car-switch")
    WebElement addCarCheckbox;

    @FindBy(xpath = "//button[@data-stid='location-field-destination-result-item-button']")
    WebElement resultsList;

    // Initializes this class

    public StaysPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements (driver, this);
    }

    public void clickStaysTab(){
        staysTab.click ();
    }

    public void clickGoingToField(){
        goingToField.click ();
    }

    public void fillGoingToField(String input){
        clickGoingToField ();
        goingToField.sendKeys (input);

        List<WebElement> results = resultsList.findElements (By.xpath ("//span/strong"));
        for(WebElement item : results){
            item.click ();
            break;
        }
    }

    public void clickSubmit(){
        submitButton.click ();
    }


}
