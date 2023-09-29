package uiTests.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uiTests.pages.*;
import com.github.javafaker.Faker;

public class AuthorizationTests extends BaseTest{

    Faker faker = new Faker();

    String existLogin = "TestUser006";
    String existPassword = "TestUser006";
    String existName = "TestUser006";
    String wrongLogin = "0937dd";
    String wrongPassword="00003030";
    String login = faker.name().firstName()+""+faker.number().digit();
    String name =faker.name().name();
    String email = "test@gmail.com";
    String password =""+faker.country().capital()+""+faker.phoneNumber().cellPhone()+"!";

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя")
    public void toRegisterNewUser() {
        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();
        CreateAccountPage accountPage = new CreateAccountPage();
        mainPage.clickRegisterButton();
        registrationPage.setUsername(login)
                .setFullName(name)
                .setEmail(email)
                .setPassword(password)
                .clickCreateAccount();
        Assertions.assertTrue(accountPage.getTitle().contains("Вы успешно зарегистрировались!."));
        Assertions.assertTrue(accountPage.getName().contains(name));
    }

    @Test
    @DisplayName("Проверка вывода ошибки при вводе логина существующего пользователя")
    @Description("Выводим ошибку если ввели в поле Username существующее значение")
    public void showMistakeIfUserNameExist() {
        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();
        mainPage.clickRegisterButton();
        registrationPage.setUsername(existLogin)
                .setFullName(name)
                .setEmail(email)
                .setPassword(password)
                .clickCreateAccount();
        Assertions.assertTrue(registrationPage.getUserNameAlert().contains("Username - Имя пользователя уже используется"));
    }

    @Test
    @DisplayName("Проверка вывода ошибок если отправляем пустые поля при регистрации")
    @Description("Проверка вывода ошибок если не заполнили все поля и нажали на кнопку Create account")
    public void showMistakesIfSendEmptyFieldsInRegistration() {
        MainPage mainPage = new MainPage();
        RegistrationPage registrationPage = new RegistrationPage();
        mainPage.clickRegisterButton();
        registrationPage.clickCreateAccount();
        Assertions.assertTrue(registrationPage.getUserNameAlert().contains("Username - \"\" is prohibited as a username for security reasons."));
        Assertions.assertTrue(registrationPage.getFullnameAlert().contains("Full name - \"\" is prohibited as a full name for security reasons."));
        Assertions.assertTrue(registrationPage.getEmailAlert().contains("Email - Некорректный e-mail"));
        Assertions.assertTrue(registrationPage.getPasswordAlert().contains("Password - Требуется пароль"));
    }

    @Test
    @DisplayName("Проверка успешной авторизации пользователя")
    @Description("Проверка успешной авторизации пользователя")
    public void successLoginTest(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        AuthorizedMainPage authorizedMainPage = new AuthorizedMainPage();
        mainPage.clickLoginButton();
        loginPage.setLogin(existLogin).setPassword(existPassword).clickSignIn();
        Assertions.assertTrue(authorizedMainPage.getName().contains(existName));
    }

    @Test
    @DisplayName("Проверка отображения ошибки при отправке пустых или некорректных данных при авторизации")
    @Description("Проверка вывода ошибки если отправляем некорректные данные при авторизации")
    public void showMistakeIfSendInvalidFieldsInLoginPage(){
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        mainPage.clickLoginButton();
        loginPage.clickSignIn();
        Assertions.assertTrue(loginPage.getError().contains("Invalid username or password"));
        loginPage.setLogin(wrongLogin)
                .setPassword(wrongPassword)
                .clickSignIn();
        Assertions.assertTrue(loginPage.getError().contains("Invalid username or password"));
        loginPage.setLogin(existLogin)
                .setPassword(wrongPassword)
                .clickSignIn();
        Assertions.assertTrue(loginPage.getError().contains("Invalid username or password"));
    }
}
