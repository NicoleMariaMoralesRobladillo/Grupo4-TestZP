package com.unmsm.software.selenium.grupo4.testzp;

import com.unmsm.software.selenium.grupo4.testzp.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class GeneralTest extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/dataPruebaRegistroCliente.csv",
            numLinesToSkip = 1)
    void registroClienteTest(String nombre,
                             String apellido,
                             String celular,
                             String correo,
                             String dni,
                             String contrasenia,
                             String tipoMensaje,
                             String idMensajeElemento,
                             String mensajeValidacionEsperado) {
        RegistroCliente registroCliente = new RegistroCliente(driver);
        registroCliente.registrarCliente(
                nombre, apellido, celular, correo, dni, contrasenia);
        String mensajeValidacion = registroCliente.obtenerMensaje(
                tipoMensaje, idMensajeElemento);
        Assertions.assertEquals(mensajeValidacionEsperado,
                mensajeValidacion);
    }
}