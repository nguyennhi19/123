package Common;

import org.openqa.selenium.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utilities {
    private static final String alpha = "abcdefghijklmnopqrstwvxyzABCDEFGHIJKLMNOPQRSTWVXYZ";
    private static final String digits = "0123456789";

    public static String genRandomString() {
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

    public static void scrollPageDownEnd() {
        Constant.DRIVER.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    public static void scrollToElement(By loc){
        WebElement element = Constant.DRIVER.findElement(loc);
        ((JavascriptExecutor) Constant.DRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yyyy");
        Calendar c1 = Calendar.getInstance();
        String today = java.time.LocalDate.now().toString();
        Date date = Date.valueOf(today);
        c1.setTime(date);
        c1.roll(Calendar.DATE, 5);
        String result =  dateFormat.format(c1.getTime());
        result = result.replace("-","/");
        return result;
    }

    public static void acceptPopup() {
        Alert alert = Constant.DRIVER.switchTo().alert();
        alert.accept();
    }
}