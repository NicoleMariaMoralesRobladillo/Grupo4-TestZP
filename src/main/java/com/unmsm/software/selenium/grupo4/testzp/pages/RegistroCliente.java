package com.unmsm.software.selenium.grupo4.testzp.pages;

import com.unmsm.software.selenium.grupo4.testzp.components.Formulario;
import com.unmsm.software.selenium.grupo4.testzp.utils.ConstantUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistroCliente extends Formulario {
    private final By nombre = By.name("nombreRegistrate");
    private final By apellido = By.name("apellidoRegistrate");
    private final By celular = By.name("celularRegistrate");
    private final By correo = By.name("correoRegistrate");
    private final By dni = By.name("dniRegistrate");
    private final By contrasenia = By.name("contraseniaRegistrate");
    private final By botonEnviar = By.id("enviarButton");

    public RegistroCliente(WebDriver driver) {
        super(driver,
                ConstantUtils.REGISTRATE_TITULO,
                ConstantUtils.REGISTRATE_URL);
        driver.get(this.url);
    }

    public void registrarCliente(String nombre,
                                 String apellido,
                                 String celular,
                                 String correo,
                                 String dni,
                                 String contrasenia) {
        driver.findElement(this.nombre).sendKeys(nombre);
        driver.findElement(this.apellido).sendKeys(apellido);
        driver.findElement(this.celular).sendKeys(celular);
        driver.findElement(this.correo).sendKeys(correo);
        driver.findElement(this.dni).sendKeys(dni);
        driver.findElement(this.contrasenia).sendKeys(contrasenia);
        driver.findElement(this.botonEnviar).submit();
    }
}
