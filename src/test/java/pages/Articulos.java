package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class Articulos extends BaseClass {

    public Articulos(WebDriver driver) {
        super(driver);
    }

    //Centralizamos localizadores

    By locatorBtnBaseMetal = By.xpath("//a[contains(text(),'Base Metal 5x5 [MB55]')]");

    By locatorBtnAnadir = By.xpath("//span[contains(text(),'Añadir al carro')]");

    By locatorBtnCantidad = By.xpath("//span[contains(text(),'1 Artículos')]");

    By locatorCarritoVacio = By.xpath("//span[contains(text(),'0 Artículos')]");
    By locatorclickArt = By.name("remove[256]");

    By locatorCarritoAct = By.xpath("//span[contains(text(),'Actualizar')]");
    By locatorRealizarPedido = By.xpath("//span[contains(text(),'Realizar Pedido')]");

    //Acciones
    public void anadirArticulo(){
        click(esperaExplicita(locatorBtnAnadir));

    }

    public void clickArticulo(){

        click(esperaExplicita(locatorBtnBaseMetal));

    }

    public String cantidadArticulo(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(locatorBtnCantidad));
    }

    public String quitarArticulo(){
        esperarXSegundos(2000);
        if(estaDesplegado(locatorCarritoVacio))
        {
            return obtenerTexto(esperaExplicita(locatorCarritoVacio));
        }
        else
        {
            estaDesplegado(locatorCarritoVacio);
            click(esperaExplicita(locatorclickArt));
            click(esperaExplicita(locatorCarritoAct));
        }
        return obtenerTexto(esperaExplicita(locatorCarritoVacio));
    }

    public void clickRealizarPedido(){

        click(esperaExplicita(locatorRealizarPedido));

    }

}
