package endtoend.loggi.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Utils.elementClick;
import static utils.Utils.getElement;

public class LoggiPO {
    WebDriver driver;

    public LoggiPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPopUp() {
        elementClick(driver, By.cssSelector("#__next > div > a > div > div.style__CloseButton-sc-aoav66-5.dRPVET > svg"));
    }

    public void validatePageHome(){
        WebElement element = getElement(driver, By.cssSelector("#__next > section.style__Section-sc-mv9llo-0.lbzTtt > div.GridPattern-sc-x2w6i8-0.style__HeroGrid-sc-mv9llo-1.hTLRlO.hBLfvX > div.style__ButtonContainer-sc-mv9llo-4.dEJIfl.appear > a:nth-child(2) > button > span"));
        String flag = element.getText();
        Assert.assertEquals(flag,"Quero rastrear um pacote", "Text not found");
    }
    public void clickTrackButton(){
        elementClick(driver, By.cssSelector("#__next > section.style__Section-sc-mv9llo-0.lbzTtt > div.GridPattern-sc-x2w6i8-0.style__HeroGrid-sc-mv9llo-1.hTLRlO.hBLfvX > div.style__ButtonContainer-sc-mv9llo-4.dEJIfl.appear > a:nth-child(2) > button > span"));
    }

}
