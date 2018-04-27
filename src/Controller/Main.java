/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Objects.Estacion;
import Objects.Linea;
import Objects.Ruta;
import Utilidades.ArchivoUtilidades;

/**
 *
 * @author Karen Velasco
 */
public class Main {
    public static void main(String[] args) {
        
        String[] sinonimos;
        
        String path = System.getProperty("user.dir"); //user.dir dentro 
        String nombre = path+"\\INPUT.TXT";
        Integer lineas = Integer.valueOf(ArchivoUtilidades.leerRenglon(0, nombre));
    //    System.out.println("hay "+lineas+" lineas");
        
        Linea[] listaLinea = new Linea[lineas]; 
        String aux;
        
        int i;
        
        Estacion estacion;
        String key = "[:=]" ;// NO FUNCIONA CON ":=";
        String[] tokens;
        
        int contadorSinonimos = 0;
        String separadorSinonimos = "=";
        String[]  separadosPorSinonimos;
        
        for(i=0; i<lineas; i++){ //leer las siguientes lineas
            aux = ArchivoUtilidades.leerRenglon(i+1, nombre); //A:fgmpnxaa=Dbf
            //crear las lineas
            System.out.println("Linea "+(i+1));
            
            tokens = aux.split(key);
            
            separadosPorSinonimos = aux.split(separadorSinonimos);
            contadorSinonimos += separadosPorSinonimos.length;
            
            //aux.s
            for(int ka=0; ka<tokens.length; ka++){
                System.out.println(tokens[ka]);
                System.out.println();
            }
            
            listaLinea[i] = new Linea(tokens[0].toCharArray()[0]);
            
            for(int j=0; j < tokens[1].length(); j++){
                estacion = new Estacion(tokens[0].toCharArray()[0], tokens[1].toCharArray()[j]);
                listaLinea[i].appendEstacion(estacion);
            }
           
        }
        
        
        
        
        //ahora es tiempo de leer las rutas
        String rutaAux = "";
        
        int cont = 0;
        
        while(rutaAux != "#" ){
            cont++;
            rutaAux = ArchivoUtilidades.leerRenglon(i, nombre);
            i++;
        }
        
        String result = "";
        Ruta ruta;
        
        for(i=lineas+1; i<=(lineas+cont);i++){
            aux = ArchivoUtilidades.leerRenglon(i, nombre);
            ruta = new Ruta(aux, listaLinea);
            //linea id, estacion id
            ruta.evaluarCaminos(aux.toCharArray()[0], aux.toCharArray()[1]);
            result = result.concat(ruta.getCaminito());
        }
        
        ArchivoUtilidades.escribir(path+"\\OUTPUT.txt", result);
        
    }
}
