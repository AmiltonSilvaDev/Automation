package endtoend.amazon.tests;

import endtoend.amazon.pageobjects.AmazonPO;
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
        driver.get("https://www.amazon.com.br/");
    }

    //Metodo para fechar o navegador a cada execução de tests
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "CT01-  Efetuar login com dados válidos.")
    public void validationOne() throws InterruptedException {
        AmazonPO amazonPO = new AmazonPO(driver);
        amazonPO.clickButtonLogin();
        amazonPO.sendCredencials();
        amazonPO.validationProfile();
    }

    @Test(testName = "CT02-  Efetuar login com E-mail inválido.")
    public void validationTwo() {
        AmazonPO amazonPO = new AmazonPO(driver);
        amazonPO.clickButtonLogin();
        amazonPO.sendEmail("teste@teste.inválido");
        amazonPO.errorValidationByInsertingInvalidData();
    }

    @Test(testName = "CT03-  Efetuar login sem inserir dados.")
    public void validationThree() {
        AmazonPO amazonPO = new AmazonPO(driver);
        amazonPO.clickButtonLogin();
        amazonPO.sendEmail("");
        amazonPO.errorValidationWithoutEnteringValue();
    }
}
