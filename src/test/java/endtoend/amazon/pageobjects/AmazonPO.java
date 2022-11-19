package endtoend.amazon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Utils.*;

public class AmazonPO {
    WebDriver driver;

    public AmazonPO(WebDriver driver) {
        this.driver = driver;
    }

    public void validatePageHome() {
        WebElement element = getElement(driver, By.id("nav-logo-sprites"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag, "O elemento não foi encontrado!");
    }
    public void validatePageLogin() {
        WebElement element = getElement(driver, By.cssSelector("#a-page > div.a-section.a-padding-medium.auth-workflow > div.a-section.a-spacing-none.auth-navbar > div > a > i.a-icon.a-icon-logo"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag, "O elemento não foi encontrado!");
    }

    public void clickButtonLogin() {
        validatePageHome();
        elementClick(driver, By.cssSelector("#nav-link-accountList"));
    }

    public void sendEmail(String text) {
        validatePageLogin();
        elementSendKeys(driver, By.id("ap_email"), text);
        elementClick(driver, By.id("continue"));
    }

    public void sendPassword(String text) {
        validatePageLogin();
        elementSendKeys(driver, By.id("ap_password"), text);
        elementClick(driver, By.id("signInSubmit"));
    }

    public void sendCredencials() {
        validatePageLogin();
        sendEmail("amiltonjosefn2018@gmail.com");
        sendPassword("05011997Jrr@");
    }

    public void validationProfile(){
        boolean flag = getElement(driver,By.id("glow-ingress-line2")).isDisplayed();
        Assert.assertTrue(flag, "Não está no perfil conta");
    }

    public void errorValidationByInsertingInvalidData(){
        boolean flag = getElement(driver, By.cssSelector("#auth-error-message-box > div > h4")).isDisplayed();
        Assert.assertTrue(flag);
    }
    public void errorValidationWithoutEnteringValue(){
        boolean flag = getElement(driver, By.cssSelector("#auth-email-missing-alert > div > div")).isDisplayed();
        Assert.assertTrue(flag);
    }
}
