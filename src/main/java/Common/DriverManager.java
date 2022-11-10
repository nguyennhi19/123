package Common;

public class DriverManager {
    public static void open() {
        Constant.driver.navigate().to(Constant.RAILWAY_URL);
    }
}
