package endtoend.bugbunk.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePO {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButton(){
        WebElement element = driver.findElement(By.cssSelector("#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__login > form > div.login__buttons > button.style__ContainerButton-sc-1wsixal-0.ihdmxA.button__child"));
        element.click();
    }
    public void sendEmail(){
        WebElement element = driver.findElement(By.cssSelector("#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(2) > input"));
        element.sendKeys("Amiltontest");
    }

    public void sendNome(){
        WebElement element = driver.findElement(By.cssSelector("#__next > div > div.pages__FormBackground-sc-1ee1f2s-2.jNpkvU > div > div.card__register > form > div:nth-child(3) > input"));
        element.sendKeys("Amilton");
    }
}
