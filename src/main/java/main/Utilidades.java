package main;

import java.util.ArrayList;
import java.util.function.Consumer;
import static main.BusquedaBinaria.busquedaBinaria;

public class Utilidades {

    public ArrayList<String> tokenizador(String cadena) {
        ArrayList<String> ArregloPalabras = new ArrayList<>();
        String[] palabrasArray = cadena.split(" ");
        for (String palabra : palabrasArray) {
            String palabraLimpia = palabra.replace("~", "").replace("\'", "").
                    replace("]", "").replace("[", "").replace("+", "").replace(")", "").
                    replace("(", "").replace("=", "").replace("&", "").replace("%", "").
                    replace("$", "").replace("#", "").replace("\"", "").replace("?", "").
                    replace("¿", "").replace("¡", "").replace("!", "").replace(".", "").
                    replace(",", "").replace(":", "").replace(";", "").replace("-", "").
                    replace(":", "").replace("_", "").toLowerCase().trim();
            if (!palabraLimpia.isEmpty()) {

                ArregloPalabras.add(palabraLimpia);
            }
        }
        return ArregloPalabras;
    }

    public ArrayList<String> medirTiempoejecucionOrdenamiento(ArrayList<String> data, String methodName, Consumer<ArrayList<String>> operation) {
        long start = System.currentTimeMillis();
        operation.accept(data);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("El tiempo total para " + methodName + " es de " + timeElapsed);

        return data;
    }

    public Boolean elElementoSeEncuentra(ArrayList<String> arregloOrdenado, String elementoBuscado) {
        Boolean res;
        int indice = busquedaBinaria(arregloOrdenado, elementoBuscado);
        res = indice != -1;
        return res;
    }

}
