package arboles;

public class ArbolABB {

    protected NodoBin raiz;

    public ArbolABB() {
        this(null);
    }

    public ArbolABB(String o) {
        raiz = new NodoBin(o);
    }

    public void inOrden() {
        if (raiz != null) {
            raiz.inOrden();
        }
    }

    public void posOrden() {
        if (raiz != null) {
            raiz.posOrden();
        }
    }

    public void preOrden() {
        if (raiz != null) {
            raiz.preOrden();
        }
    }

    public void insertar(String o) {
        insertarOrdenado(raiz, o);
    }

    public void insertarOrdenado(NodoBin n, String o) {
        if (o.compareTo((String) n.getDato()) < 0) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoBin(o));
            } else {
                insertarOrdenado(n.getIzq(), o);
            }
        } else {
            if (o.compareTo((String) n.getDato()) > 0) {
                if (n.getDer() == null) {
                    n.setDer(new NodoBin(o));
                } else {
                    insertarOrdenado(n.getDer(), o);
                }
            }
        }
    }

    public void buscar(String o) {
        buscar(raiz, o);
    }

    public void buscar(NodoBin n, String o) throws ItemNotFoundException {
        if (o.compareTo((String) n.getDato()) < 0) {
            if (n.getIzq() == null) {
                throw new ItemNotFoundException("false");
            } else {
                buscar(n.getIzq(), o);
            }
        } else {
            if (o.compareTo((String) n.getDato()) > 0) {
                if (n.getDer() == null) {
                    throw new ItemNotFoundException("false");
                } else {
                    buscar(n.getDer(), o);
                }
            } else {
                System.out.println("true");
            }
        }
    }

}
