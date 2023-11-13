package com.unmsm.software.selenium.grupo4.testzp.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navbar {
    protected WebDriver driver;
    private final By miCuentaButton = By.id("miCuentaButton");
    private final By cerrarSesionButtonCliente = By.id("cerrarSesionButtonCliente");
    private final By cerrarSesionButtonAdmin = By.id("cerrarSesionButtonAdmin");

    public Navbar(WebDriver driver) {
        this.driver = driver;
    }

    public void cerrarSesionCliente() {
        driver.findElement(this.miCuentaButton).click();
        driver.findElement(this.cerrarSesionButtonCliente).click();
    }

    public void cerrarSesionAdmin() {
        driver.findElement(this.cerrarSesionButtonAdmin).click();
    }
}