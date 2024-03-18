package Tests.Assignment.TestNGAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGAssignment4 extends TestBase{

    /*
    Open the site: http://opencart.abstracta.us/index.php?route=account/login
    Login with that credentials
    Email: clarusway@gmail.com
    Password: 123456789
    Using the Search function do it with Data Provider for Mac, iPad and Samsung.
    */


    @Test(dataProvider = "devices")
    public void opencartTest (String device){
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");

        By Email = By.xpath("//input[@id='input-email']");
        By password = By.xpath("//input[@id='input-password']");
        By loginButton = By.xpath("//input[@type='submit']");

        driver.findElement(Email).sendKeys("clarusway@gmail.com");
        driver.findElement(password).sendKeys("123456789");
        bot.click(loginButton);


        By searchInput = By.xpath("//input[@name='search']");
        Actions actions = new Actions(driver);

        actions.sendKeys(driver.findElement(searchInput), device)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();


        By items = By.className("product-layout");
        System.out.println("Device: " + device + " - Number of items: " + driver.findElements(items).size());


    }
    @DataProvider(name = "devices")
    public Object[][] deviceData() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}
