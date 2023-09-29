package uiTests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiTests.tests.BaseTestPage;

public class MainPage extends BaseTestPage {
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="a[href=\"/signup\"]")
    private WebElement registerButton;

    @FindBy(css ="a[href=\"/login?from=%2F\"]")
    private WebElement loginButton;

    @Step("Нажать на кнопку войти")
    public MainPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    @Step("Нажать на кнопку зарегистрироваться")
    public MainPage clickRegisterButton(){
        registerButton.click();
        return this;
    }
}
