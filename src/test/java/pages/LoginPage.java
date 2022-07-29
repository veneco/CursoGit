package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Centralizamos localizadores
    By locatorTxtemail = By.id("loginFrm_email");

    By locatorTxtClave = By.id("loginFrm_password");

    By locatorBtnIngresar = By.xpath("//span[contains(text(),'Conectar')]");

    By locatorBtnCreacionCuenta = By.xpath("//span[contains(text(),'Continuar')]");

    //Acciones
    public void login(String user, String pass){
        click(esperaExplicita(locatorTxtemail));
        agregarTexto(locatorTxtemail,user);
        click(esperaExplicita(locatorTxtClave));
        agregarTexto(locatorTxtClave,pass);
        click(esperaExplicita(locatorBtnIngresar));

    }

    public void crearCuenta(){

        click(esperaExplicita(locatorBtnCreacionCuenta));

    }


}
