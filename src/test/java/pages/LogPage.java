package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.net.Urls;
import org.testng.Assert;
import utils.BaseClass;

import java.net.URL;

public class LogPage extends BaseClass {
    public LogPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar Localizadores
    By locatorLblCerrar = By.xpath("//a[contains(text(),'Cerrar sesión')]");

    By locatorLblMod = By.xpath("//a[contains(text(),'Modifique las direcciones de entrega')]");
    By locatorLblArticulo = By.xpath("//a[contains(text(),'Bases Metálicas')]");

    //Acciones
    public String obtenerLogeo(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(locatorLblCerrar));
    }

    public void modificacionDireccion(){
        click(esperaExplicita(locatorLblMod));

    }

    public void articulos(){
        click(esperaExplicita(locatorLblArticulo));

    }


}
