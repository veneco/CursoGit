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

public class Tests7 {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private LogPage logPage;
    private Articulos articulos;
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
        articulos = new Articulos(homePage.getDriver());
        logPage = new LogPage(homePage.getDriver());
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
    public void CP007_Anadir_Carrito(){
        dataCP = DataDriven.getData("CP007_Anadir_Carrito");
        homePage.irAIniciarSesion();
        loginPage.esperarXSegundos(3000);
        loginPage.login(dataCP.get(1),dataCP.get(2));
        logPage.articulos();
        articulos.clickArticulo();
        articulos.anadirArticulo();
        Assert.assertEquals(articulos.cantidadArticulo(), dataCP.get(3));

    }

}
