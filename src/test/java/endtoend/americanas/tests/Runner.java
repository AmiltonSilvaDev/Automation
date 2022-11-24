package endtoend.americanas.tests;

import endtoend.americanas.pageobjects.HomePO;
import endtoend.americanas.pageobjects.LoginPO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    WebDriver driver;

    //Metodo para iniciar o driver a cada execução de testes
    @BeforeMethod
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 320);
        deviceMetrics.put("height", 924);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 8.0.0;" +
                        "Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML, like Gecko) " +
        "Chrome/67.0.3396.99 Mobile Safari/537.36");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation",mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.americanas.com.br/");
    }

    //Metodo para fechar o navegador a cada execução de testes
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "CT03 - Realizar login no site da Americanas (Fluxo principal) SmartPhone")
    public void testOne() throws InterruptedException {
        HomePO homePO = new HomePO(driver);
        homePO.clickButtonProfile();
        homePO.clickStartButton();
        LoginPO loginPO = new LoginPO(driver);
        loginPO.sendEmail();
        loginPO.sendPassword();
        loginPO.clickContinueButton();
        loginPO.validateLoginSuccessfully();
    }

}
