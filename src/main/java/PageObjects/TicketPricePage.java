package PageObjects;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Locator
    private final By loc_btnCheckPrice = By.xpath("//li[text()='%s to %s']/parent::td//following-sibling::td//a[text()='Check Price']");
    private final By loc_btnBookTicket = By.xpath("//td[text()='%s']//following-sibling::td//a");
    private final By loc_priceOfEachSeat= By.xpath("//th[contains(text(),'Price')]//following-sibling::td[%s]");

    //Elements

    private WebElement getBtnCheckPrice(){
        return Constant.driver.findElement(loc_btnCheckPrice);
    }

    private WebElement getBtnBookTicket(){
        return Constant.driver.findElement(loc_btnBookTicket);
    }

    private WebElement gettextPriceOfEachSeat(){
        return Constant.driver.findElement(loc_priceOfEachSeat);
    }

    //Methods
    public void CheckPriceFormTrainTicketPriceListScreen(){
        this.getBtnCheckPrice().click();
    }

    public void BookTicketFormTicketPriceScreen(){
        this.getBtnBookTicket().click();
    }

}
