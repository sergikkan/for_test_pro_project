package uiTests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiTests.tests.BaseTestPage;

public class CreateAccountPage extends BaseTestPage {

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css ="[id=\"main-panel\"] h1")
    private WebElement titleText;

    @FindBy(css = "[class=\"login page-header__hyperlinks\"] a[class=\"model-link\"]")
    private WebElement nameInHeader;

    public String getTitle(){
        return titleText.getText();
    }

    public String getName(){
        return nameInHeader.getText();
    }
}
