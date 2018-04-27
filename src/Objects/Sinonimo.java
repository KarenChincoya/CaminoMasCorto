/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Karen Velasco
 */
public class Sinonimo {
    Sinonimo siguiente;
    
    char linea;
    char estacion;
            
    public Sinonimo(char linea, char estacion){
        this.linea = linea;
        this.estacion = estacion;
    }

    public void setSiguiente(Sinonimo siguiente) {
        this.siguiente = siguiente;
    }

    public char getLinea() {
        return linea;
    }

    public char getEstacion() {
        return estacion;
    }
    
    
    
}
