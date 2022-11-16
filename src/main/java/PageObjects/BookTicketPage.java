package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //Locator
    private final By loc_successfullyTitle = By.xpath("//*[@id='content']/h1");
    private final By loc_selectDate = By.name("Date");
    private final By loc_selectDepartFrom = By.name("DepartStation");
    private final By loc_selectArriverAt = By.name("ArriveStation");
    private final By loc_selectSeatType = By.name("SeatType");
    private final By loc_selectTicketAmount = By.name("TicketAmount");
    private final By loc_btnLBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By loc_errorMessageAtArriveStation = By.xpath("//label[text()= 'Arrive at:']/following-sibling::label");
    private final By loc_errorMessageAtTicketAmount = By.xpath("//label[text()= 'Ticket amount:']/following-sibling::label");
    private final By loc_valueOfDepartStation = By.xpath("//tr//td[position()=1]");
    private final By loc_valueOfArriveStation = By.xpath("//tr//td[2]");
    private final By loc_valueOfSeatType = By.xpath("//tr//td[3]");
    private final By loc_valueOfDepartDate = By.xpath("//tr//td[4]");
    private final By loc_valueOfAmount = By.xpath("//tr//td[7]");
    private final By loc_bookTicketLbl = By.xpath("//h1[contains(.,'Book ticket')]");
    private final By loc_valueSelectedOfDepartFromDropbox = By.xpath("//select[@name = 'DepartStation']//option[@selected]");
    private final By loc_valueSelectedOfArriveAtDropbox = By.xpath("//select[@name = 'ArriveStation']//option[@selected]");

    //Elements
    private Select getSelectDate(){
        return new Select(Constant.driver.findElement(loc_selectDate));
    }

    private Select getSelectDepartFrom(){
        return new Select(Constant.driver.findElement(loc_selectDepartFrom));
    }

    private Select getSelectArriverAt(){
        return new Select(Constant.driver.findElement(loc_selectArriverAt));
    }

    private Select getSelectSeatType(){
        return new Select(Constant.driver.findElement(loc_selectSeatType));
    }

    private Select getSelectTicketAmount(){
        return new Select(Constant.driver.findElement(loc_selectTicketAmount));
    }

    private WebElement getBtnBookTicket(){
        return Constant.driver.findElement(loc_btnLBookTicket);
    }

    private WebElement getSuccessfulTitle(){
        return Constant.driver.findElement(loc_successfullyTitle);
    }

    private WebElement getErrorMessageAtArriveStation(){
        return Constant.driver.findElement(loc_errorMessageAtArriveStation);
    }

    private WebElement getErrorMessageAtTicketAmount(){
        return Constant.driver.findElement(loc_errorMessageAtTicketAmount);
    }

    private WebElement getValueOfAmountElement(){
        return Constant.driver.findElement(loc_valueOfAmount);
    }

    private WebElement getValueOfDepartDateElement(){
        return Constant.driver.findElement(loc_valueOfDepartDate);
    }

    private WebElement getValueOfSeatTypeElement(){
        return Constant.driver.findElement(loc_valueOfSeatType);
    }

    private WebElement getValueOfArriveStationElement(){
        return Constant.driver.findElement(loc_valueOfArriveStation);
    }

    private WebElement getValueOfDepartStationElement(){
        return Constant.driver.findElement(loc_valueOfDepartStation);
    }

    public WebElement getContentBookTicket() {
        return Constant.driver.findElement(loc_bookTicketLbl);
    }

    private WebElement getSelectedOfArriveAtElement(){
        return Constant.driver.findElement(loc_valueSelectedOfArriveAtDropbox);
    }

    public WebElement getSelectedOfDepartFromElement(){
        return Constant.driver.findElement(loc_valueSelectedOfDepartFromDropbox);
    }

    //Methods
    public void bookTicket(String date, String departFrom, String arriverAt, String seatType, String ticketAmount){
        Utilities.pageDownEnd();
        this.getSelectDate().selectByVisibleText(date);
        this.getSelectDepartFrom().selectByVisibleText(departFrom);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.getSelectArriverAt().selectByVisibleText(arriverAt);
        this.getSelectSeatType().selectByVisibleText(seatType);
        this.getSelectTicketAmount().selectByVisibleText(ticketAmount);
        this.getBtnBookTicket().click();
    }

    public String navigateSuccessfulScreen(){
        return this.getSuccessfulTitle().getText();
    }

    public String verifyErrorMessageAtArriveStation(){
        return this.getErrorMessageAtArriveStation().getText();
    }

    public String verifyErrorMessageAtTicketAmount(){
        return this.getErrorMessageAtTicketAmount().getText();
    }

    public String getValueTicketOfAmountColumn(){
        return getValueOfAmountElement().getText();
    }

    public String getValueTicketOfDepartDateColumn(){
        return getValueOfDepartDateElement().getText();
    }

    public String getValueTicketOfSeatTypeColumn(){
        return getValueOfSeatTypeElement().getText();
    }

    public String getValueTicketOfArriveAtColumn(){
        return getValueOfArriveStationElement().getText();
    }

    public String getValueTicketOfDepartFromColumn(){
        return getValueOfDepartStationElement().getText();
    }

    public String getContentBookTicketPage(){
        return getContentBookTicket().getText();
    }

    public String valueSelectedOfArriveAt(){
        return getSelectedOfArriveAtElement().getText();
    }

    public String valueSelectedOfDepartStation(){
        return getSelectedOfDepartFromElement().getText();
    }
}
