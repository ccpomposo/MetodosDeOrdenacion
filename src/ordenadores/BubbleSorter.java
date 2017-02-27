/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenadores;

import model.Lista;
import model.Nodo;

/**
 *
 * @author Usuario
 */
public class BubbleSorter {
    
    public void ordenar(Lista<Integer> lista) {
        Nodo<Integer> i = lista.getInicio();
        Nodo<Integer> j;
        while (i != null && i.getSiguiente() != null) {
            j = i.getSiguiente();
            while (j != null) {
                if(i.getDato() > j.getDato()) {
                    Integer aux = i.getDato();
                    i.setDato(j.getDato());
                    j.setDato(aux);
                }
                j = j.getSiguiente();
            }
            i = i.getSiguiente();
        }
    }
}
