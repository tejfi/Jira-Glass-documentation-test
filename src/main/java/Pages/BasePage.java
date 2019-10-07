package Pages;

import Util.WebdriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected String route;
    protected static final String BASE_URL = "https://jira.codecool.codecanvas.hu";

    BasePage(String route, WebDriver driver) {
        this.route = BASE_URL + route;
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public void goToPage() {
        driver.get(this.route);
    }
}


