package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Tests4 {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CreacionCuenta creacionCuenta;

    private String urlSitio;
    private ArrayList<String> dataCP;
    private String path;
    private String browser;
    private String propertyDriver;


    //Métodos
    @BeforeTest
    public void preparacionEjecucion(){
        path = Paths.get(System.getProperty("user.dir"), PropertiesDriven.getProperty("rutaDriver")).toString();
        browser = PropertiesDriven.getProperty("browser");
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        homePage = new HomePage(driver);
        homePage.conexionBrowser(browser,path,propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        creacionCuenta = new CreacionCuenta(homePage.getDriver());
        dataCP = new ArrayList<>();
    }

    @BeforeMethod
    public void preTests(){
        urlSitio = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(urlSitio);
        homePage.maximizarBrowser();
    }

    @AfterTest
    public void posEjecucion(){
        homePage.cerrarBrowser();
    }

    @Test
    public void CP004_Creacion_Cuenta(){
        dataCP = DataDriven.getData("CP004_Creacion_Cuenta");
        homePage.irAIniciarSesion();
        loginPage.esperarXSegundos(3000);
        loginPage.crearCuenta();
        creacionCuenta.creacionCuenta(dataCP.get(1),dataCP.get(2),dataCP.get(3),dataCP.get(4),dataCP.get(5),dataCP.get(6),dataCP.get(7),dataCP.get(8));
        Assert.assertEquals(creacionCuenta.successCuenta(), dataCP.get(9));
    }

}
