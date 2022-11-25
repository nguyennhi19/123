package PageObjects;

import Common.*;
import Common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    //Locator
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblSuccessMsg = By.xpath("//div[@id='content']/p");
    private final By lblFailedMsg = By.xpath("//p[@class='message error']");
    private final By lblPasswordFieldMsg = By.xpath("//li[@class='password']/label[@class='validation-error']");
    private final By lblPIDMsg = By.xpath("//li[@class='pid-number']/label[@class='validation-error']");

    //Elements
    private WebElement getTextEmail(){
        return Constant.DRIVER.findElement(txtEmail);
    }

    private WebElement getTextPassword(){
        return Constant.DRIVER.findElement(txtPassword);
    }

    private WebElement getTextConfirmPassword(){
        return Constant.DRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getTextPid(){
        return Constant.DRIVER.findElement(txtPid);
    }

    private WebElement getBtnRegister(){
        return Constant.DRIVER.findElement(btnRegister);
    }

    //Methods
    public String register(String email, String password, String confirmPassword, String pid) {
        this.getTextEmail().sendKeys(email);
        this.getTextPassword().sendKeys(password);
        this.getTextConfirmPassword().sendKeys(confirmPassword);
        this.getTextPid().sendKeys(pid);
        Utilities.scrollToElement(btnRegister);
        this.getBtnRegister().click();
        return email;
    }

    public String createRandomEmail() {
        return "nhi+" + Utilities.genRandomString() + "@gmail.com";
    }
}
