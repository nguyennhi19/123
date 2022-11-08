package PageObjects;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage {
    // Locators
    private final By loc_btnCheckPrice = By.xpath("//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='check price']");
    private final By loc_btnBookTicket = By.xpath("//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='book ticket']");

    //Elements
    private WebElement getBtnCheckPrice(){
        return Constant.driver.findElement(loc_btnCheckPrice);
    }
    private WebElement getBtnBookTicket(){
        return Constant.driver.findElement(loc_btnBookTicket);
    }

    //Methods
    public void CheckPriceFormTrainTimeTableScreen(){
        this.getBtnCheckPrice().click();
    }

    public void BookTicketFormTrainTimeTableScreen(){
        this.getBtnBookTicket().click();
    }
    pathspec 'master' did not match any file(s) known to git

}
