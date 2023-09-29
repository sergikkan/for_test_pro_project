package uiTests.tests;

import org.openqa.selenium.WebDriver;

abstract public class BaseTestPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }
}
