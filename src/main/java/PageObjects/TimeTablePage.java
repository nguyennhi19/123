package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TimeTablePage {
    // Locators

    //Elements

    //Methods
    public void checkPriceFormTrainTimeTableScreen(String departFrom, String arriveAt){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='check price']";
        Utilities.getScrollToElement(By.xpath(String.format(text,departFrom,arriveAt)));
        Constant.driver.findElement(By.xpath(String.format(text,departFrom,arriveAt))).click();
    }

    public void bookTicketFormTrainTimeTableScreen(String departFrom, String arriveAt){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='book ticket']";
        Utilities.getScrollToElement(By.xpath(String.format(text,departFrom,arriveAt)));
        Constant.driver.findElement(By.xpath(String.format(text,departFrom,arriveAt))).click();
    }

}
