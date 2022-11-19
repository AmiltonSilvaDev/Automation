package endtoend.loggi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Utils.*;

public class TrackerPO {
    WebDriver driver;

    public TrackerPO(WebDriver driver) {
        this.driver = driver;
    }

    public void validatePageTracker(){
        WebElement element = getElement(driver, By.cssSelector("#root > div > div > div.no-gutter.col-xs-11 > div.gutter-xs-bottom-normal > h1"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag,"Element not found!");
    }

    public void insertTrackCode(String code) {
        elementSendKeys(driver, By.cssSelector("#root > div > div > div.no-gutter.display-flex.flex-direction-xs-column.align-items-xs-center > div.col-xs-12.gutter-xs-bottom-onehalf > div > div > div.no-gutter.col-xs-12._2ZHa1CY6QxOiqQXxhVecU1 > input"), code);
    }

    public void clickTrackReceiver() {
        elementClick(driver, By.cssSelector("#root > div > div > div.no-gutter.display-flex.flex-direction-xs-column.align-items-xs-center > div.no-gutter.col-xs-12.col-md-7.col-lg-6.col-xl-6.col-xxl-6 > button"));
    }

    public void insertCpf(String cpf) {
        elementSendKeys(driver, By.cssSelector("#root > div > div > div > div > div:nth-child(4) > div > div > div > div > div > div > div > div.no-gutter.col-xs-12._2ZHa1CY6QxOiqQXxhVecU1 > input"), cpf);
    }
    public void sendCpf() {
        insertCpf("057.195.813-32");
    }

    public void clickBlueButton() {
        elementClick(driver, By.cssSelector("#root > div > div > div > div > div:nth-child(4) > div > div > div > button > i"));
    }

    public void validateDateAndReceiver() {
        WebElement element = getElement(driver, By.cssSelector("#root > div > div.no-gutter.menu-view > div > div:nth-child(2) > div.eta-message.gutter-xs-top-onehalf.gutter-xs-bottom-onehalf"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag, "Element not found!");
    }

    public void validateTextInvalidCode(){
        WebElement element = getElement(driver, By.cssSelector("#root > div > div > div.no-gutter.display-flex.flex-direction-xs-column.align-items-xs-center > div.col-xs-12.gutter-xs-bottom-onehalf > div > div > div.no-gutter.col-xs-12.n0v0JyoYkOdiQu-pfwgw7 > div > div > div:nth-child(2) > div"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag, "Text not found");
    }

    public void validateTextInvalidCpf(){
        WebElement element = getElement(driver, By.cssSelector("#root > div > div > div > div > div:nth-child(4) > div > div > div > div > div._309fz1WaKdUH0CGotxz5Xv > span"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag, "Text not found");
    }
}






