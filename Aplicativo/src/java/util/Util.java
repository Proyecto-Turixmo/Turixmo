
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

  public static String nullToSpace(String dato) {

        if (dato == null) {
            dato = "";
        }
        return dato;
    }

    public static String spaceToNull(String dato) {

        if (dato.equals("")) {
            dato = null;
        }
        return dato;
    }
    
    public static String toString(int dato) {

        return Integer.toString(dato); 
    }
    
    public static int toNumber(String dato) {
            
        return Integer.parseInt(dato);
    }
    
    
    public static String getDateTime() {
        
        Date fecha = new Date();
        DateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return formateador.format(fecha);
    }


}
