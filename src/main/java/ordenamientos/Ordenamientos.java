package ordenamientos;

import java.util.ArrayList;

public class Ordenamientos {

    public void imprimir(ArrayList<String> A) {
        for (String A1 : A) {
            System.out.println(A1);
        }
    }

    public void burbujaMayor(ArrayList<String> A) {
        int i, j;
        String aux = null;
        for (i = 1; i < A.size(); i++) {
            for (j = 0; j < A.size() - i; j++) {
                if (A.get(j).compareTo(A.get(j + 1)) >= 0) {
                    String temp = A.get(j);
                    A.set(j, A.get(j + 1));
                    A.set(j + 1, temp);
                }
            }
        }
    }

    public void insercion(ArrayList<String> A) {
        int i, k;
        for (i = 1; i < A.size(); i++) {
            String aux = A.get(i);
            k = i - 1;
            while (k >= 0 && aux.compareTo(A.get(k)) < 0) {
                A.set(k + 1, A.get(k));
                k--;
            }
            A.set(k + 1, aux);
        }
    }

    public void shellsort(ArrayList<String> A) {
        int intervalo, i;
        boolean band;
        intervalo = A.size() / 2; // Inicializar el intervalo como la mitad del tamaño del arreglo
        while (intervalo > 0) {
            band = true;
            while (band) {
                band = false;
                for (i = 0; i < A.size() - intervalo; i++) {
                    if (A.get(i).compareTo(A.get(i + intervalo)) > 0) {
                        String temp = A.get(i);
                        A.set(i, A.get(i + intervalo));
                        A.set(i + intervalo, temp);
                        band = true;
                    }
                }
            }
            intervalo /= 2; // Reducir el intervalo
        }
    }

    public void QuickSort(ArrayList<String> A) {
        ArrayLPila pilaMenor = new ArrayLPila();
        ArrayLPila pilaMayor = new ArrayLPila();
        pilaMenor.push(0);
        pilaMayor.push(A.size() - 1);
        while (!pilaMenor.isEmpty()) {
            int ini = (int) pilaMenor.pop();
            int fin = (int) pilaMayor.pop();
            int pos = posicionaQuickSort(ini, fin, A);
            if (ini < pos - 1) {
                pilaMenor.push(ini);
                pilaMayor.push(pos - 1);
            }
            if (fin > pos + 1) {
                pilaMenor.push(pos + 1);
                pilaMayor.push(fin);
            }
        }
    }

    public int posicionaQuickSort(int ini, int fin, ArrayList<String> A) {
        int pos = ini;
        String pivote = A.get(ini); // Seleccionar el pivote
        int izq = ini + 1;
        int der = fin;
        while (izq <= der) {
            while (izq <= fin && A.get(izq).compareTo(pivote) <= 0) {
                izq++;
            }
            while (der > ini && A.get(der).compareTo(pivote) > 0) {
                der--;
            }
            if (izq < der) {
                // Intercambiar elementos
                String temp = A.get(izq);
                A.set(izq, A.get(der));
                A.set(der, temp);
            }
        }
        // Intercambiar el pivote con el elemento en la posición der
        A.set(ini, A.get(der));
        A.set(der, pivote);
        return der;
    }

    public ArrayList<String> ordenaMerge(ArrayList<String> L) {
        int n = L.size(), i, m;
        ArrayList<String> L1 = new ArrayList(), L2 = new ArrayList();
        if (n > 1) {
            m = n / 2;
            for (i = 0; i < m; i++) {
                L1.add(L.get(i));
            }
            for (i = m; i < n; i++) {
                L2.add(L.get(i));
            }
            L = merge(ordenaMerge(L1), ordenaMerge(L2));
        }
        return L;
    }

    public ArrayList<String> merge(ArrayList<String> L1, ArrayList<String> L2) {
        ArrayList<String> lista = new ArrayList<>();
        while (!L1.isEmpty() && !L2.isEmpty()) {
            if (L1.get(0).compareTo(L2.get(0)) > 0) {
                lista.add(L1.get(0));
                L1.remove(0);
                if (L1.isEmpty()) {
                    lista.addAll(L2);
                    L2.clear();
                }
            } else {
                lista.add(L2.get(0));
                L2.remove(0);
                if (L2.isEmpty()) {
                    lista.addAll(L1);
                    L1.clear();
                }
            }
        }

        return lista;
    }

}
