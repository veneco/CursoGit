package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class ClaveInvalidaPage extends BaseClass {
    public ClaveInvalidaPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar Localizadores
    By locatorTituloErrorAuth = By.xpath("//div[contains(text(),'Error: No existe ese correo electrónico o la contraseña no es correcta.')]");



    //Acciones
    public String obtenerTituloErrorAuth(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(locatorTituloErrorAuth));
    }


}
