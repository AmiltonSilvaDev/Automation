package endtoend.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Utils.elementClick;
import static utils.Utils.getElement;

public class HomePO {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void validatePageHome() {
        WebElement element = getElement(driver, By.cssSelector("#rsyswpsdk > div > div.src__Container-sc-1jdmjxe-0.fPVxSO > div.top__Container-sc-1hdt2lx-0.eErSdV > div.top__Left-sc-1hdt2lx-1.ctjvJk > a > svg"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag, "O elemento não foi encontrado");
    }

    public void clickButtonProfile() {
        elementClick(driver, By.cssSelector("#rsyswpsdk > div > div.src__Container-sc-1jdmjxe-0.fPVxSO > div.top__Container-sc-1hdt2lx-0.eErSdV > div.top__Right-sc-1hdt2lx-2.bNrAhI > a.user__Link-sc-4x5279-0.exgPRq > svg"));
    }

    public void clickStartButton() {
        elementClick(driver, By.cssSelector("#rsyswpsdk > div > div.src__Container-sc-1jdmjxe-0.fPVxSO > div.top__Container-sc-1hdt2lx-0.eErSdV > div.top__Left-sc-1hdt2lx-1.ctjvJk > div > div > div > div.UserArea__UserAreaWrapper-sc-143u0k8-0.bNNlal > div > div.UserArea__ButtonWrapper-sc-143u0k8-7.cWuBta > a.src__Wrapper-sc-g1p0ql-0.jZyiLY"));
    }


}
