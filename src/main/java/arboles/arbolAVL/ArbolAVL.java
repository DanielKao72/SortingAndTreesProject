package arboles.arbolAVL;

import arboles.ItemNotFoundException;
import arboles.NodoBin;

public class ArbolAVL {

    protected NodoAVL raíz;

    public ArbolAVL(String o) {
        raíz = new NodoAVL(o);
    }

    public void inOrden() {
        if (raíz != null) {
            raíz.inOrden();
        }
    }

    public void preOrden() {
        if (raíz != null) {
            raíz.preOrden();
        }
    }

    public void posOrden() {
        if (raíz != null) {
            raíz.posOrden();
        }
    }

    public void insertar(String o) {
        insertarOrdenado(raíz, o);
    }

    public void insertarOrdenado(NodoAVL n, String o) {
        //Empezamos iterando por la Izquierda
        if (o.compareTo((String) n.getDato()) < 0) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoAVL(o, null, null, n));
                recalcularFE(n);
            } else {
                insertarOrdenado((NodoAVL) n.getIzq(), o);
            }
        } else {
            if (o.compareTo((String) n.getDato()) > 0) {
                if (n.getDer() == null) {
                    n.setDer(new NodoAVL(o, null, null, n));
                    recalcularFE(n);
                } else {
                    insertarOrdenado((NodoAVL) n.getDer(), o);
                }
            }
        }
    }

    public void recalcularFE() {
        recalcularFE(raíz);
    }

    public void recalcularFE(NodoAVL nodo) {
        if (nodo != null) {
            nodo.setFe(NodoAVL.altura((NodoAVL) nodo.getDer()) - NodoAVL.altura((NodoAVL) nodo.getIzq()));
            if (nodo.getFe() == 2 || nodo.getFe() == -2) {
                balancear(nodo);
            } else {
                recalcularFE(nodo.getPadre());
            }
        }
    }

    public void balancear(NodoAVL nodo) {
        int feActual = nodo.getFe();
        if (feActual == 2) {
            switch (((NodoAVL) nodo.getDer()).getFe()) {
                case 0, 1 -> {
                    rotacionDD(nodo);

                }
                case -1 -> {
                    rotacionDI(nodo);

                }
            }
        } else {
            switch (((NodoAVL) nodo.getIzq()).getFe()) {
                case 0, -1 -> {
                    rotacionII(nodo);

                }
                case 1 -> {
                    rotacionID(nodo);

                }
            }
        }
    }

    public void rotacionDD(NodoAVL nodo) {
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getDer();
        NodoAVL B = (NodoAVL) Q.getIzq();

        if (Padre != null) {
            if (Padre.getDer() == P) {
                Padre.setDer(Q);
            } else {
                Padre.setIzq(Q);
            }
        } else {
            raíz = Q;
        }

        //Reconstruir el árbol
        P.setDer(B);
        Q.setIzq(P);

        //Reasignación de Padres
        P.setPadre(Q);
        if (B != null) {
            B.setPadre(P);
        }
        Q.setPadre(Padre);
        //Ajustar los Factores de Equilibrio
        P.setFe(0);
        Q.setFe(0);
    }

    public void rotacionII(NodoAVL nodo) {
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getIzq();
        NodoAVL B = (NodoAVL) Q.getDer();
        if (Padre != null) {
            if (Padre.getIzq() == P) {
                Padre.setIzq(Q);
            } else {
                Padre.setDer(Q);
            }
        } else {
            raíz = Q;
        }
        //Recontruir el árbol 
        P.setIzq(B);
        Q.setDer(P);
        //Reasignar a los papás
        P.setPadre(Q);
        if (B != null) {
            B.setPadre(P);
        }
        Q.setPadre(Padre);
        //Ajustar los FE
        P.setFe(0);
        Q.setFe(0);
    }

    public void rotacionID(NodoAVL nodo) {
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getIzq();
        NodoAVL R = (NodoAVL) Q.getDer();
        NodoAVL B = (NodoAVL) R.getIzq();
        NodoAVL C = (NodoAVL) R.getDer();
        if (Padre != null) {
            if (Padre.getDer() == nodo) {
                Padre.setDer(R);
            } else {
                Padre.setIzq(R);
            }
        } else {
            raíz = R;
        }

        //Reconstruir el árbol
        Q.setDer(B);
        P.setIzq(C);
        R.setIzq(Q);
        R.setDer(P);

        //Reasignar los padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B != null) {
            B.setPadre(Q);
        }
        if (C != null) {
            C.setPadre(P);
        }

        //Reasignar los FE
        switch (R.getFe()) {
            case -1 -> {
                Q.setFe(0);
                P.setFe(1);
            }
            case 0 -> {
                Q.setFe(0);
                P.setFe(0);
            }
            case 1 -> {
                Q.setFe(-1);
                P.setFe(0);
            }
        }
    }

    public void rotacionDI(NodoAVL nodo) {
        NodoAVL Padre = nodo.getPadre();
        NodoAVL P = nodo;
        NodoAVL Q = (NodoAVL) P.getDer();
        NodoAVL R = (NodoAVL) Q.getIzq();
        NodoAVL B = (NodoAVL) R.getDer();
        NodoAVL C = (NodoAVL) R.getIzq();

        if (Padre != null) {
            if (Padre.getIzq() == nodo) {
                Padre.setIzq(R);
            } else {
                Padre.setDer(R);
            }
        } else {
            raíz = R;
        }

        //Reconstuir el árbol
        Q.setIzq(B);
        P.setDer(C);
        R.setDer(Q);
        R.setIzq(P);

        //Reasignar padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B != null) {
            B.setPadre(Q);
        }
        if (C != null) {
            C.setPadre(P);
        }

        //Asignar valores de los FE
        switch (R.getFe()) {
            case -1 -> {
                Q.setFe(0);
                P.setFe(1);
            }
            case 0 -> {
                Q.setFe(0);
                P.setFe(0);
            }
            case 1 -> {
                Q.setFe(-1);
                P.setFe(0);
            }
        }
    }

    public NodoBin buscarMin(NodoBin n) {
        while (n.getIzq() != null) {
            n = n.getIzq();
        }
        return n;
    }

    public void buscar(String o) {
        buscar(raíz, o);
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
