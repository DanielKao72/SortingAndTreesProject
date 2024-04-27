package Controlador;

import Vista.*;
import ordenamientos.MezclaHomogenea;
import ordenamientos.Ordenamientos;
import main.Utilidades;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ControladorInicio implements ActionListener{
    private Inicio inicio;
    private ControladorCreditos controladorCreditos;
    private Creditos creditos;
    private ControladorResultados controladorResultados;
    private TablaResultados resultados;
    private String cadena;
    
    public ControladorInicio(Inicio inicio){
        this.inicio = inicio;
        this.inicio.buscarBtn.addActionListener(this);
        this.inicio.creditosBtn.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == inicio.buscarBtn){
            String textoArchivo = "";
            obtenerPalabra();
            //textoArchivo = obtenerTextoArchivo();
            textoArchivo = "hola espero estas bien";
            realizarOrdenamientos(textoArchivo);
            mostrarResultados();
            limpiarCampos();
        }
        else{
            mostrarCreditos();
        }
    }
    
    public void obtenerPalabra(){
        this.cadena = inicio.palabraTextField.getText();
    }
    
    public void limpiarCampos(){
        inicio.palabraTextField.setText("");
    }
    
    public String obtenerTextoArchivo() {
        String ruta = "prueba.txt";
        StringBuilder textoArchivo = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(ruta))) {
            while (scanner.hasNextLine()) {
                textoArchivo.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo No Encontrado: " + e.getMessage());
        }
        
        return textoArchivo.toString();
    }
    
    public void realizarOrdenamientos(String texto){
        Ordenamientos ordenamientos = new Ordenamientos();
        MezclaHomogenea mezclaHomogenea = new MezclaHomogenea();
        Utilidades utilidades = new Utilidades();
        ArrayList<String> cadenaLimpia = utilidades.tokenizador(texto);
        ArrayList<String> auxCadenaLimpia = new ArrayList<>(cadenaLimpia);
        
       // ArrayList<String> testA = (utilidades.medirTiempoejecucionOrdenamiento(cadenaLimpia, "Bubble Sort", ordenamientos::burbujaMayor));
        //System.out.println(utilidades.elElementoSeEncuentra(testA, this.cadena));

        //ArrayList<String> testB = (utilidades.medirTiempoejecucionOrdenamiento(cadenaLimpia, "Insertion", ordenamientos::insercion));
        //System.out.println(utilidades.elElementoSeEncuentra(testB, this.cadena));

        //ArrayList<String> testC = (utilidades.medirTiempoejecucionOrdenamiento(cadenaLimpia, "Shell Sort", ordenamientos::shellsort));
        //System.out.println(utilidades.elElementoSeEncuentra(testC, this.cadena));

        // System.out.println(cadenaLimpia);
        // System.out.println(auxCadenaLimpia);
        
        // ArrayList<String> testD = (utilidades.medirTiempoejecucionOrdenamientoConRetorno(auxCadenaLimpia, "Merge Sort", ordenamientos::ordenaMerge));
        // System.out.println(utilidades.elElementoSeEncuentra(testD, this.cadena));

        // System.out.println(cadenaLimpia);
        // System.out.println(auxCadenaLimpia);

        // auxCadenaLimpia = cadenaLimpia;

        // System.out.println(cadenaLimpia);
        // System.out.println(auxCadenaLimpia);

        // ArrayList<String> testE = (utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, "Quick Sort", ordenamientos::QuickSort));
        // System.out.println(utilidades.elElementoSeEncuentra(testE, this.cadena));

        // System.out.println(cadenaLimpia);
        // System.out.println(auxCadenaLimpia);

        // auxCadenaLimpia = cadenaLimpia;

        System.out.println(cadenaLimpia);
        System.out.println(auxCadenaLimpia);

        ArrayList<String> testF = (utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, "Mezcla Homogénea", mezclaHomogenea::IniciarMezclaHomogenea));
        System.out.println(utilidades.elElementoSeEncuentra(testF, this.cadena)); 
        auxCadenaLimpia = cadenaLimpia; 
    }

    public void mostrarResultados(){
        this.resultados = new TablaResultados();
        this.controladorResultados = new ControladorResultados(inicio, resultados);
        inicio.setVisible(false);
        resultados.setVisible(true);
    }
    
    public void mostrarCreditos(){
        this.creditos = new Creditos();
        this.controladorCreditos = new ControladorCreditos(inicio, creditos);
        inicio.setVisible(false);
        creditos.setVisible(true);
    }
}
