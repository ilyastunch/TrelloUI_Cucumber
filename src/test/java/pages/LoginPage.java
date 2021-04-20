package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//*[@id='user']")
    public WebElement userName;

    @FindBy(xpath="//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='login']")
    public WebElement loginWithAtlassian;

    @FindBy(xpath = "//*[@id='login-submit']")
    public WebElement loginSubmit;


    public void login(String userNameStr, String passwordStr) {
       try{ userName.sendKeys(userNameStr);
        loginWithAtlassian.click();
        password.sendKeys(passwordStr);
        loginSubmit.click();
        password.sendKeys(passwordStr);
        loginSubmit.click();}
       catch(Exception e){
           e.printStackTrace();
       }
    }

}
