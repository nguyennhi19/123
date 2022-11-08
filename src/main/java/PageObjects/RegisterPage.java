package PageObjects;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locator
    private final By loc_txtEmail = By.xpath("//input[@id=\"email\"]");
    private final By loc_txtPassword = By.xpath("//input[@id=\"password\"]");
    private final By loc_txtConfirmPassword = By.xpath("//input[@id=\"confirmPassword\"]");
    private final By loc_txtPid = By.xpath("//input[@id=\"pid\"]");
    private final By loc_btnRegister = By.xpath("//input[@value=\"Register\"]");

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

    //Methods
    public void register(String email,String password,String confirmPassword, String pid){
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getTextPid().sendKeys(pid);
        this.getBtnRegister().click();
    }
}
