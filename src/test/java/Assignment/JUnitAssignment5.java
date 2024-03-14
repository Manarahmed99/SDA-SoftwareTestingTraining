package Assignment;

import Junit.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import java.util.Set;

public class JUnitAssignment5 extends Tests {

    /*
     Go to URL: http://facebook.com
     getCookies,
     addCookie,
     deleteCookieNamed,
     deleteAllCookies
    */

    @Test
    public void  cookies_Test(){
        bot.navigate("http://facebook.com");

        // getCookies,
        System.out.println("Initial size:" + driver.manage().getCookies().size());
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("All cookies: " + cookies);


        // addCookie,
        driver.manage().addCookie(new Cookie("newcookie","123"));
        // deleteCookieNamed,
        driver.manage().deleteCookieNamed("newcookie");

        // deleteAllCookies
        driver.manage().deleteAllCookies();



    }

}
