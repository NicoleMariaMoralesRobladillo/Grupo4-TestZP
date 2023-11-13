package com.unmsm.software.selenium.grupo4.testzp.components;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String titulo;
    protected String url;
    protected WebPage(WebDriver driver, String titulo, String url) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.titulo = titulo;
        this.url = url;
    }
}