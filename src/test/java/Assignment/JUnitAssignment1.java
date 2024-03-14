package Assignment;

import Junit.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class JUnitAssignment1 extends Tests {

    /*
    Go to URL: https://api.jquery.com/dblclick/
    Double click on the blue square at the bottom of the page and then write the changed color.
    Go top of the page and sendKeys "Thanks to JavascriptExecutor"
    Go to the bottom of the page and click the book, name"jQuery in Action"
    */


    @Test
    public void JqueryClickTestcase() {
        bot.navigate("https://api.jquery.com/dblclick/");

        // Double click blue square
        driver.switchTo().frame(0);
        By squareBlueColouredButton = By.cssSelector("div");
        new Actions(driver)
                .doubleClick(driver.findElement(squareBlueColouredButton))
                .perform();
        String changedColor = driver.findElement(squareBlueColouredButton).getCssValue("background-color");
        Assertions.assertEquals("rgba(255, 255, 0, 1)", changedColor);
        System.out.println("Color = " + changedColor);

        driver.switchTo().defaultContent();

        // Send keys
        By sendKeyThanksToJavascriptExecutor = By.name("s");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        js.executeScript("arguments[0].value = 'Thanks to JavascriptExecutor'", driver.findElement(sendKeyThanksToJavascriptExecutor));
        Assertions.assertEquals("Thanks to JavascriptExecutor", driver.findElement(sendKeyThanksToJavascriptExecutor).getAttribute("value"));
        System.out.println(driver.findElement(sendKeyThanksToJavascriptExecutor).getAttribute("value"));

        // Click the book
        By TheBookName = By.xpath("//a[@href='https://www.manning.com/books/jquery-in-action-third-edition']");
        bot.click(TheBookName);
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition",  driver.getCurrentUrl());
        System.out.println("The webpage: " + driver.getTitle());
    }


}
