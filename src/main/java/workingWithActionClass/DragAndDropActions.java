package workingWithActionClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDropActions {

    WebDriver driver;
    String baseURL;

    @Before
    public void setUp(){
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\micha\\Tools\\drivers\\chromedriver.exe");
        driver = new ChromeDriver (  );
        baseURL = "https://jqueryui.com/droppable/";
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait (3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get (baseURL);

        Thread.sleep (2000);

        driver.switchTo ().frame (0);

        WebElement fromElement = driver.findElement (By.id ("draggable"));
        WebElement toElement = driver.findElement (By.id ("droppable"));

        Actions action = new Actions (driver);

        //Drag and drop (automatic operation)
        //action.dragAndDrop (fromElement, toElement).perform ();

        Thread.sleep (2000);
        //Click and hold, move to element, release, build and perform (manual operation simulation)
        action.clickAndHold ( fromElement ).moveToElement (toElement).release ( fromElement ).build ().perform ();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep (2000);
        driver.quit ();
    }

}
