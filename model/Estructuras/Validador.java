package Model.Estructuras;

import java.util.Scanner;

public class Validador {
    public static Scanner xx = new Scanner(System.in);

    public static String minusculaSinEspacio(String s){
        return s.trim().toLowerCase();
    }

    public static String leerOpcionMinusculaSinEspacios(String mensaje){
        System.out.println(mensaje);
        
        String textoIn = xx.nextLine().trim().toLowerCase();

        if (textoIn.length() == 0) {
            System.out.println("Este campo no puede estar vacio");
            return leerOpcionMinusculaSinEspacios(mensaje);
        }
        return textoIn;
    }

    public static int leerEnteroMayor0(String mensaje) {
        int numero = 0;
        boolean valido = false;
        do {
            try {
                numero = Integer.parseInt(leerOpcionMinusculaSinEspacios(mensaje));

                if (numero <= 0) {
                    System.out.println("No puedes poner el 0 o menores a el");
                } else {
                    valido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("No has ingresado un numero");
            }

        } while (!valido);

        return numero;
    }

    public static long leerLongMayor0(String mensaje) {
        long numero = 0;
        boolean valido = false;
        do {
            try {
                numero = Long.parseLong(leerOpcionMinusculaSinEspacios(mensaje));

                if (numero <= 0) {
                    System.out.println("No puedes poner el 0 o menores a el");
                } else {
                    valido = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("No has ingresado un numero");
            }

        } while (!valido);

        return numero;
    }
    
    public static void cerrar() {
        xx.close();
    }

}
