package Controlador;

import Vista.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorResultados implements ActionListener{
    Inicio inicio;
    TablaResultados tablaResultados;

    public ControladorResultados(Inicio inicio, TablaResultados tablaResultados){
        this.inicio = inicio;
        this.tablaResultados = tablaResultados;
        this.tablaResultados.regresarBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == tablaResultados.regresarBtn){
            regresarInicio();
        }
    }

    public void regresarInicio(){
        this.tablaResultados.setVisible(false);
        this.inicio.setVisible(true);
    }
}
