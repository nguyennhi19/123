package Common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static void open() {
        Constant.driver.navigate().to(Constant.RAILWAY_URL);
    }

    public static void setChromeDriver(){
        System.setProperty(Constant.WEB_DRIVER_KEY,Constant.PATH_DRIVER_DIRECTION);
        Constant.driver = new ChromeDriver();
    }

    public static void setFirefoxDriver(){
        System.setProperty(Constant.FIREFOX_DRIVER_KEY,Constant.FIREFOX_DRIVER);
        Constant.driver = new FirefoxDriver();
    }

    public static void setDriver(String browser) {
        System.out.println("Pre-condition");
        switch ( browser ) {
            case "firefox":
                setFirefoxDriver();
                break;
            case "chrome":
                setChromeDriver();
                break;
            default:
                setChromeDriver();
        }
        DriverManager.open();
    }

    public static void closeBrowser() {
        System.out.println("Post-condition");
        Constant.driver.quit();
    }
}
