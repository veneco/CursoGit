package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class CreacionCuenta extends BaseClass {
    public CreacionCuenta(WebDriver driver) {
        super(driver);
    }

    //Centralizar Localizadores
    By locatorLblNuevaDireccion = By.xpath("//span[contains(text(),'Nueva Dirección')]");
    By locatorLblFirstName = By.xpath("//input[@id='AccountFrm_firstname']");
    By locatorLblFirstLastname = By.xpath("//input[@id='AccountFrm_lastname']");
    By locatorLblEmail = By.xpath("//input[@id='AccountFrm_email']");
    By locatorLblTelefono = By.xpath("//input[@id='AccountFrm_telephone']");
    By locatorLblDireccion = By.xpath("//input[@id='AccountFrm_address_1']");
    By locatorLblCiudad = By.xpath("//input[@id='AccountFrm_city']");

    By locatorLblRegion = By.xpath("//select[@id='AccountFrm_zone_id']");
    By locatorLblRegion2  = By.xpath("//option[@value='674']");

    By locatorLblClave  = By.xpath("//input[@id='AccountFrm_password']");
    By locatorLblClave2  = By.xpath("//input[@id='AccountFrm_confirm']");
    By locatorLblContinuar = By.xpath("//span[contains(text(),'Continuar')]");

    By locatorLblSuccess = By.xpath("//h1[contains(text(),'Se ha creado su Cuenta')]");

    By locatorLblFailed = By.xpath("//div[contains(text(),'Error: El correo electrónico ya está registrado por otro usuario')]");


    //Acciones

    public void agregarDireccion(){
        click(esperaExplicita(locatorLblNuevaDireccion));

    }

    public void creacionCuenta(String nombre, String apellido, String email, String telefono, String direccion, String cuidad, String pass, String pass2){
        click(esperaExplicita(locatorLblFirstName));
        agregarTexto(locatorLblFirstName,nombre);
        click(esperaExplicita(locatorLblFirstLastname));
        agregarTexto(locatorLblFirstLastname,apellido);
        click(esperaExplicita(locatorLblEmail));
        agregarTexto(locatorLblEmail,email);
        click(esperaExplicita(locatorLblTelefono));
        agregarTexto(locatorLblTelefono,telefono);
        click(esperaExplicita(locatorLblDireccion));
        agregarTexto(locatorLblDireccion,direccion);
        click(esperaExplicita(locatorLblCiudad));
        agregarTexto(locatorLblCiudad,cuidad);
        click(esperaExplicita(locatorLblRegion));
        click(esperaExplicita(locatorLblRegion2));
        click(esperaExplicita(locatorLblClave));
        agregarTexto(locatorLblClave,pass);
        click(esperaExplicita(locatorLblClave2));
        agregarTexto(locatorLblClave2,pass2);

        click(esperaExplicita(locatorLblContinuar));

    }

    public String successCuenta(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(locatorLblSuccess));
    }

    public String failedCuenta(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(locatorLblFailed));
    }

}
