package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class CheckOut extends BaseClass {

    public CheckOut(WebDriver driver) {
        super(driver);
    }

    //Centralizamos localizadores

    By locatorBtnCheck = By.id("shipping_shipping_methoddefault_free_shipping.default_free_shipping");
    By locatorBtnContinuar = By.xpath("//span[contains(text(),'Continuar')]");
    By locatorBtnPayment = By.id("payment_payment_methoddefault_cod");
    By locatorBtnPaymentAgree = By.id("payment_agree");
    By locatorBtnConfirmar = By.xpath("//span[contains(text(),'Confirmar Pedido')]");


    By locatorLblSuccess = By.xpath("//h1[contains(text(),'Su pedido ha sido procesado!')]");

    //Acciones
    public void checkBoton(){
        click(esperaExplicita(locatorBtnCheck));
    }

    public void clickContinuar(){
        click(esperaExplicita(locatorBtnContinuar));
    }

    public void clickPayment(){
        click(esperaExplicita(locatorBtnPayment));
    }

    public void clickDevolucion(){
        click(esperaExplicita(locatorBtnPaymentAgree));
    }

    public void clickConfirmar(){
        click(esperaExplicita(locatorBtnConfirmar));
    }

    public String successArticulo(){
        esperarXSegundos(2000);
        return obtenerTexto(esperaExplicita(locatorLblSuccess));
    }


}
