package PageObjects;

import Common.*;
import DataObjects.BookTicket;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    HomePage homePage = new HomePage();
    private final String [] departStation ={"Phan Thiết", "Nha Trang", "Đà Nẵng", "Huế", "Quảng Ngãi","Sài Gòn", };

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

    public void bookTicket(BookTicket bookTicket, String departForm){
        Utilities.scrollPageDownEnd();
        this.getSelectDate().selectByVisibleText(bookTicket.getDepartDate());
        this.getSelectDepartFrom().selectByVisibleText(departForm);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(departForm.equals(bookTicket.getArriveAt())){
            this.getSelectArriverAt().selectByVisibleText("Huế");
        }
        this.getSelectSeatType().selectByVisibleText(bookTicket.getSeatType());
        this.getSelectTicketAmount().selectByVisibleText(String.valueOf(bookTicket.getTicketAmount()));
        this.getBtnBookTicket().click();
    }

    public void bookTicketSeveralTime(BookTicket bookTicket, int times) {
        for( int i=0; i<times; i++) {
            this.bookTicket(bookTicket, departStation[i]);
            homePage.gotoMenuTab(Constant.TAB_BOOK_TICKET);
        }
    }
}