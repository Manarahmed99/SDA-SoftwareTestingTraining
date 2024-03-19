package Tests.Assignment.TestNGAssignments;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssignment5 extends TestBase{
        /*
            Go to URL: http://crossbrowsertesting.github.io/
            Click to To-Do App
            Checking Box to do-4 and Checking Box to do-5
            If both clicks worked, then the following List should be have length 2.
            Assert that this is correct
            Assert that the to do we added is present in the list
            Archiving old todos
            If our archive link worked, then the following list should have length 4.
            Assert that this is true as well
            Doing Cross Browser Testing.
         */

    @Test
    public void CrossBrowserTesting(){
        bot.navigate("http://crossbrowsertesting.github.io/");

        By to_do_app = By.xpath("//a[@href='todo-app.html']");
        By do_4 =  By.xpath("//input[@name='todo-4']");
        By do_5 =  By.xpath("//input[@name='todo-5']");
        bot.click(to_do_app);
        bot.click(do_4);
        bot.click(do_5);

        By remaining = By.xpath("//span[@class='done-true']");
        Assert.assertEquals(2, driver.findElements(remaining).size());


        By add_to_do_list = By.xpath("//input[@id='todotext']");
        By addButton = By.id("addbutton");
        bot.type(add_to_do_list,"new item");
        bot.click(addButton);

        By add_to_list = By.xpath("//span[@class='done-false' and text()='new item']");
        Assert.assertTrue(driver.findElement(add_to_list).isDisplayed());

        By archive_old_todos = By.xpath("//a[@ng-click='todoList.archive()']");
        bot.click(archive_old_todos);

        By number_new_todo_list = By.xpath("//span[@class='done-false']");
        Assert.assertEquals(4, driver.findElements(number_new_todo_list).size());









    }

}
