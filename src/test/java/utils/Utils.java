package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    //Metodo statico que tem a função de scroll do mouse
    public static void scrollpage(WebDriver driver, String pixels) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0," + pixels + ")");
    }

    //Metodo statico com dois parametros de objetos, que capituram um elemento após 10 seg
    public static WebElement getElement(WebDriver driver, By by) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    //Metodo statico que  clica em um elemento ou campo
    public static void elementClick(WebDriver driver, By by) {
        WebElement element = getElement(driver, by);
        element.click();
    }
    //Metodo para limpar dados inseridos
    public static void elementClear(WebDriver driver, By by) {
        WebElement element = getElement(driver, by);
        element.clear();
    }

    //Metodo que insere dados em um campo
    public static void elementSendKeys(WebDriver driver, By by, String text) {
        WebElement element = getElement(driver, by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public static void elementSendKeys(WebDriver driver, By by, String text, Keys key) {
        WebElement element = getElement(driver, by);
        element.click();
        element.clear();
        element.sendKeys(text, key);
    }

}
