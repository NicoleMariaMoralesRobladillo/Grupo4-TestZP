package com.unmsm.software.selenium.grupo4.testzp;

import com.unmsm.software.selenium.grupo4.testzp.components.Navbar;
import com.unmsm.software.selenium.grupo4.testzp.pages.*;
import com.unmsm.software.selenium.grupo4.testzp.utils.ConstantUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AdministradorTest extends BaseTest {
    @BeforeEach
    void setUp() {
        super.setUp();
        InicioSesion inicioSesion = new InicioSesion(driver);
        inicioSesion.iniciarSesion(
                ConstantUtils.ADMIN_CORREO,
                ConstantUtils.ADMIN_CONTRASENIA,
                ConstantUtils.SOLICITUDES_ADMINISTRADOR_URL);
    }

    @AfterEach
    void tearDown() {
        Navbar navbar = new Navbar(driver);
        navbar.cerrarSesionAdmin();
        super.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataPruebaIngresoPerfil.csv",
            numLinesToSkip = 1)
    void ingresoPerfilTest(String correo,
                                  String perfil,
                                  String contrasenia,
                                  String pin,
                                  String tipoMensaje,
                                  String idMensajeElemento,
                                  String mensajeValidacionEsperado) {
        SolicitudesAdministrador solicitudesAdministrador = new SolicitudesAdministrador(driver);
        solicitudesAdministrador.verMasCualquierSolicitud();
        SolicitudAdministrador solicitudAdministrador = new SolicitudAdministrador(driver);
        solicitudAdministrador.aceptarSolicitud(correo, perfil, contrasenia, pin);
        String mensajeValidacion = solicitudAdministrador.getIngresoPerfil().obtenerMensaje(
                tipoMensaje, idMensajeElemento);
        Assertions.assertEquals(mensajeValidacionEsperado,
                mensajeValidacion);
    }
}