package Common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static void open() {
        Constant.DRIVER.navigate().to(Constant.RAILWAY_URL);
    }

    public static void setChromeDriver(){
        System.setProperty(Constant.WEB_DRIVER_KEY,Constant.PATH_DRIVER_DIRECTION);
        Constant.DRIVER = new ChromeDriver();
    }

    public static void setFirefoxDriver(){
        System.setProperty(Constant.FIREFOX_DRIVER_KEY,Constant.FIREFOX_DRIVER);
        Constant.DRIVER = new FirefoxDriver();
    }

    public static void setDriver(String browser) {
        Log.info("Pre-condition");
        switch ( browser ) {
            case "firefox":
                setFirefoxDriver();
                break;
            default:
                setChromeDriver();
        }
        DriverManager.open();
    }

    public static void closeBrowser() {
        Log.info("Post-condition");
        Constant.DRIVER.quit();
    }
}