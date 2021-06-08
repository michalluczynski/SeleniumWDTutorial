package seleniumMethodsAndProperties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GenericMethods {

    WebDriver driver;
    JavascriptExecutor jse;

    public GenericMethods(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type){
        type = type.toLowerCase(Locale.ROOT);
        if (type.equals ("id")){
            System.out.println ("Element found with id: " + locator);
            return this.driver.findElement (By.id (locator));
        }
        else if (type.equals ("xpath")){
            System.out.println ("Element found with xpath: " + locator);
            return this.driver.findElement (By.xpath (locator));
        }
        else if (type.equals ("css")){
            System.out.println ("Element found with css: " + locator);
            return this.driver.findElement (By.cssSelector (locator));
        }
        else if (type.equals ("linktext")){
            System.out.println ("Element found with linktext: " + locator);
            return this.driver.findElement (By.linkText (locator));
        }
        else if (type.equals ("partiallinktext")){
            System.out.println ("Element found with partiallinktext: " + locator);
            return this.driver.findElement (By.partialLinkText (locator));
        }
        else{
            System.out.println ("Locator type not supported" );
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type){
        type = type.toLowerCase(Locale.ROOT);
        if (type.equals ("id")){
            System.out.println ("Element found with id: " + locator);
            return this.driver.findElements (By.id (locator));
        }
        else if (type.equals ("xpath")){
            System.out.println ("Element found with xpath: " + locator);
            return this.driver.findElements (By.xpath (locator));
        }
        else if (type.equals ("css")){
            System.out.println ("Element found with css: " + locator);
            return this.driver.findElements (By.cssSelector (locator));
        }
        else if (type.equals ("linktext")){
            System.out.println ("Element found with linktext: " + locator);
            return this.driver.findElements (By.linkText (locator));
        }
        else if (type.equals ("partialinktext")){
            System.out.println ("Element found with partiallinktext: " + locator);
            return this.driver.findElements (By.partialLinkText (locator));
        }
        else{
            System.out.println ("Locator type not supported" );
            return null;
        }
    }

   /* public List<WebElement> getElementList (String locator, String type){
        type.toLowerCase(Locale.ROOT);
        List<WebElement> elementList = new ArrayList<WebElement> ( );
        if (type.equals ("id")){
            elementList = this.driver.findElement (By.id (locator));
        }
        return elementList;
    }*/

    public boolean isElementPresent(String locator, String type){
        List<WebElement> elementList = getElementList (locator,type);
        int size = elementList.size ();

        if(size>0){
            return true;
        }
        else{
            return false;
        }
    }

    public WebElement waitForElement (By locator, int timeout){
        WebElement element = null;
        try {
            System.out.println ("Waiting for maximum of " + timeout + " seconds for element to be available" );

            WebDriverWait wait = new WebDriverWait (driver, timeout);
            element = wait.until (
                    ExpectedConditions.visibilityOfElementLocated (locator));
            System.out.println ("Element appeared on the web page" );
        }catch (Exception e){
            System.out.println ("Element not appeared onb the web page" );
        }
        return element;
    }

    public void clickWhenReady (By locator, int timeout){
        try {
            WebElement element = null;
            System.out.println ("Waiting for maximum of " + timeout + " seconds for element to be clickable" );

            WebDriverWait wait = new WebDriverWait (driver, timeout);
            element = wait.until (
                    ExpectedConditions.elementToBeClickable (locator));
            element.click ();
            System.out.println ("Element is clicked" );
        }catch (Exception e){
            System.out.println ("Element is not clickable" );
        }
    }

    public void clickWhenReadyWebElement (WebElement locator, int timeout){
        try {
            WebElement element = null;
            System.out.println ("Waiting for maximum of " + timeout + " seconds for element to be clickable" );

            WebDriverWait wait = new WebDriverWait (driver, timeout);
            element = wait.until (
                    ExpectedConditions.elementToBeClickable (locator));
            element.click ();
            System.out.println ("Element is clicked" );
        }catch (Exception e){
            System.out.println ("Element is not clickable" );
        }
    }

    public String getRandomString (){
        int length = 10;
        StringBuilder sb = new StringBuilder (  );
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";

        for (int i=0; i<length; i++){
            int index = (int)(Math.random () * characters.length ());
            sb.append (characters.charAt (index));
        }

        return sb.toString ();
    }

    public String takeScreenshot () throws IOException {
        String filename = getRandomString () + ".png";
        String directory = System.getProperty ("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs (OutputType.FILE);
        FileUtils.copyFile (sourceFile, new File(directory + filename));

        return filename;
    }

    public void acceptAlert(){
        Alert alert = driver.switchTo ( ).alert ( );
        alert.accept ();
    }

    public void dismissAlert(){
        Alert alert = driver.switchTo ().alert ();
        alert.dismiss();
    }

    public void scrollBy(int width, int height){
        jse = (JavascriptExecutor) driver;
        jse.executeScript ("window.scrollBy("+width+","+height+");");
    }

    public void hover(WebElement locator){
        Actions action = new Actions(driver);
        action.moveToElement (locator).perform ();
    }

}
