package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BookTicketPage {
    //Locator

    private final By loc_successfullyTitle = By.xpath("//*[@id='content']/h1");
    private final By loc_selectDate = By.xpath("//select[@name='Date']//option");
    private final By loc_selectDepartFrom = By.xpath("//select[@name='DepartStation']//option");
    private final By loc_selectArriverAt = By.xpath("//select[@name='ArriveStation']//option");
    private final By loc_selectSeatType = By.xpath("//select[@name='SeatType']//option");
    private final By loc_selectTicketAmount = By.xpath("//select[@name='TicketAmount']//option");
    private final By loc_btnLBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By loc_errorMessageAtArriveStation = By.xpath("//label[text()= 'Arrive at:']/following-sibling::label");
    private final By loc_errorMessageAtTicketAmount = By.xpath("//label[text()= 'Ticket amount:']/following-sibling::label");



    //Elements

    private WebElement getSelectDate(){
        return Constant.driver.findElement(loc_selectDate);
    }

    private WebElement getSelectDepartFrom(){
        return Constant.driver.findElement(loc_selectDepartFrom);
    }

    private WebElement getSelectArriverAt(){
        return Constant.driver.findElement(loc_selectArriverAt);
    }

    private WebElement getSelectSeatType(){
        return Constant.driver.findElement(loc_selectSeatType);
    }

    private WebElement getSelectTicketAmount(){
        return Constant.driver.findElement(loc_selectTicketAmount);
    }

    private void getScrollToElement(){
        WebElement element = Constant.driver.findElement(loc_btnLBookTicket);
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
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

    //Methods
    public void chooseDate(String date) {

        this.getSelectDate().click();
        Constant.driver.findElement(By.xpath("//select[@name='Date']//option[text()='"+date+"']")).click();
    }
    //select[@name='Date']//option[text()='11/10/2022']

    public void chooseDepartFrom(String departFrom) {
        this.getSelectDepartFrom().click();
        Constant.driver.findElement(By.xpath("//select[@name='DepartStation']//option[text()='"+departFrom+"']")).click();
    }
    //select[@name='Date']//option[text()='Huế']

    public void chooseArriveAt(String arriveAt) {
        this.getSelectArriverAt().click();
        Constant.driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
        Constant.driver.findElement(By.xpath("//select[@name='ArriveStation']//option[text()='"+arriveAt+"']")).click();
    }
    //select[@name='Date']//option[text()='Sài Gòn']

    public void chooseSeatType(String seatType) {
        this.getSelectSeatType().click();
        Constant.driver.findElement(By.xpath("//select[@name='SeatType']//option[text()='"+seatType+"']")).click();
    }
    //select[@name='Date']//option[text()='Hart seat']

    public void chooseTicketAmount(String ticketAmount) {
        this.getSelectTicketAmount().click();
        Constant.driver.findElement(By.xpath("//select[@name='TicketAmount']//option[text()='"+ticketAmount+"']")).click();
    }
    //select[@name='Date']//option[text()='1']

    public void bookTicket(String date, String departFrom, String arriverAt, String seatType, String ticketAmount){
        this.chooseDate(date);
        this.chooseDepartFrom(departFrom);
        this.chooseArriveAt(arriverAt);
        this.chooseSeatType(seatType);
        this.chooseTicketAmount(ticketAmount);
        this.getScrollToElement();
        this.getBtnBookTicket().click();
    }

    public String NavigateSuccessfulScreen(){
        return this.getSuccessfulTitle().getText();
    }

    public String VerifyErrorMessageAtArriveStation(){
        return this.getErrorMessageAtArriveStation().getText();
    }
    public String VerifyErrorMessageAtTicketAmount(){
        return this.getErrorMessageAtTicketAmount().getText();
    }
}
