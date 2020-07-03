
package util;

// Esta clase representa la imformacion principal de sistema de informacion
public class Config {
    // BASE DE DATOS
     private static final String DBDRIVER = "com.mysql.jdbc.Driver";
     private static final String DBUSER = "root";
     private static final String DBPASSWORD = "monserrate1010";
     private static final String DBNAME = "proyecto_turixmo";
     private static final String DBURL = "jdbc:mysql://localhost:3306/" + DBNAME + "?useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
     
     private static final String URL_PROJECT = "http://localhost:8080/turixmo/";

    public static String getDBDRIVER() {
        return DBDRIVER;
    }

    public static String getDBUSER() {
        return DBUSER;
    }

    public static String getDBPASSWORD() {
        return DBPASSWORD;
    }

    public static String getDBNAME() {
        return DBNAME;
    }

    public static String getDBURL() {
        return DBURL;
    }

    public static String getURL_PROJECT() {
        return URL_PROJECT;
    }
     
     
     


}
