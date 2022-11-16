package PageObjects;

import Common.*;
import org.openqa.selenium.By;

public class TimeTablePage {
    // Locators

    //Elements

    //Methods
    public void checkPriceFormTrainTimeTableScreen(String departFrom, String arriveAt){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='check price']";
        Utilities.scrollToElement(By.xpath(String.format(text,departFrom,arriveAt)));
        Constant.DRIVER.findElement(By.xpath(String.format(text,departFrom,arriveAt))).click();
    }

    public void bookTicketFormTrainTimeTableScreen(String departFrom, String arriveAt){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='book ticket']";
        Utilities.scrollToElement(By.xpath(String.format(text,departFrom,arriveAt)));
        Constant.DRIVER.findElement(By.xpath(String.format(text,departFrom,arriveAt))).click();
    }
}