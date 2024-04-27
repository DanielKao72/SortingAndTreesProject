package arboles.arbolB;

import java.util.Collections;

public class BTree{
    private int orden;
    private NodeBTree raiz;
    
    public BTree(int orden){
        this.orden = orden;
        raiz = new NodeBTree(orden);
    }
    
    public boolean buscar(String cadenaClave){
        NodeBTree nodo = buscar(raiz, cadenaClave);
        
        if(nodo == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    public NodeBTree buscar(NodeBTree nodo, String cadenaClave){
        int i = 0;
        
        while(i < nodo.getClaves().size() && cadenaClave.compareTo(nodo.getClaves().get(i)) > 0){
            i++;
        }
        
        if(i < nodo.getClaves().size() && cadenaClave.compareTo(nodo.getClaves().get(i)) == 0){
            return nodo;
        }
        
        if(nodo.esHoja()){
            return null;
        }else{
            return buscar(nodo.getHijos().get(i), cadenaClave);
        }
    }
    
    public void insertar(String cadenaClave){
        insertar(cadenaClave, raiz);
    }
    
    public void insertar(String cadenaClave, NodeBTree nodo){
        if(nodo.esHoja()){
            nodo.getClaves().add(cadenaClave);
            Collections.sort(nodo.getClaves());
            
            if(nodo.getClaves().size() == 2*orden + 1){
                separar(nodo);
            }
        }
        else{
            int i = 0;
            
            while(i < nodo.getClaves().size() && cadenaClave.compareTo(nodo.getClaves().get(i)) > 0){
                i++;
            }
            
            insertar(cadenaClave, nodo.getHijos().get(i));
        }
    }
    
    public void separar(NodeBTree nodo){
        int mitadClave = (int) Math.floor(nodo.getClaves().size() / 2);
        String aux = nodo.getClaves().get(mitadClave);
        
        NodeBTree nodoIzq = new NodeBTree(orden);
        NodeBTree nodoDer = new NodeBTree(orden);
        
        for(int i = 0; i < mitadClave; i++){
            nodoIzq.getClaves().add(nodo.getClaves().get(i));
        }
 
        for(int i = mitadClave+1; i < nodo.getClaves().size(); i++){
            nodoDer.getClaves().add(nodo.getClaves().get(i));
        }
        
        if(nodo.getPadre() == null){
            NodeBTree nuevaRaiz = new NodeBTree(orden);
            nuevaRaiz.getClaves().add(aux);
            nodoIzq.setPadre(nuevaRaiz);
            nodoDer.setPadre(nuevaRaiz);
            
            if(!nodo.getHijos().isEmpty()){
                for(int i = 0; i < mitadClave+1; i++){
                    nodoIzq.getHijos().add(nodo.getHijos().get(i));
                    nodoIzq.getHijos().get(i).setPadre(nodoIzq);
                }

                for(int i = mitadClave + 1; i < nodo.getHijos().size(); i++){
                    nodoDer.getHijos().add(nodo.getHijos().get(i));
                    nodoDer.getHijos().get(i-mitadClave-1).setPadre(nodoDer);
                }                
            }
            
            nuevaRaiz.getHijos().add(nodoIzq);
            nuevaRaiz.getHijos().add(nodoDer);
            raiz = nuevaRaiz;
        }
        else{
            nodoIzq.setPadre(nodo.getPadre());
            nodoDer.setPadre(nodo.getPadre());
            nodo.getPadre().getClaves().add(aux);
            Collections.sort(nodo.getPadre().getClaves());
            
            int indice = nodo.getPadre().getClaves().indexOf(aux);
            
            if(!nodo.getHijos().isEmpty()){
                for(int i = 0; i < mitadClave+1; i++){
                    nodoIzq.getHijos().add(nodo.getHijos().get(i));
                    nodoIzq.getHijos().get(i).setPadre(nodoIzq);
                }

                for(int i = mitadClave + 1; i < nodo.getHijos().size(); i++){
                    nodoDer.getHijos().add(nodo.getHijos().get(i));
                    nodoDer.getHijos().get(i-mitadClave-1).setPadre(nodoDer);
                }    
            }
            
            nodo.getPadre().getHijos().remove(indice);
            nodo.getPadre().getHijos().add(indice, nodoIzq);
            nodo.getPadre().getHijos().add(indice+1, nodoDer);   
            
        
            if(nodo.getPadre().getClaves().size() == 2*orden + 1){
                separar(nodo.getPadre());
            }
        }
    }
    
    public void imprimirArbol() {
        imprimirNodo(raiz, 0, 0);
    }

    private void imprimirNodo(NodeBTree nodo, int nivel, int indiceHijo) {
        if (nodo != null) {
            StringBuilder prefijo = new StringBuilder();
            for (int i = 0; i < nivel; i++) {
                prefijo.append("  ");
            }

            // Agregar el nivel y el índice del hijo al prefijo
            prefijo.append("Nivel ").append(nivel).append("-Hijo ").append(indiceHijo).append(": ");

            // Imprimir las claves del nodo
            for (String clave : nodo.getClaves()) {
                System.out.println(prefijo.toString() + clave);
            }

            // Recorrer los hijos
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                imprimirNodo(nodo.getHijos().get(i), nivel + 1, i);
            }
        }
    }
}