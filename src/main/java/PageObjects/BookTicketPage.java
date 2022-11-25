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

    //Methods

}