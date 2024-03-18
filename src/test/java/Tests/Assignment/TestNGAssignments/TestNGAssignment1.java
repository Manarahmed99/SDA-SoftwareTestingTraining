package Tests.Assignment.TestNGAssignments;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGAssignment1 extends TestBase{
        /*
        Create tests that depend on each other
        Create beforeClass and set up settings.
        By creating interdependent tests;
        First go to Facebook.
        Then go to Google depending on Facebook,
        Then go to Amazon depending on Google
        Close the driver.
         */




    @Test
    public void FacebookTests(){
        bot.navigate("https://www.facebook.com");
        System.out.println("Facebook");

    }

    @Test(dependsOnMethods = "FacebookTests")
    public void GoogleTests(){
        bot.navigate("https://www.google.com");
        System.out.println("Google");

    }

    @Test(dependsOnMethods = "GoogleTests")
    public void AmazonTests(){
        bot.navigate("https://www.amazon.com");
        System.out.println("Amazon");

    }

}
