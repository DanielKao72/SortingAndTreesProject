package arboles.arbolB;

import java.util.ArrayList;

public class NodeBTree {
    private NodeBTree padre;
    private ArrayList<NodeBTree> hijos;
    private ArrayList<String> claves;
    
    public NodeBTree(int orden){
        this.hijos = new ArrayList<NodeBTree>((2*orden) + 1);
        this.claves = new ArrayList<String>(2*orden);
    }

    public NodeBTree getPadre() {
        return padre;
    }

    public void setPadre(NodeBTree padre) {
        this.padre = padre;
    }

    public ArrayList<NodeBTree> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<NodeBTree> hijos) {
        this.hijos = hijos;
    }

    public ArrayList<String> getClaves() {
        return claves;
    }

    public void setClaves(ArrayList<String> claves) {
        this.claves = claves;
    }

    public boolean esHoja(){
        return hijos.isEmpty();
    }
    
}