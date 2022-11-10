package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class RegisterPage {
    //Locator
    private final By loc_txtEmail = By.xpath("//input[@id='email']");
    private final By loc_txtPassword = By.xpath("//input[@id=\"password\"]");
    private final By loc_txtConfirmPassword = By.xpath("//input[@id=\"confirmPassword\"]");
    private final By loc_txtPid = By.xpath("//input[@id=\"pid\"]");
    private final By loc_btnRegister = By.xpath("//input[@value=\"Register\"]");
    private final By loc_registerSuccessMsg = By.xpath("//div[@id='content']/p");
    private final By loc_registerFailedMsg = By.xpath("//p[@class='message error']");
    private final By loc_passwordFieldMsg = By.xpath("//li[@class='password']/label[@class='validation-error']");
    private final By loc_PIDMsg = By.xpath("//li[@class='pid-number']/label[@class='validation-error']");

    //Elements

    private WebElement getTextEmail(){
        return Constant.driver.findElement(loc_txtEmail);
    }

    private WebElement getTextPassword(){
        return Constant.driver.findElement(loc_txtPassword);
    }

    private WebElement getTextConfirmPassword(){
        return Constant.driver.findElement(loc_txtConfirmPassword);
    }

    private WebElement getTextPid(){
        return Constant.driver.findElement(loc_txtPid);
    }

    private WebElement getBtnRegister(){
        return Constant.driver.findElement(loc_btnRegister);
    }

    private WebElement getRegisterSuccess(){
        return Constant.driver.findElement(loc_registerSuccessMsg);
    }

    public WebElement getRegisterFailed() {
        return Constant.driver.findElement(loc_registerFailedMsg);
    }

    public WebElement getMsgPassWordField() {
        return Constant.driver.findElement(loc_passwordFieldMsg);
    }

    public WebElement getMsgPIDFieldElement() {
        return Constant.driver.findElement(loc_PIDMsg);
    }

    //Methods
    private void getScrollToElement(){
        WebElement element = Constant.driver.findElement(loc_btnRegister);
        ((JavascriptExecutor) Constant.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Constant.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
    }

    public void register(String email,String password,String confirmPassword, String pid){
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getTextPid().sendKeys(pid);
        this.getScrollToElement();
        this.getBtnRegister().click();
    }

    public String getRegisterSuccessMsg() {
        return getRegisterSuccess().getText();
    }

    public String getRegisterFailedMsg() {
        return getRegisterFailed().getText();
    }

    public String getPIDFieldMsg() {
        return getMsgPIDFieldElement().getText();
    }

    public String getPassWordFieldMsg() {
        return getMsgPassWordField().getText();
    }


}
