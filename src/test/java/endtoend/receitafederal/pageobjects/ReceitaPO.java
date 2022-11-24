package endtoend.receitafederal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Utils.*;

public class ReceitaPO {
    WebDriver driver;

    public ReceitaPO(WebDriver driver) {
        this.driver = driver;
    }

    public void validatePageHome() {
        WebElement element = getElement(driver, By.cssSelector("#site-header > div.header-wrapper.secondary > div.portal-name > a.portal-logo"));
        String flag = element.getText();
        Assert.assertEquals(flag, "Portal Gov.br", "Text not found!");
    }

    public void closePopUp() {
        elementClick(driver, By.cssSelector("html"));
    }

    public void clickMyCpf() {
        elementClick(driver, By.cssSelector("#cb4388c9-45db-4624-8c69-340056e48199 > div > a > img"));
    }

    public void downPage(String pixels) {
        scrollpage(driver, pixels);
    }


    public void clickInsertCpf() {
        elementClick(driver, By.cssSelector("#d481e548-8b06-4b88-81fd-128eba82ba31 > div > div.itens > a:nth-child(3)"));
    }

    public void clickStart() {
        elementClick(driver, By.cssSelector("#content-core > div.visao-servico > div.header > a"));
    }

    public void insertCpf(String cpf) {
        elementSendKeys(driver, By.id("txtCPF"), cpf);
    }

    public void insertBirth(String birth) {
        elementSendKeys(driver, By.id("txtDataNascimento"), birth);
    }

    public void clickCaptch() {
        WebElement iframe = getElement(driver, By.cssSelector("body > div:nth-child(4) > div:nth-child(1) > iframe"));
        driver.switchTo().frame(iframe);
        elementClick(driver, By.cssSelector("#anchor-state"));
        driver.switchTo().defaultContent();
    }

    public void clickConsult() {
        elementClick(driver, By.id("id_submit"));
    }
}
