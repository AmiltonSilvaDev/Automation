package endtoend.google.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Utils.*;

public class GooglePO {
    WebDriver driver;

    public GooglePO(WebDriver driver) {
        this.driver = driver;
    }

    public void validadePage()  {
        WebElement img = getElement(driver, By.cssSelector("body > div.L3eUgb > div.o3j99.LLD4me.yr19Zb.LS8OJ > div > img"));
        boolean flag = img.isDisplayed();
        Assert.assertTrue(flag, "A imagem não carregou. Falhou!");
    }

    public void btnSearch() {
        elementClick(driver, By.
                cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
    }

    public void btnLucky() {
        elementClick(driver, By.
                cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.RNmpXc"));
    }

    public void sendTextSearch(String text) {
        elementSendKeys(driver,By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"), text);
    }

    public void sendTextSearch(String text, Keys key) {
        elementSendKeys(driver, By.name("q"), text, key);
    }

    public void searchButtonSearch(String text) {
        validadePage();
        sendTextSearch(text);
        btnSearch();
    }

    public void searchButtonLucky(String text) {
        validadePage();
        sendTextSearch(text);
        btnLucky();
    }

    public void searchEnter(String text) {
        validadePage();
        sendTextSearch(text, Keys.ENTER);
    }

    public void searchWithoutValue() {
        validadePage();
        btnSearch();
    }

    public void searchWithoutValueLucky() {
        validadePage();
        btnLucky();
    }


}
