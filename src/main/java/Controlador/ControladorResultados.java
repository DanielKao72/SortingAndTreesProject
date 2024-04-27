package Controlador;

import Vista.*;
import Modelo.Resultados;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;

public class ControladorResultados implements ActionListener{
    Inicio inicio;
    TablaResultados tablaResultados;
    ArrayList<Resultados> resultadosFinales;

    public ControladorResultados(Inicio inicio, TablaResultados tablaResultados, ArrayList<Resultados> resultadosFinales){
        this.inicio = inicio;
        this.tablaResultados = tablaResultados;
        this.tablaResultados.regresarBtn.addActionListener(this);
        this.resultadosFinales = resultadosFinales;
        llenarTablaResultados();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == tablaResultados.regresarBtn){
            regresarInicio();
        }
    }

    public void llenarTablaResultados(){
        DefaultTableModel modelo = (DefaultTableModel) tablaResultados.resultadosTabla.getModel();
        
        for(int i = 0; i < resultadosFinales.size(); i++){
            Object[] fila = {resultadosFinales.get(i).getNombre(), resultadosFinales.get(i).getTiempo(), resultadosFinales.get(i).isEncontrado()};
            modelo.addRow(fila);
        }
    }

    public void regresarInicio(){
        this.tablaResultados.setVisible(false);
        this.inicio.setVisible(true);
    }
}
