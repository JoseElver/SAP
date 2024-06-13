package com.co.choucair.sap.drivers;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalDriverFactory {

    public static WebDriver reportsDriver;
    public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setTheDriver(WebDriver driver) {
        LocalDriverFactory.WEB_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static WebDriver createWebDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return createChromeDriver();
            case "chrome-headless":
                return createChromeDriverHeadless();
            case "firefox":
                return createFirefoxDriver();
            case "edge":
                return createEdgeDriver();
        }
        return null;
    }

    public static void setDriverForScreenshots(WebDriver driver) {
        setTheDriver(driver);
        Serenity.getWebdriverManager().setCurrentDriver(driver);
    }

    public static WebDriver createLocalDriver(String browser) {
        reportsDriver = createWebDriver(browser);
        setDriverForScreenshots(reportsDriver);
        return SelfHealingDriver.create(reportsDriver);
    }



    private static WebDriver createEdgeDriver() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximixed");
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-dev-shm-usage");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(edgeOptions);
    }

    private static WebDriver createFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximixed");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver createChromeDriverHeadless() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--allow-running-insecure-content --disable-popup-blocking --disable-dev-shm-usage");
        options.addArguments("--disable-infobars --test-type --disable-extensions --disable-translate");
        options.addArguments("--ignore-certificate-errors --no-sandbox --disable-download-notification");
        options.addArguments("use-fake-ui-for-media-stream");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(options);
    }
}
