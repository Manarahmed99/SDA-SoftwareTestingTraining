package Tests.Assignment.JunitAssignments;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class JUnitAssignment4 extends TestBase {



    /*
     ( This task should be managed with keyboard actions )
     go to https://www.google.com/
     search for "Scroll Methods" by using an Actions object
     */


    @Test
    public void keyboard_actions (){
        bot.navigate("https://www.google.com/");

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("croll")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethods")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        By result = By.id("result-stats");
        System.out.println(driver.findElement(result).getText());

    }
}
