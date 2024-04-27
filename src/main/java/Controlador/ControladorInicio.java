package Controlador;

import Vista.*;
import Modelo.Resultados;
import ordenamientos.MezclaHomogenea;
import ordenamientos.Ordenamientos;
import main.Utilidades;
import arboles.arbolABB.ArbolABB;
import arboles.arbolAVL.ArbolAVL;
import arboles.arbolB.BTree;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

public class ControladorInicio implements ActionListener{
    private Inicio inicio;
    private ControladorCreditos controladorCreditos;
    private Creditos creditos;
    private ControladorResultados controladorResultados;
    private TablaResultados resultados;
    private ArrayList<Resultados> resultadosFinales = new ArrayList<Resultados>();
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
            textoArchivo = obtenerTextoArchivo();
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
        ArbolABB arbolABB = new ArbolABB("");
        ArbolAVL arbolAVL = new ArbolAVL("");
        BTree arbolB = new BTree(3);
        Utilidades utilidades = new Utilidades();
        ArrayList<String> cadenaLimpia = utilidades.tokenizador(texto);
        ArrayList<String> auxCadenaLimpia = new ArrayList<>(cadenaLimpia);

        resultadosFinales.add(new Resultados("Bubble Sort", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, ordenamientos::burbujaMayor) , 
                utilidades.elElementoSeEncuentra(auxCadenaLimpia, cadena)));
        auxCadenaLimpia = new ArrayList<>(cadenaLimpia);

        resultadosFinales.add(new Resultados("Inserción", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, ordenamientos::insercion) , 
                utilidades.elElementoSeEncuentra(auxCadenaLimpia, cadena)));
        auxCadenaLimpia = new ArrayList<>(cadenaLimpia);

        resultadosFinales.add(new Resultados("Shell Sort", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, ordenamientos::shellsort) , 
                utilidades.elElementoSeEncuentra(auxCadenaLimpia, cadena)));
        auxCadenaLimpia = new ArrayList<>(cadenaLimpia);

        resultadosFinales.add(new Resultados("Merge Sort", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, ordenamientos::ordenaMerge) , 
                utilidades.elElementoSeEncuentra(auxCadenaLimpia, cadena)));
        auxCadenaLimpia = new ArrayList<>(cadenaLimpia);

        resultadosFinales.add(new Resultados("Quick Sort", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, ordenamientos::QuickSort) , 
                utilidades.elElementoSeEncuentra(auxCadenaLimpia, cadena)));
        auxCadenaLimpia = new ArrayList<>(cadenaLimpia);

        resultadosFinales.add(new Resultados("Mezcla Homogénea", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia,mezclaHomogenea::IniciarMezclaHomogenea),
                utilidades.elElementoSeEncuentra(auxCadenaLimpia, this.cadena)));

        resultadosFinales.add(new Resultados("Árbol Binario de Búsqueda", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, 
            new Consumer<ArrayList<String>>() {
                @Override
                public void accept(ArrayList<String> dataList) {
                    for (String elemento : dataList) {  
                        arbolABB.insertar(elemento);
                    }
                }
            }), 
            arbolABB.buscar(this.cadena)));

        resultadosFinales.add(new Resultados("Árbol AVL", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia,
            new Consumer<ArrayList<String>>() {
                    @Override
                    public void accept(ArrayList<String> dataList) {
                        for (String elemento : dataList) {  
                            arbolAVL.insertar(elemento);  
                        }
                    }
                }), 
            arbolAVL.buscar(this.cadena)));

        resultadosFinales.add(new Resultados("Árbol B", utilidades.medirTiempoejecucionOrdenamiento(auxCadenaLimpia, 
            new Consumer<ArrayList<String>>() {
                    @Override
                    public void accept(ArrayList<String> dataList) {
                        for (String elemento : dataList) {  
                            arbolB.insertar(elemento);  
                        }
                    }
                }) 
            , arbolB.buscar(this.cadena)));
    }

    public void mostrarResultados(){
        this.resultados = new TablaResultados();
        this.controladorResultados = new ControladorResultados(inicio, resultados, resultadosFinales);
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
