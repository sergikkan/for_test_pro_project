package uiTests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiTests.tests.BaseTestPage;

public class AuthorizedMainPage extends BaseTestPage {

    public AuthorizedMainPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "[class=\"login page-header__hyperlinks\"] a[class=\"model-link\"]")
    private WebElement nameInHeaderOnMainPage;

    public String getName(){
        return nameInHeaderOnMainPage.getText();
    }
}
