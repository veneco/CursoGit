package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {

    //Localizadores

    By locatorBtnHazteIniciar = By.xpath("//a[contains(text(),'Iniciar Sesión')]");


    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }


    //acciones
    public void irAIniciarSesion(){
        click(esperaExplicita(locatorBtnHazteIniciar));
    }


}
