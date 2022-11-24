package endtoend.receitafederal.tests;

import endtoend.receitafederal.pageobjects.ReceitaPO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Runner {
    WebDriver driver;

    //Metodo para iniciar o driver a cada execução de testes
    @BeforeMethod
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gov.br/receitafederal/pt-br");
    }

    //Metodo para fechar o navegador a cada execução de testes
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "CT01 Consultar CPF")
    public void validationPageHome(){
        ReceitaPO receitaPO = new ReceitaPO(driver);
        receitaPO.closePopUp();
        receitaPO.downPage("400");
        receitaPO.clickMyCpf();
        receitaPO.clickInsertCpf();
        receitaPO.clickStart();
        receitaPO.insertCpf("12616986493");
        receitaPO.insertBirth("05011997");
        receitaPO.clickCaptch();
        receitaPO.clickConsult();
    }
}
