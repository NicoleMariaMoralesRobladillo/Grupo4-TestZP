package com.unmsm.software.selenium.grupo4.testzp.pages;

import com.unmsm.software.selenium.grupo4.testzp.components.Formulario;
import com.unmsm.software.selenium.grupo4.testzp.utils.ConstantUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolicitudPerfil extends Formulario {
    private final By plataforma = By.name("plataformaSolicitud");
    private final By fechaInicio = By.name("fechaInicioSolicitud");
    private final By tiempoDuracionSolicitud = By.id("tiempoDuracionSolicitud");
    private final By codigoPagoSolicitud = By.name("codigoPagoSolicitud");
    private final By botonEnviar = By.id("enviarButton");

    public SolicitudPerfil(WebDriver driver) {
        super(driver,
                ConstantUtils.SOLICITAR_PERFIL_USUARIO_TITULO,
                ConstantUtils.SOLICITAR_PERFIL_USUARIO_URL);
        driver.get(this.url);
    }

    private void seleccionarPlataforma(String valor) {
        driver.findElement(this.plataforma).click();
        driver.findElement(By.id(valor)).click();
    }

    public void ingresarSolicitudPerfil(String plataforma,
                                        String fechaInicio,
                                        String tiempoDuracionSolicitud,
                                        String codigoPagoSolicitud) throws ParseException {
        if (plataforma != null) {
            seleccionarPlataforma(plataforma);
        }
        if (!fechaInicio.isEmpty() && ConstantUtils.NAVEGADOR.equals("Firefox")) {
            SimpleDateFormat basicFormatter = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = basicFormatter.parse(fechaInicio);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            fechaInicio = formatter.format(fecha);
        }
        driver.findElement(this.fechaInicio).sendKeys(fechaInicio);
        if (!tiempoDuracionSolicitud.isBlank() && Integer.parseInt(tiempoDuracionSolicitud) < 0) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value=arguments[1];",
                    driver.findElement(this.tiempoDuracionSolicitud),
                    tiempoDuracionSolicitud);
            ((JavascriptExecutor) driver).executeScript("var event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);",
                    driver.findElement(this.tiempoDuracionSolicitud));
        }
        else {
            driver.findElement(this.tiempoDuracionSolicitud).sendKeys(tiempoDuracionSolicitud);
        }
        driver.findElement(this.codigoPagoSolicitud).sendKeys(codigoPagoSolicitud);
        driver.findElement(this.botonEnviar).submit();
    }
}
