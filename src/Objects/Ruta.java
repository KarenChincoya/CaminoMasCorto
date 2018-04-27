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
public class Ruta {
    Linea[] linea;
    Estacion inicio;
    Estacion fin;
    
    Integer durMinima;
    String caminito;
    
    //arreglo de lineas
    public Ruta(String ruta, Linea[] linea){//Estacion inicio, Estacion fin, Linea[] linea
        //A:fgmpjj=Df
        
        this.inicio = new Estacion(ruta.toCharArray()[0], ruta.toCharArray()[1]);
        this.fin = new Estacion(ruta.toCharArray()[2], ruta.toCharArray()[3]);
        
        //ahora crear el arreglo de lineas
        
        this.linea = linea;
    }

    public String getCaminito() {
        return caminito;
    }

    
    
    public void evaluarCaminos(char lineaId, char estacionId){        
        Estacion current = null;
//1. Ubicar en la linea
            boolean bandera = false;
            int i = 0;
            while(bandera==false){
                if(lineaId == linea[i].getNombre()){
                    current = linea[i].getHead();
                    while(current.getNombre()!=estacionId){
                        current = current.getSiguiente();
                    }
                    bandera = true;
                    //current es la que debemos seguir
                }
            }
            
        //2. Si tienes conexiones, evalua las conexiones 
        
        if(current.isConexion()){
                        //tinees que seguir los caminos que te dicen
            int cont = current.numeroConexiones();
            
            Sinonimo[] sinonimo = current.getConexiones();
            
            for(int k=0; k<current.numeroConexiones(); k++){
                this.evaluarCaminos(sinonimo[k].getLinea(), sinonimo[k].getEstacion());
            }
            
        }
        //Actualizar los datos 
            current.setTiempo(current.getAnterior().getTiempo()+1);//solo le sumas 1
            current.setCaminito(current.getCaminito().concat(String.valueOf(current.getNombreLinea()) + String.valueOf(current.getNombre())));
                        //checa si es el final
            if(current.getNombreLinea()==fin.getNombreLinea() 
                && current.getNombre() == fin.getNombre()){
                
                if(current.getTiempo() < durMinima){
                    durMinima = current.getTiempo();
                    caminito = current.getCaminito();
                }
            
            }else{
                current = current.siguiente;
            }
                        
        
    }
}
