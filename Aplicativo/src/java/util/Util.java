/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author andre
 */
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

}
