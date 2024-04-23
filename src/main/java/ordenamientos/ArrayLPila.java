package ordenamientos;

import java.util.ArrayList;

public class ArrayLPila implements Pila {

    protected ArrayList pila;

    public ArrayLPila() {
        pila = new ArrayList();
    }

    @Override
    public void push(Object x) {
        pila.add(x);
    }

    @Override
    public Object pop() {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        } else {
            return pila.remove(pila.size() - 1);
        }
    }

    @Override
    public Object top() {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        } else {
            return pila.get(pila.size() - 1);
        }
    }

    @Override
    public int size() {
        return pila.size();
    }

    @Override
    public boolean isEmpty() {
        return pila.isEmpty();
    }

}
