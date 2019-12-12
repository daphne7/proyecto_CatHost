package daphne.example.cathos_proyecto.conexiones;

public class myData {
    public static String USER_ID = "";
    public static String TOKEN = "";
    public static String IP = "http://10.0.2.2:8000";//"http://192.168.1.102:8000"
    public static String HOST = IP + "/api";
    public static String HOST_USER = HOST + "/usuarios";

    public static String LOGIN_SERVICE = HOST_USER + "/v1.0/api/login";//dirccion dadd por mi
    // public static String HOST_USER_LOGIN = HOST_USER + "/login";
    public static String HOST_PRODUCT = HOST + "/productos/";
    public static String HOST_IMAGES = HOST + "/imagenes/";
}
