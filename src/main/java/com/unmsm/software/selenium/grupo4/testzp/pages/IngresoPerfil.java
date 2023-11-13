package com.unmsm.software.selenium.grupo4.testzp.pages;

import com.unmsm.software.selenium.grupo4.testzp.components.Formulario;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class IngresoPerfil extends Formulario {
    private final By formulario = By.id("ventanaRegistroPerfil");
    private final By correo = By.id("correoRegistroPerfil");
    private final By perfil = By.id("perfilRegistroPerfil");
    private final By contrasenia = By.id("contraseniaRegistroPerfil");
    private final By pin = By.id("pinRegistroPerfil");
    private final By botonEnviar = By.id("enviarButton");

    protected IngresoPerfil(WebDriver driver, String titulo, String url) {
        super(driver, titulo, url);
    }

    public void ingresarPerfil(String correo,
                               String perfil,
                               String contrasenia,
                               String pin) {
        driver.findElement(this.correo).sendKeys(correo);
        driver.findElement(this.perfil).sendKeys(perfil);
        driver.findElement(this.contrasenia).sendKeys(contrasenia);
        driver.findElement(this.pin).sendKeys(pin);
        driver.findElement(this.botonEnviar).submit();
    }
}
