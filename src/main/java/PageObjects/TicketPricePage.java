package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage {
    //Locator
    private final By lblCheckPrice = By.xpath("//h1[contains(.,'Ticket Price')]");
    private final By lblTable = By.xpath("//th[contains(text(),'Ticket price from')]");

    //Elements
    private WebElement getContentPricePageTitle() {
        return Constant.DRIVER.findElement(lblCheckPrice);
    }

    private WebElement getTitleTable(){
        return Constant.DRIVER.findElement(lblTable);
    }

    //Methods
    private int getPrice(String seatType) {
        String text = "//th[contains(text(),'Price')]//following-sibling::td[count(//th[contains(text(),'Seat type')]//following-sibling::td[text()='%s']/preceding-sibling::td)+1]";
        return Integer.parseInt(Constant.DRIVER.findElement(By.xpath(String.format(text,seatType))).getText());
    }

    public void checkPriceFormTrainTicketPriceListScreen(String departFrom, String arriveAt){
        String text = "//li[text()='%s to %s']/parent::td//following-sibling::td//a[text()='Check Price']";
        Utilities.scrollToElement(By.xpath(String.format(text,departFrom,arriveAt)));
        Constant.DRIVER.findElement(By.xpath(String.format(text,departFrom,arriveAt))).click();
    }

    public void bookTicketFormTicketPriceScreen(String seatType){
        String text = "//td[text()='%s']//following-sibling::td//a";
        Utilities.scrollToElement(By.xpath(String.format(text,seatType)));
        Constant.DRIVER.findElement(By.xpath(String.format(text,seatType))).click();
    }

    public String getContentPricePage(){
        return getContentPricePageTitle().getText();
    }

    public String getTitleOfTable(){
        return getTitleTable().getText()  ;
    }

    public String getPriceOfHSAtTicketPricePage(String sH, String sS, String sSC, String hB, String sB, String sBC){
        return getPrice(sH) +", "+ getPrice(sS) +", "+ getPrice(sSC) +", "+ getPrice(hB) +", "+ getPrice(sB) +", "+ getPrice(sBC);
    }
}