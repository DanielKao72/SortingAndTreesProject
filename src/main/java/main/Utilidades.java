package main;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.BusquedaBinaria.busquedaBinaria;

public class Utilidades {

public ArrayList<String> tokenizador(String texto) {
        ArrayList<String> arregloPalabras = new ArrayList<>();
        HashSet<String> palabrasUnicas = new HashSet<>();

        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[^a-zA-Z ]", "")
                .toLowerCase();
        Pattern patronPalabras = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = patronPalabras.matcher(textoNormalizado);
        while (matcher.find()) {
            palabrasUnicas.add(matcher.group());
        }
        arregloPalabras.addAll(palabrasUnicas);
        return arregloPalabras;
    }

    public long medirTiempoejecucionOrdenamiento(ArrayList<String> data, String methodName, Consumer<ArrayList<String>> operation) {
        long start = System.currentTimeMillis();
        operation.accept(data);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        return timeElapsed;
    }

    public Boolean elElementoSeEncuentra(ArrayList<String> arregloOrdenado, String elementoBuscado) {
        int indice = busquedaBinaria(arregloOrdenado, elementoBuscado);
        return indice != -1;
    }

}
