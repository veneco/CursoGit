package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Tests2 {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private String urlSitio;
    private LogPage logPage;
    private Direcciones direcciones;
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
        dataCP = new ArrayList<>();
    }

    @BeforeMethod
    public void preTests(){
        urlSitio = PropertiesDriven.getProperty("url");
        homePage = new HomePage(driver);
        homePage.conexionBrowser(browser,path,propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        logPage = new LogPage(homePage.getDriver());
        direcciones = new Direcciones(homePage.getDriver());
        homePage.cargarSitio(urlSitio);
        homePage.maximizarBrowser();
    }

    @AfterMethod
    public void posEjecucion(){
       homePage.cerrarBrowser();
    }

    @Test
    public void CP003_Agregar_Direccion(){
        dataCP = DataDriven.getData("CP003_Agregar_Direccion");
        homePage.irAIniciarSesion();
        loginPage.esperarXSegundos(3000);
        loginPage.login(dataCP.get(1),dataCP.get(2));
        logPage.modificacionDireccion();
        direcciones.agregarDireccion();
        direcciones.nuevaDireccion(dataCP.get(3),dataCP.get(4),dataCP.get(5),dataCP.get(6));
        Assert.assertEquals(direcciones.successDireccion(), dataCP.get(7));

    }

}
