package arboles;

public class NodoAVL extends NodoBin {

    protected int fe;
    protected NodoAVL padre;

    public NodoAVL() {
    }

    public NodoAVL(String dato) {
        super(dato);
    }

    public NodoAVL(String dato, NodoBin izq, NodoBin der) {
        super(dato, izq, der);
    }

    public NodoAVL(String dato, NodoBin izq, NodoBin der, NodoAVL padre) {
        super(dato, izq, der);
        this.padre = padre;
    }

    //Recursivo
    public static int altura(NodoAVL a) {
        if (a == null) {
            return -1;
        } else //Devuelve cual es el valor mas alto
        {
            return 1 + Math.max(altura((NodoAVL) a.getIzq()), altura((NodoAVL) a.getDer()));
        }
    }

    //Ordenamiento ascedente
    public void inOrden() {
        if (izq != null) {
            izq.inOrden();
        }
        System.out.println(dato + " FE:" + getFe());//Lugar de la raiz
        if (der != null) {
            der.inOrden();
        }
    }

    public void preOrden() {
        System.out.println(dato + " FE:" + getFe());//Lugar de la raiz        
        if (izq != null) {
            izq.preOrden();
        }
        if (der != null) {
            der.preOrden();
        }
    }

    public void posOrden() {
        if (izq != null) {
            izq.posOrden();
        }
        if (der != null) {
            der.posOrden();
        }
        System.out.println(dato + " FE:" + getFe());//Lugar de la raiz        
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public NodoAVL getPadre() {
        return padre;
    }

    public void setPadre(NodoAVL padre) {
        this.padre = padre;
    }

}
