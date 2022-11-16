package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Utilities {
    private static final String alpha = "abcdefghijklmnopqrstwvxyzABCDEFGHIJKLMNOPQRSTWVXYZ";
    private static final String digits = "0123456789";

    public static String GenRandomString() {
        int rdText;
        int rdNumber;
        String randomString = "";
        Random rd = new Random();
        for (int i = 0; i < 3; i++) {
            rdText = rd.nextInt(alpha.length() - 1);
            randomString+=(Character.toString(alpha.charAt(rdText)));
            rdNumber = rd.nextInt(digits.length() - 1);
            randomString+=(Character.toString(digits.charAt(rdNumber)));
        }
        return randomString ;
    }

    public static void pageDownEnd() {
        Constant.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public static void getScrollToElement(By loc){
        WebElement element = Constant.driver.findElement(loc);
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
