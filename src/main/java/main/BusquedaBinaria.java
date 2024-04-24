package main;

import java.util.ArrayList;

public class BusquedaBinaria {

    public static int busquedaBinaria(ArrayList<String> arreglo, String elemento) {
        int inicio = 0;
        int fin = arreglo.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arreglo.get(medio).equals(elemento)) {
                return medio;
            }
            
            if (arreglo.get(medio).compareTo(elemento) < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

}
