package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //Locator
    private final By successfullyTitle = By.xpath("//*[@id='content']/h1");
    private final By selectDate = By.name("Date");
    private final By selectDepartFrom = By.name("DepartStation");
    private final By selectArriverAt = By.name("ArriveStation");
    private final By selectSeatType = By.name("SeatType");
    private final By selectTicketAmount = By.name("TicketAmount");
    private final By btnLBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By errorMessageAtArriveStation = By.xpath("//label[text()= 'Arrive at:']/following-sibling::label");
    private final By errorMessageAtTicketAmount = By.xpath("//label[text()= 'Ticket amount:']/following-sibling::label");
    private final By valueOfDepartStation = By.xpath("//tr//td[position()=1]");
    private final By valueOfArriveStation = By.xpath("//tr//td[2]");
    private final By valueOfSeatType = By.xpath("//tr//td[3]");
    private final By valueOfDepartDate = By.xpath("//tr//td[4]");
    private final By valueOfAmount = By.xpath("//tr//td[7]");
    private final By bookTicketLbl = By.xpath("//h1[contains(.,'Book ticket')]");

    //Elements
    private Select getSelectDate(){
        return new Select(Constant.driver.findElement(selectDate));
    }

    private Select getSelectDepartFrom(){
        return new Select(Constant.driver.findElement(selectDepartFrom));
    }

    private Select getSelectArriverAt(){
        return new Select(Constant.driver.findElement(selectArriverAt));
    }

    private Select getSelectSeatType(){
        return new Select(Constant.driver.findElement(selectSeatType));
    }

    private Select getSelectTicketAmount(){
        return new Select(Constant.driver.findElement(selectTicketAmount));
    }

    private WebElement getBtnBookTicket(){
        return Constant.driver.findElement(btnLBookTicket);
    }

    private WebElement getSuccessfulTitle(){
        return Constant.driver.findElement(successfullyTitle);
    }

    private WebElement getErrorMessageAtArriveStation(){
        return Constant.driver.findElement(errorMessageAtArriveStation);
    }

    private WebElement getErrorMessageAtTicketAmount(){
        return Constant.driver.findElement(errorMessageAtTicketAmount);
    }

    private WebElement getValueOfAmountElement(){
        return Constant.driver.findElement(valueOfAmount);
    }

    private WebElement getValueOfDepartDateElement(){
        return Constant.driver.findElement(valueOfDepartDate);
    }

    private WebElement getValueOfSeatTypeElement(){
        return Constant.driver.findElement(valueOfSeatType);
    }

    private WebElement getValueOfArriveStationElement(){
        return Constant.driver.findElement(valueOfArriveStation);
    }

    private WebElement getValueOfDepartStationElement(){
        return Constant.driver.findElement(valueOfDepartStation);
    }

    public WebElement getContentBookTicket() {
        return Constant.driver.findElement(bookTicketLbl);
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
        return this.getSelectArriverAt().getFirstSelectedOption().getText();
    }

    public String valueSelectedOfDepartStation(){
        return this.getSelectDepartFrom().getFirstSelectedOption().getText();
    }
}
