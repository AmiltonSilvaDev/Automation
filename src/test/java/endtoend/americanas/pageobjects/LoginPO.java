package endtoend.americanas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utils.Utils.*;

public class LoginPO {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void sendEmail() {
        elementSendKeys(driver, By.xpath("/html/body/div[1]/main/div/div[2]/div/form/div[1]/div/label/div[2]/input"), "amiltonjosefn@gmail.com");
    }

    public void sendPassword() {
        elementSendKeys(driver, By.xpath("/html/body/div[1]/main/div/div[2]/div/form/div[2]/div/label/div[2]/input"), "05011997Jrr@");
    }

    public void clickContinueButton() {
        elementClick(driver, By.cssSelector("#root > main > div > div.sc-cuQNSp.iKpUja > div > form > div.sc-gA-DJDv.dhcaCN > button"));
    }
    public void validateLoginSuccessfully(){
        WebElement element = getElement(driver,By.cssSelector("#rsyswpsdk > div > div.src__Container-sc-1jdmjxe-0.fPVxSO > div.top__Container-sc-1hdt2lx-0.eErSdV > div.top__Left-sc-1hdt2lx-1.ctjvJk > a > svg"));
        boolean flag = element.isDisplayed();
        Assert.assertTrue(flag,"O texto não foi encontrado!");
    }
}
