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
public class RadixSorter {
    
    public void ordenar(Lista<Integer> lista) {
        Nodo<Integer> nodo = lista.getInicio();
        boolean flag = true;
        int vuelta = 1;
        while(nodo != null && flag) {
            Lista<Integer> l = new Lista();
            Lista<Integer>[] array = new Lista[10];
            for (int i = 0; i < 10; i++) {
                array[i] = new Lista();
            }
            flag = false;
            while(nodo != null) {
                int aux = nodo.getDato();   
                int mod = 0;
                for (int i = 0; i < vuelta; i++) {
                    if(aux != 0) {
                        mod = aux % 10;   
                        aux /= 10;    
                        if (i== vuelta-1)
                            flag = true;
                    }                                  
                    else
                        mod = 0;
                }
                array[mod].insertarFinal(nodo.getDato());
                nodo = nodo.getSiguiente();
            }
            for (int i = 0; i < 10; i++) {
                Nodo aux = array[i].getInicio();
                while(aux!=null){
                    l.insertarFinal(aux.getDato());
                    aux = aux.getSiguiente();
                }
            }            
            lista.setInicio(null);
            Nodo aux = l.getInicio();
            while(aux!=null) {
                lista.insertarFinal(aux.getDato());
                aux = aux.getSiguiente();
            }
            nodo = lista.getInicio();
            vuelta++;
        }
    }
    
}
