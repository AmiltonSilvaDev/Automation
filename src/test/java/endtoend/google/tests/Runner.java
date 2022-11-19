package endtoend.google.tests;

import endtoend.google.pageobjects.GooglePO;
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
        driver.get("https://www.google.com");
    }

    //Metodo para fechar o navegador a cada execução de tests
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(testName = "Efetuar busca digitando Selenium WebDriver usando o botão 'ENTER'.")
    public void validationOne() {
        GooglePO googlePO = new GooglePO(driver);
        googlePO.searchEnter("Selenium Webdriver");
    }

    @Test(testName = "Efetuar busca digitando Selenium WebDriver usando o botão de 'Pesquisa Google'")
    public void validationTwo() {
        GooglePO googlePO = new GooglePO(driver);
        googlePO.searchButtonSearch("Selenium Webdriver");
    }

    @Test(testName = "Efetuar busca digitando Selenium WebDriver usando o botão 'estou com sorte'.")
    public void validationThree() {
        GooglePO googlePO = new GooglePO(driver);
        googlePO.searchButtonLucky("Selenium WebDriver");
    }

    @Test(testName = "Efetuar busca sem inserir dados usando o botão 'Pesquisa Google'.")
    public void validationFor() {
        GooglePO googlePO = new GooglePO(driver);
        googlePO.searchWithoutValue();
    }

    @Test(testName = "Efetuar busca sem inserir dados usando o botão 'estou com sorte'.")
    public void validationFive() {
        GooglePO googlePO = new GooglePO(driver);
        googlePO.searchWithoutValueLucky();
    }

}
