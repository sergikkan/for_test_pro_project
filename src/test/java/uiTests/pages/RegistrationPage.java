package uiTests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiTests.tests.BaseTestPage;

public class RegistrationPage extends BaseTestPage {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="username")
    private WebElement usernameField;

    @FindBy(id ="fullname")
    private WebElement fullNameField;

    @FindBy(id ="email")
    private WebElement emailField;

    @FindBy(id ="password1")
    private WebElement passwordField;

    @FindBy(css ="input[value=\"Create account\"]")
    private WebElement createButton;

    @FindBy(css= "label[for=\"username\"]")
    private WebElement userNameAlert;

    @FindBy(css= "label[for=\"fullname\"]")
    private WebElement fullnameAlert;

    @FindBy(css= "label[for=\"email\"]")
    private WebElement emailAlert;

    @FindBy(css= "label[for=\"password1\"]")
    private WebElement passwordAlert;

    @Step("Ввести username")
    public RegistrationPage setUsername(String username){
        usernameField.sendKeys(username);
        return this;
    }

    @Step("Ввести имя пользователя")
    public RegistrationPage setFullName(String name){
        fullNameField.sendKeys(name);
        return this;
    }

    @Step("Ввести email")
    public RegistrationPage setEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    @Step("Ввести пароль")
    public RegistrationPage setPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку Create account")
    public RegistrationPage clickCreateAccount(){
        createButton.click();
        return this;
    }

    @Step("Взять текст ошибки поля Username")
    public String getUserNameAlert(){
        return userNameAlert.getText();
    }

    @Step("Взять текст ошибки поля Full name")
    public String getFullnameAlert(){
        return fullnameAlert.getText();
    }

    @Step("Взять текст ошибки поля Email")
    public String getEmailAlert(){
        return emailAlert.getText();
    }

    @Step("Взять текст ошибки поля Password")
    public String getPasswordAlert(){
        return passwordAlert.getText();
    }



}
