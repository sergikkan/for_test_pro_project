package uiTests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiTests.tests.BaseTestPage;

public class LoginPage extends BaseTestPage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="j_username")
    private WebElement setUsernameField;

    @FindBy(css = "[type=\"password\"]")
    private WebElement setPasswordField;

    @FindBy(css = "[name=\"Submit\"]")
    private WebElement signInButton;

    @FindBy(css = "[class=\"alert alert-danger\"]")
    private WebElement errorField;

    @Step("Ввести Username")
    public LoginPage setLogin(String username){
        setUsernameField.sendKeys(username);
        return this;
    }

    @Step("Ввести Пароль")
    public LoginPage setPassword(String password){
        setPasswordField.sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку Sign in")
    public LoginPage clickSignIn(){
        signInButton.click();
        return this;
    }

    @Step("Взять текст ошибки")
    public String getError(){
        return errorField.getText();
    }

}
