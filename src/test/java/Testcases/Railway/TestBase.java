package Testcases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJava\\NguyenNhi_Railway_Automation\\src\\main\\resources\\Executables\\chromedriver.exe");
        Constant.driver = new ChromeDriver();
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.gotoLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.driver.quit();
    }
}
