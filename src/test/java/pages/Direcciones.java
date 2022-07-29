package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class Direcciones extends BaseClass {
    public Direcciones(WebDriver driver) {
        super(driver);
    }

    //Centralizar Localizadores
    By locatorLblNuevaDireccion = By.xpath("//span[contains(text(),'Nueva Dirección')]");
    By locatorLblFirstName = By.xpath("//input[@id='AddressFrm_firstname']");
    By locatorLblFirstLastname = By.xpath("//input[@id='AddressFrm_lastname']");
    By locatorLblDirect = By.xpath("//input[@id='AddressFrm_address_1']");
    By locatorLblCuidad = By.xpath("//input[@id='AddressFrm_city']");
    By locatorLblRegion = By.xpath("//select[@id='AddressFrm_zone_id']");
    By locatorLblRegion2  = By.xpath("//option[@value='674']");
    By locatorLblContinuar = By.xpath("//span[contains(text(),'Continuar')]");

    By locatorLblSuccess = By.className("success");


    //Acciones

    public void agregarDireccion(){
        click(esperaExplicita(locatorLblNuevaDireccion));

    }

    public void nuevaDireccion(String nombre, String apellido, String direccion, String cuidad){
        click(esperaExplicita(locatorLblFirstName));
        agregarTexto(locatorLblFirstName,nombre);
        click(esperaExplicita(locatorLblFirstLastname));
        agregarTexto(locatorLblFirstLastname,apellido);
        click(esperaExplicita(locatorLblDirect));
        agregarTexto(locatorLblDirect,direccion);
        click(esperaExplicita(locatorLblCuidad));
        agregarTexto(locatorLblCuidad,cuidad);
        click(esperaExplicita(locatorLblRegion));
        click(esperaExplicita(locatorLblRegion2));
        click(esperaExplicita(locatorLblContinuar));

    }

    public String successDireccion(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(locatorLblSuccess));
    }

}
