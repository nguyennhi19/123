package PageObjects;

import Common.*;
import DataObjects.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //Locator
    private final By lblSuccessfully = By.xpath("//*[@id='content']/h1");
    private final By cbbDate = By.name("Date");
    private final By cbbDepartFrom = By.name("DepartStation");
    private final By cbbArriverAt = By.name("ArriveStation");
    private final By cbbSeatType = By.name("SeatType");
    private final By cbbTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblErrorMsgAtArriveSt = By.xpath("//label[text()= 'Arrive at:']/following-sibling::label");
    private final By lblErrorMsgAtTicketAmount = By.xpath("//label[text()= 'Ticket amount:']/following-sibling::label");
    private final By valueOfDepartStation = By.xpath("//tr//td[count(//th[text()= 'Depart Station']/preceding-sibling::th)+1]");
    private final By valueOfArriveStation = By.xpath("//tr//td[count(//th[text()= 'Arrive Station']/preceding-sibling::th)+1]");
    private final By valueOfSeatType = By.xpath("//tr//td[count(//th[text()= 'Seat Type']/preceding-sibling::th)+1]");
    private final By valueOfDepartDate = By.xpath("//tr//td[count(//th[text()= 'Depart Date']/preceding-sibling::th)+1]");
    private final By valueOfAmount = By.xpath("//tr//td[count(//th[text()= 'Amount']/preceding-sibling::th)+1]");
    private final By lblBookTicket = By.xpath("//h1[contains(.,'Book ticket')]");

    //Elements
    private Select getSelectDate(){
        return new Select(Constant.DRIVER.findElement(cbbDate));
    }

    private Select getSelectDepartFrom(){
        return new Select(Constant.DRIVER.findElement(cbbDepartFrom));
    }

    private Select getSelectArriverAt(){
        return new Select(Constant.DRIVER.findElement(cbbArriverAt));
    }

    private Select getSelectSeatType(){
        return new Select(Constant.DRIVER.findElement(cbbSeatType));
    }

    private Select getSelectTicketAmount(){
        return new Select(Constant.DRIVER.findElement(cbbTicketAmount));
    }

    private WebElement getBtnBookTicket(){
        return Constant.DRIVER.findElement(btnBookTicket);
    }

    private WebElement getSuccessfulTitle(){
        return Constant.DRIVER.findElement(lblSuccessfully);
    }

    private WebElement getErrorMsgAtArriveStation(){
        return Constant.DRIVER.findElement(lblErrorMsgAtArriveSt);
    }

    private WebElement getErrorMsgAtTicketAmount(){
        return Constant.DRIVER.findElement(lblErrorMsgAtTicketAmount);
    }

    private WebElement getValueOfAmountElement(){
        return Constant.DRIVER.findElement(valueOfAmount);
    }

    private WebElement getValueOfDepartDateElement(){
        return Constant.DRIVER.findElement(valueOfDepartDate);
    }

    private WebElement getValueOfSeatTypeElement(){
        return Constant.DRIVER.findElement(valueOfSeatType);
    }

    private WebElement getValueOfArriveStationElement(){
        return Constant.DRIVER.findElement(valueOfArriveStation);
    }

    private WebElement getValueOfDepartStationElement(){
        return Constant.DRIVER.findElement(valueOfDepartStation);
    }

    public WebElement getContentBookTicket() {
        return Constant.DRIVER.findElement(lblBookTicket);
    }

    //Methods
    public String getSuccessfulText(){
        return this.getSuccessfulTitle().getText();
    }

    public String getErrorMessageAtArriveStation(){
        return this.getErrorMsgAtArriveStation().getText();
    }

    public String getErrorMessageAtTicketAmount(){
        return this.getErrorMsgAtTicketAmount().getText();
    }

    public int getValueTicketOfAmountColumn(){
        return Integer.parseInt(getValueOfAmountElement().getText());
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

    public boolean isAtBookTicketPage() {
        String titleBookTicket = "Book ticket";
        return this.getContentBookTicket().getText().equals(titleBookTicket);
    }

    public String getCbbArriveAt(){
        return this.getSelectArriverAt().getFirstSelectedOption().getText();
    }

    public String getCbbDepartStation(){
        return this.getSelectDepartFrom().getFirstSelectedOption().getText();
    }

    public void bookTicket(BookTicket bookTicket){
        Utilities.scrollPageDownEnd();
        this.getSelectDate().selectByVisibleText(bookTicket.getDepartDate());
        this.getSelectDepartFrom().selectByVisibleText(bookTicket.getDepartFrom());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.getSelectArriverAt().selectByVisibleText(bookTicket.getArriveAt());
        this.getSelectSeatType().selectByVisibleText(bookTicket.getSeatType());
        this.getSelectTicketAmount().selectByVisibleText(String.valueOf(bookTicket.getTicketAmount()));
        this.getBtnBookTicket().click();
    }
}