package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TimeTablePage {
    // Locators

    //Elements

    //Methods
    private void getScrollToElement(String departFrom, String arriveAt){
        WebElement element = Constant.driver.findElement(By.xpath("//td[text()='"+departFrom+"']//following-sibling::td[text()='"+arriveAt+"']//following-sibling::td//a[text()='book ticket']"));
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }

    public void CheckPriceFormTrainTimeTableScreen(String departFrom, String arriveAt){
        Constant.driver.findElement(By.xpath("//td[text()='"+departFrom+"']//following-sibling::td[text()='"+arriveAt+"']//following-sibling::td//a[text()='check price']")).click();
    }

    public void BookTicketFormTrainTimeTableScreen(String departFrom, String arriveAt){
        this.getScrollToElement(departFrom,arriveAt);
        Constant.driver.findElement(By.xpath("//td[text()='"+departFrom+"']//following-sibling::td[text()='"+arriveAt+"']//following-sibling::td//a[text()='book ticket']")).click();
    }

}
