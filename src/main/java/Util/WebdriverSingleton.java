package Util;

import com.github.shyiko.dotenv.DotEnv;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class WebdriverSingleton {
    private static WebDriver driver;
    private static Map<String, String> dotEnv;
    private static String hubUrl;


    public static WebDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            dotEnvLoader();
            hubUrl = "https://" + WebdriverSingleton.dotEnvLoader().get("SEHUB_USERNAME") + ":" + WebdriverSingleton.dotEnvLoader().get("SEHUB_PW") + "@" + WebdriverSingleton.dotEnvLoader().get("SEHUB_URL");
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            capability.setCapability(ChromeOptions.CAPABILITY, options);
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.LINUX);
            capability.setCapability("browserstack.debug", "true");
            System.out.println(hubUrl);
            driver = new RemoteWebDriver(new URL(hubUrl), capability);
        }
        return driver;
    }

    public static void closeWebBrowser() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }


    public static Map<String, String> dotEnvLoader() {
        if (dotEnv == null) {
            dotEnv = DotEnv.load();

        }

        return dotEnv;
    }
}


