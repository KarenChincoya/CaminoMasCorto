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
public class Linea {
    char nombre;

    Estacion head;
    Estacion tail; //ciclicas
    
    String[] conexiones;
    //una linea es un conjunto de estaciones
    public Linea(char nombre){
        this.nombre = nombre;
        System.out.println("Se ha creado una linea con el nombre: "+nombre);
    }
    
    public void appendEstacion(Estacion estacion){
        if(head == null){
            head = estacion;
            tail = estacion;
        }else{
            tail.setSiguiente(estacion);
            tail = estacion;
        }
        System.out.println("Se ha agregado una estacion " + estacion.estacionToString());
    } 

    public Estacion getHead() {
        return head;
    }
    public char getNombre() {
        return nombre;
    }
    //original, sinonimo                                Aa
    public void appendSinonimo(String sinonimo, String esta){//para agregar Sinomios a las estaciones, y asi cuando ejecutas lo de RUTA, ya sabes por donde ir
        //DEBEMOS ver si ya esta esa conexion
        Estacion current = head;
        boolean aux=false;
        while(aux==false){
            if(current.getNombreLinea() ==  esta.toCharArray()[1]){
                current.appendSinonimo(sinonimo);
            }
            current = current.getSiguiente();
        }
    }

}
