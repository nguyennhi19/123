package Testcases.Railway;

import Common.DriverManager;
import PageObjects.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.setDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.closeBrowser();
    }
}
