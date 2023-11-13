package com.unmsm.software.selenium.grupo4.testzp.pages;

import com.unmsm.software.selenium.grupo4.testzp.components.WebPage;
import com.unmsm.software.selenium.grupo4.testzp.utils.ConstantUtils;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class SolicitudAdministrador extends WebPage {
    private final IngresoPerfil ingresoPerfil;
    private final By buttonAceptar = By.id("button--aceptar");

    public SolicitudAdministrador(WebDriver driver) {
        super(driver,
                ConstantUtils.VER_MAS_SOLICITUD_ADMINISTRADOR_TITULO,
                ConstantUtils.VER_MAS_SOLICITUD_ADMINISTRADOR_URL);
        this.ingresoPerfil = new IngresoPerfil(driver,
                this.titulo, this.url);
    }

    public void aceptarSolicitud(String correo, String perfil,
                                 String contrasenia, String pin) {
        driver.findElement(this.buttonAceptar).click();
        wait.until(ExpectedConditions.elementToBeClickable(this.ingresoPerfil.getCorreo()));
        this.ingresoPerfil.ingresarPerfil(correo, perfil, contrasenia, pin);
    }
}
