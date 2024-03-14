package Assignment;

import Junit.Tests;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class JUnitAssignment7 extends Tests {

            /*
                 Assignment 7
                 Go to amazon.com
                 Take Full Page Screenshot.
                 Take any spesific WebElement ScreenShot
             */


    @Test
    public void ScreenShotTest()throws IOException {

        bot.navigate("https://www.amazon.com");

        // Take Full Page Screenshot
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fullPageScreenshot, new File("full_page_screenshot.png"));

        // Take specific WebElement Screenshot
        WebElement element = driver.findElement(By.className("a-logo"));
        File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementScreenshot, new File("elementScreenshot.png"));






    }

}
