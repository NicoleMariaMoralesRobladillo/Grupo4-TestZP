package com.unmsm.software.selenium.grupo4.testzp.pages;

import java.util.List;
import com.unmsm.software.selenium.grupo4.testzp.components.WebPage;
import com.unmsm.software.selenium.grupo4.testzp.utils.ConstantUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class
SolicitudesAdministrador extends WebPage {
    private final By verMasButton = By.className("verMasButton");

    public SolicitudesAdministrador(WebDriver driver) {
        super(driver,
                ConstantUtils.SOLICITUDES_ADMINISTRADOR_TITULO,
                ConstantUtils.SOLICITUDES_ADMINISTRADOR_URL);
        driver.get(this.url);
    }

    public void verMasCualquierSolicitud() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.verMasButton));
        List<WebElement> verMasButtons = driver.findElements(this.verMasButton);
        WebElement verMasButtonElegido = verMasButtons.get(0);
        verMasButtonElegido.click();
    }
}