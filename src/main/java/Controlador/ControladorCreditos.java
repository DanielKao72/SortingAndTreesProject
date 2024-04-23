package Controlador;

import Vista.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControladorCreditos implements ActionListener{
    Inicio inicio;
    Creditos creditos;
    
    public ControladorCreditos(Inicio inicio, Creditos creditos){
        this.inicio = inicio;
        this.creditos = creditos;
        this.creditos.regresarBtn.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == creditos.regresarBtn){
            regresarInicio();
        }
    }
    
    public void regresarInicio(){
        this.creditos.setVisible(false);
        this.inicio.setVisible(true);
    }
}
