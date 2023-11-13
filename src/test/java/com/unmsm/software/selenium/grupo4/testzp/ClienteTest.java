package com.unmsm.software.selenium.grupo4.testzp;

import com.unmsm.software.selenium.grupo4.testzp.components.Navbar;
import com.unmsm.software.selenium.grupo4.testzp.pages.*;
import com.unmsm.software.selenium.grupo4.testzp.utils.ConstantUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.ParseException;

class ClienteTest extends BaseTest{
    @BeforeEach
    void setUp() {
        super.setUp();
        InicioSesion inicioSesion = new InicioSesion(driver);
        inicioSesion.iniciarSesion(
                ConstantUtils.CLIENTE_CORREO,
                ConstantUtils.CLIENTE_CONTRASENIA,
                ConstantUtils.MIS_PERFILES_USUARIO_URL);
    }

    @AfterEach
    void tearDown() {
        Navbar navbar = new Navbar(driver);
        navbar.cerrarSesionCliente();
        super.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataPruebaSolicitudPerfil.csv",
            numLinesToSkip = 1)
    void solicitudPerfilTest(String idPlataforma,
                             String fechaInicio,
                             String tiempoDuracion,
                             String codigoPago,
                             String tipoMensaje,
                             String idMensajeElemento,
                             String mensajeValidacionEsperado) throws ParseException {
        SolicitudPerfil solicitudPerfil = new SolicitudPerfil(driver);
        solicitudPerfil.ingresarSolicitudPerfil(idPlataforma,
                fechaInicio, tiempoDuracion, codigoPago);
        String mensajeValidacion = solicitudPerfil.obtenerMensaje(
                tipoMensaje, idMensajeElemento);
        Assertions.assertEquals(mensajeValidacionEsperado,
                mensajeValidacion);
    }
}