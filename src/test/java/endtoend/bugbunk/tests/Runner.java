package endtoend.bugbunk.tests;

import endtoend.bugbunk.pageobjects.HomePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Runner {
    WebDriver driver;

    //Metodo para iniciar o driver
    @BeforeMethod
    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bugbank.netlify.app/");
    }

    //Metodo para fechar o navegador a cada execução de tests
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test01() throws InterruptedException {
        HomePO homePO = new HomePO(driver);
        homePO.clickButton();
        Thread.sleep(3000);
        homePO.sendEmail();
        Thread.sleep(3000);
        homePO.sendNome();
    }
}



