package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Locator
    private final By titleCheckPrice = By.xpath("//h1[contains(.,'Ticket Price')]");
    private final By titleTable = By.xpath("//th[contains(text(),'Ticket price from')]");

    //Elements
    private WebElement getContentPricePageTitle() {
        return Constant.driver.findElement(titleCheckPrice);
    }

    private WebElement getTitleTable(){
        return Constant.driver.findElement(titleTable);
    }

    //Methods
    private String getPrice(String seatType) {
        String text = "//th[contains(text(),'Price')]//following-sibling::td[count(//th[contains(text(),'Seat type')]//following-sibling::td[text()='%s']/preceding-sibling::td)+1]";
        return Constant.driver.findElement(By.xpath(String.format(text,seatType))).getText();
    }

    public void checkPriceFormTrainTicketPriceListScreen(String departFrom, String arriveAt){
        String text = "//li[text()='%s to %s']/parent::td//following-sibling::td//a[text()='Check Price']";
        Utilities.getScrollToElement(By.xpath(String.format(text,departFrom,arriveAt)));
        Constant.driver.findElement(By.xpath(String.format(text,departFrom,arriveAt))).click();
    }

    public void bookTicketFormTicketPriceScreen(String seatType){
        String text = "//td[text()='%s']//following-sibling::td//a";
        Utilities.getScrollToElement(By.xpath(String.format(text,seatType)));
        Constant.driver.findElement(By.xpath(String.format(text,seatType))).click();
    }

    public String getContentPricePage(){
        return getContentPricePageTitle().getText();
    }

    public String getTitleOfTable(){
        return getTitleTable().getText()  ;
    }

    public String getPriceOfHSAtTicketPricePage(String sH, String sS, String sSC, String hB, String sB, String sBC){
        return getPrice(sH) + getPrice(sS) + getPrice(sSC) + getPrice(hB) + getPrice(sB) + getPrice(sBC);
    }
}
