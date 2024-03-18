package Tests.Assignment.JunitAssignments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class JUnitAssignment3 extends TestBase{

     /*
        Go to URL: http://demo.guru99.com/test/drag_drop.html
        Drag and drop the BANK button to the Account section in DEBIT SIDE
        Drag and drop the SALES button to the Account section in CREDIT SIDE
        Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        Verify the visibility of Perfect text.
        */

    @Test
    public void drag_drop_test() {

        driver.navigate().to(" http://demo.guru99.com/test/drag_drop.html");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        By Bank_Button = By.id("credit2");
        By Account_section_DEBIT_SIDE = By.id("bank");

        new Actions(driver)
                .dragAndDrop(driver.findElement(Bank_Button)
                        , driver.findElement(Account_section_DEBIT_SIDE))
                .perform();

        // Drag and drop the SALES button to the Account section in CREDIT SIDE
        By Sales_Button = By.id("credit1");
        By Account_section_CREDIT_SIDE = By.id("shoppingCart3");

        new Actions(driver)
                .dragAndDrop(driver.findElement(Sales_Button)
                        , driver.findElement(Account_section_CREDIT_SIDE))
                .perform();

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE

        By Button_5000_1 = By.xpath("(//li[@id='fourth'])[1]");
        By Amount_section_DEBIT_SIDE = By.id("amt7");

        new Actions(driver)
                .dragAndDrop(driver.findElement(Button_5000_1)
                        , driver.findElement(Amount_section_DEBIT_SIDE))
                .perform();

        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE

        By Button_5000_2 = By.xpath("(//li[@id='fourth'])[2]");
        By Amount_section_CREDIT_SIDE = By.id("amt8");

        new Actions(driver)
                .dragAndDrop(driver.findElement(Button_5000_2)
                        , driver.findElement(Amount_section_CREDIT_SIDE))
                .perform();

        // Verify the visibility of Perfect text.
        By Debit_Movement = By.xpath("//div[@id='t7']");
        Assertions.assertEquals("5000", driver.findElement(Debit_Movement).getText());

        By Credit_Movement = By.xpath("//div[@id='t8']");
        Assertions.assertEquals("5000", driver.findElement(Credit_Movement).getText());


        By Perfect = By.xpath("(//a[contains(@class,'button button-green')])[1]");
        Assertions.assertEquals("Perfect!", driver.findElement(Perfect).getText());


    }

}
