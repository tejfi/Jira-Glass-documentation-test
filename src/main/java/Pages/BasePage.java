package Pages;

import Util.WebdriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public abstract class BasePage {
    protected WebDriver driver;
    protected String route;
    protected static final String BASE_URL = "https://jira2.codecool.codecanvas.hu";

    BasePage(String route, WebDriver driver) {
        this.route = WebdriverSingleton.dotEnvLoader().get("BASE_URL") + route;
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }


    public void goToPage() {
        driver.get(this.route);
    }


    public static WebElement findElement(final WebDriver driver, final By locator,

                                          final int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(1000, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(locator);
            }
        });

    }
}


