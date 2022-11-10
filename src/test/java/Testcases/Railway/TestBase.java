package Testcases.Railway;

import Common.Constant;
import Common.DriverManager;
import PageObjects.Railway.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJava\\NguyenNhi_Railway_Automation\\src\\main\\resources\\Executables\\chromedriver.exe");
        Constant.driver = new ChromeDriver();
        DriverManager.open();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.driver.quit();
    }
}
