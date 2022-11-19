package endtoend.loggi.tests;

import endtoend.loggi.pageobjects.LoggiPO;
import endtoend.loggi.pageobjects.TrackerPO;
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
        driver.get("https://www.loggi.com/");
    }

    //Metodo para fechar o navegador a cada execução de tests
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Rastrear encomenda com código válido")
    public void validadeOne(){
        LoggiPO loggiPO = new LoggiPO(driver);
        loggiPO.clickPopUp();
        loggiPO.validatePageHome();
        loggiPO.clickTrackButton();
        TrackerPO trackerPO = new TrackerPO(driver);
        trackerPO.validatePageTracker();
        trackerPO.insertTrackCode("AM040218849LO");
        trackerPO.clickTrackReceiver();
        trackerPO.insertCpf("057.195.813-32");
        trackerPO.clickBlueButton();
        trackerPO.validateDateAndReceiver();
    }
}
