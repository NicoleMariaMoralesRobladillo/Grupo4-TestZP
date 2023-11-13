package com.unmsm.software.selenium.grupo4.testzp.utils;

public final class ConstantUtils {
    private ConstantUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static final String CLIENTE_CORREO = "jesus.jimenez@gmail.com";
    public static final String CLIENTE_CONTRASENIA = "789456";
    public static final String ADMIN_CORREO = "moralesrobladillon@gmail.com";
    public static final String ADMIN_CONTRASENIA = "123456";
    public static final String REGISTRATE_TITULO = "Regístrate";
    public static final String INICIAR_SESION_TITULO = "Iniciar sesión";
    public static final String SOLICITUDES_ADMINISTRADOR_TITULO = "Solicitudes";
    public static final String SOLICITAR_PERFIL_USUARIO_TITULO = "Solicitar perfil";
    public static final String VER_MAS_SOLICITUD_ADMINISTRADOR_TITULO = "Ver más de la solicitud";
    public static final String URL = "http://localhost:8081";
    public static final String REGISTRATE_URL = URL + "/registrate";
    public static final String INICIAR_SESION_URL = URL + "/iniciarsesion";
    public static final String MIS_PERFILES_USUARIO_URL = URL + "/misperfilesusuario";
    public static final String SOLICITAR_PERFIL_USUARIO_URL = URL + "/solicitarperfilusuario";
    public static final String SOLICITUDES_ADMINISTRADOR_URL = URL + "/solicitudesadministrador";
    public static final String VER_MAS_SOLICITUD_ADMINISTRADOR_URL = URL + "/vermassolicitudesadministrador";
    public static final String TIPO_ALERT = "Alert";
    public static String NAVEGADOR = "Edge";
}