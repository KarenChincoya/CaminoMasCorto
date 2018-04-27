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
public class Estacion {
    Estacion siguiente;
    Estacion anterior;
   
    Integer tiempo = 0;
    
    char nombreLinea;
    char nombre; //letra 
    boolean conexion;
    
    //Otra lista para almacenar Linea y letra
    Sinonimo sinonimoHead;
    
    String caminito;
    
    public Estacion(char linea, char nombre){
        this.nombreLinea = linea;
        this.nombre = nombre;
        this.tiempo = 0;
    }

    public char getNombreLinea() {
        return nombreLinea;
    }

    public char getNombre() {
        return nombre;
    }
    
    
    public void setCaminito(String caminito) {
        this.caminito = caminito;
    }

    public Sinonimo getSinonimoHead() {
        return sinonimoHead;
    }
    
    
    public void setSiguiente(Estacion siguiente) {
        this.siguiente = siguiente;
    }
    
    public String getCaminito() {
        return caminito;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
    public void appendSinonimo(String sinonimo){
        if(sinonimoHead == null){
            sinonimoHead = new Sinonimo(sinonimo.toCharArray()[0], sinonimo.toCharArray()[1]);//envias la linea y la estacion 
        }else{
            sinonimoHead.setSiguiente(new Sinonimo(sinonimo.toCharArray()[0], sinonimo.toCharArray()[1]));
        }
    }
    
    
    public boolean isConexion(){
        return conexion;
    }

    

    //cuantas conexiones tiene 
    public Integer numeroConexiones(){
        int cont=0;
        Sinonimo current = sinonimoHead;
        while(current!=null){
            cont++;
        }
        return cont;
    }
    
    public Sinonimo[] getConexiones(){
        Sinonimo[] sinonimo = new Sinonimo[this.numeroConexiones()];
        int i = 0;
        Sinonimo current = sinonimoHead;
        
        while(current!=sinonimoHead){
            sinonimo[i] = current;
            i++;
            current = current.siguiente;
        }
        return sinonimo;
    }

    public Estacion getSiguiente() {
        return siguiente;
    }
    
    public void actualizarTiempo(Integer n){
        this.tiempo = n;
    }
    
    
    public boolean isFinal(char lineaFinal, char estacionFinal){
        Sinonimo current = sinonimoHead;
        while(current!=null){
            if(current.getLinea() == lineaFinal && 
                    current.getEstacion() == estacionFinal)
                return true;
        }
        return false;
    }

    public Estacion getAnterior() {
        return anterior;
    }
    
    public String estacionToString(){
        return this.nombreLinea+" "+this.nombre;
    }
    
}
