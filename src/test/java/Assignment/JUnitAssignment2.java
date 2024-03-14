package Assignment;

import Junit.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class JUnitAssignment2 extends Tests {

    /*
    Go to URL: https://the-internet.herokuapp.com/windows
    Verify the text: “Opening a new window”
    Verify the title of the page is “The Internet”
    Click on the “Click Here” button
    Verify the new window title is “New Window”
    Go back to the previous window and then verify the title: “The Internet”
     */

    @Test
    public void InternetHerokuAppWindows(){

        bot.navigate("https://the-internet.herokuapp.com/windows");



        By text = By.tagName("h3");
        Assertions.assertEquals("Opening a new window",driver.findElement(text).getText());
        System.out.println("The Text is : "+driver.findElement(text).getText());

        Assertions.assertEquals("The Internet",driver.getTitle());
        System.out.println("Title Main Window:  "+driver.getTitle());
        // Get the current window handle
        String mainWindowHandle = driver.getWindowHandle();


        By button = By.xpath("//a[@href='/windows/new']");
        bot.click(button);

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String windowHandle : allWindowHandles) {
            // Switch to the desired window
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                Assertions.assertEquals("New Window",driver.getTitle());
                System.out.println("Title new window : " + driver.getTitle());
                // driver.close();
            }
        }



        driver.switchTo().window(mainWindowHandle);
        Assertions.assertEquals("The Internet",driver.getTitle());

        System.out.println("Switch to Main window to get title : "+driver.getTitle());



    }

}
