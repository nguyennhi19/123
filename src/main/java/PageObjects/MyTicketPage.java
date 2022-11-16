package PageObjects;

import Common.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    BookTicketPage bookTicketPage = new BookTicketPage();
    //Locators
    private final By lblNamePage = By.xpath("//div[@id='content']/h1");
    private final By cbbDepartStation = By.name("FilterDpStation");
    private final By cbbArriveStation = By.name("FilterArStation");
    private final By txtDepartDate = By.name("FilterDpDate");
    private final By cbbStatus = By.name("FilterStatus");
    private final By btnApplyFilter = By.xpath("//input[@value='Apply Filter']");
    private final By lblFilter = By.xpath("//div[@class = 'Filter']//strong");
    private final By position = By.xpath("//table[@class='MyTable']//tbody//tr[last()]//td");
    private final By lblNote = By.xpath("//li[starts-with(text() , 'You currently book')]");
    private final By lblErrorMsg = By.xpath("//div[@class='error message']");
    //Elements


    private WebElement getNamePage(){
        return Constant.DRIVER.findElement(lblNamePage);
    }
    private WebElement getTitleFilterElement() {
        return Constant.DRIVER.findElement(lblFilter);
    }

    private Select getDepartStationElement() {
        return new Select(Constant.DRIVER.findElement(cbbDepartStation));
    }

    private Select getArriveStationElement() {
        return new Select(Constant.DRIVER.findElement(cbbArriveStation));
    }

    private WebElement getDepartDate() {
        return Constant.DRIVER.findElement(txtDepartDate);
    }

    private WebElement getApplyFilterElement() {
        return Constant.DRIVER.findElement(btnApplyFilter);
    }

    public WebElement getPositionElement() {
        return Constant.DRIVER.findElement(position);
    }

    public WebElement getErrorMsg() {
        return Constant.DRIVER.findElement(lblErrorMsg);
    }

    //Methods
    public boolean isAtMyTicketPage() {
        String titleMyTicketPage = "Manage Tickets";
        return getNamePage().getText().equals(titleMyTicketPage);
    }
    private Select getStatus() {
        return new Select(Constant.DRIVER.findElement(cbbStatus));
    }

    public void filter(String departSt, String arriveSt, String departDate, String status){
        if (departSt.equals("")) {
            this.getDepartStationElement().selectByVisibleText("Ignore");
        } else {
            this.getDepartStationElement().selectByVisibleText(departSt);
        }
        if (arriveSt.equals("")) {
            this.getArriveStationElement().selectByVisibleText("Ignore");
        } else {
            this.getArriveStationElement().selectByVisibleText(arriveSt);
        }
        this.getDepartDate().sendKeys(departDate);
        if (status.equals("")) {
            this.getStatus().selectByVisibleText("Ignore");
        } else {
            this.getStatus().selectByVisibleText(status);
        }
        this.getApplyFilterElement().click();
    }

    public int checkRowConditionFilter(String filterName, String value){
        //table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= '%s']/preceding-sibling::th)+1][text()='%s']
        String text = "//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= '%s']/preceding-sibling::th)+1][text()='%s']";
        By rowConditionElement = By.xpath(String.format(text,filterName,value));
        return Constant.DRIVER.findElements(rowConditionElement).size();
    }

    public int checkRowConditionsFilter(String filterName, String value, String value1, String value2, String value3) {
        String text = "//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= '%s']/preceding-sibling::th)+1][text()='%s']";
        String text1 = "/following-sibling::td[text() = '%s']";
        String text2 = "/following-sibling::td[text() = '%s']";
        String text3 = "/following-sibling::td[text() = '%s']";
        if(value1.equals("")){
            text1 = "";
        }
        if(value2.equals("")){
            text2 = "";
        }
        if(value3.equals("")){
            text3 = "";
        }
        By rowConditionElement = By.xpath(String.format(text+text1+text2+text3,filterName,value,value1,value2,value3));
        return Constant.DRIVER.findElements(rowConditionElement).size();
    }

    public int checkRow(){
        By rowElement = By.xpath("//table[@class='MyTable']//tr");
        return Constant.DRIVER.findElements(rowElement).size() - 1;
    }


    public String getPositionText(){
        return this.getPositionElement().getText();
    }

    public String getTicketNeededDelete(String departFrom, String arriveAt, String seatType, String date){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']" +
                "//following-sibling::td[text()='%s']" +
                "//following-sibling::td[text()='%s']" +
                "//following-sibling::td//input[@value='Cancel']";
        return String.format(text, departFrom, arriveAt, seatType, date);
    }

    public void deleteTicket(String departFrom, String arriveAt, String seatType, String date) {
        Utilities.scrollToElement(By.xpath(getTicketNeededDelete(departFrom, arriveAt, seatType, date)));
        Constant.DRIVER.findElement(By.xpath(getTicketNeededDelete(departFrom, arriveAt, seatType, date))).click();
        Utilities.acceptPopup();
    }

    public boolean verifyTicketWasDeleted(String actualMsg, String expectedMsg) {
        boolean flag = false;
        int lineNumberBeforeDelete = Integer.parseInt(actualMsg);
        int lineNumberAfterDelete  = Integer.parseInt(expectedMsg);
        int result = lineNumberAfterDelete - lineNumberBeforeDelete;
        if(result==1)
            flag = true;
        return flag;
    }

    public boolean isTitleFilterForm(){
        return this.getTitleFilterElement().getText().equals(Constant.TITLE_FILTER_FORM);
    }

    public int getAmountTicket(){
        By amountTicket = By.xpath("//table[@class='MyTable']//td[count(//table[@class='MyTable']//th[text()= 'Status']/preceding-sibling::th)+1][text()='New']");
        return Constant.DRIVER.findElements(amountTicket).size();
    }

    public String getNoteText(){
        int currentAmount = getAmountTicket();
        return String.format("You currently book %s ticket%s, you can book %s more.", currentAmount, currentAmount <= 1? "":"s", 10 - currentAmount );
    }

    public String getNoteTextAfterBookTicket(int amountBefore){
        int currentAmount =  amountBefore + bookTicketPage.getValueTicketOfAmountColumn();
        return String.format("You currently book %s ticket%s, you can book %s more.", currentAmount, currentAmount <= 1? "":"s", 10 - currentAmount );

    }

    public String getAmountCancelTicket(String departFrom, String arriveAt, String seatType, String date){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[count(//th[text()= 'Amount']/preceding-sibling::th)-4]";
        By amount = By.xpath(String.format(text,departFrom, arriveAt, seatType,date));
        return Constant.DRIVER.findElement(amount).getText();
    }

    public String  getNoteTextAfterCancelTicket(String departFrom, String arriveAt, String seatType, String date){
        int currentAmount = getAmountTicket() - Integer.parseInt(getAmountCancelTicket(departFrom, arriveAt, seatType,date));
        return String.format("You currently book %s ticket%s, you can book %s more.", currentAmount, currentAmount <= 1? "":"s", 10 - currentAmount );

    }


    public String getNote() {
        return Constant.DRIVER.findElement(lblNote).getText();
    }

    public String getErrorMsgAtFilter(){
        return this.getErrorMsg().getText();
    }

    public boolean checkFilterCorrect(int rowConditionBeforeFilter, int rowConditionAfterFilter) {
        int rowAfterFilter = checkRow();
        return rowConditionBeforeFilter == rowConditionAfterFilter && rowConditionAfterFilter == rowAfterFilter;
    }
}
