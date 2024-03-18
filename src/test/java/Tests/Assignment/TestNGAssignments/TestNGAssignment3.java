package Tests.Assignment.TestNGAssignments;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssignment3 extends TestBase{
        /*
            go to "https://practicetestautomation.com/practice-test-login/"
            enter username - "student"
            enter password - "incorrectPassword"
            and login
            SOFT ASSERT the error message shown
            SOFT ASSERT the error message is "Your password is invalid!"
        */

    @Test
    public void practiceTestAutomation (){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        By username = By.xpath("//input[@name='username']");
        By password = By.xpath("//input[@name='password']");
        By loginButton = By.xpath("//button[@id='submit']");

        driver.findElement(username).sendKeys("student");
        driver.findElement(password).sendKeys("incorrectPassword");
        bot.click(loginButton);

        By actualErrorMessage = By.xpath("//div[@class='show']");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(actualErrorMessage).getText(), "Your password is invalid!", "Error message mismatch");
        softAssert.assertAll();




    }



}
