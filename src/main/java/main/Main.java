package main;

import Vista.*;
import Controlador.ControladorInicio;

public class Main {
    public static void main(String[] args){
        Inicio inicio = new Inicio();
        @SuppressWarnings("unused")
        ControladorInicio controladorInicio = new ControladorInicio(inicio);
        inicio.setVisible(true);
    }
}
