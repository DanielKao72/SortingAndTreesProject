package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
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

    public long medirTiempoejecucionOrdenamiento(ArrayList<String> data, Consumer<ArrayList<String>> operation) {
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
    
    
    public ArrayList<String> leerElementosDelArchivoFpreviamenteOrdenado(){
        String rutaArchivo = "F.txt";

        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
        
        return lineas; 
    }
    
    public static void sobreEscribirArchivoParaDejarloVacio(String nombreArchivo){
         try {
            FileWriter escritor = new FileWriter(nombreArchivo);
            escritor.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }
    }

}
