/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenadores;

import model.ListaDoble;
import model.Nodo;

/**
 *
 * @author Usuario
 */
public class ShellSorter {
    
    public void ordenar(ListaDoble<Integer> lista ) {
        int t = lista.getLenght(); 
        int pvt = t/2;
        Nodo<Integer> i = lista.getInicio();
        Nodo<Integer> j = lista.getInicio();
        for (int k = 0; j!=null && k < pvt; k++) {
            j = j.getSiguiente();
        }
        while(pvt >= 1) {
            while(j != null) {
                Nodo<Integer> aux = i;
                Nodo<Integer> aux2 = j;
                while(aux != null && aux.getDato()>aux2.getDato()) {
                    Integer numAux = aux.getDato();
                    aux.setDato(aux2.getDato());
                    aux2.setDato(numAux);
                    Integer cont = 0;
                    aux2 = aux;
                    while(aux!= null && cont < pvt) {
                        aux = aux.getAnterior();
                        cont++;
                    }
                }
                i = i.getSiguiente();
                j = j.getSiguiente();
            }
            pvt /= 2;
            i = lista.getInicio();
            j = lista.getInicio();
            for (int k = 0; j!=null && k < pvt; k++) {
                j = j.getSiguiente();
            }            
        }
    }
}
