package es.daw.simpsons.util;

import java.util.Enumeration;


public class Utils {

    /**
     * Convierte un texto a un Integer
     * @param nombreCampo nombre del campo
     * @param valor
     * @return
     * @throws Exception
     */

    public static Integer leerEntero(String nombreCampo, String valor) throws Exception{
        // 1. Comprobamos si valor en null y vacio
        if (valor == null || valor.isEmpty()) {
            return null;
        }

        // 2. Comprobamos que el texto se puedo convertir a un entero
        Integer num;
        try {
            num = Integer.valueOf(valor); // Lanza un NumberFormatException


        }catch (NumberFormatException e) {
            // Crear y propagar un exception cheked generica
            throw new Exception("El campo " + nombreCampo+ " debe ser un numero entero");
        }
        // comprobamos que no admite negativos
        if (num < 0) {
            throw new Exception("El campo " + nombreCampo+ " debe ser un numero entero");
        }

        return num;


    }
}
