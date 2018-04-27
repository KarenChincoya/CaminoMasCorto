/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author Karen Velasco
 * 
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ArchivoUtilidades {

    /**
     * @param args the command line arguments
     */
    	public static void escribir(String nombre, String texto) {
		File archivo = new File(nombre);

		try (FileWriter fw = new FileWriter(archivo);
				PrintWriter pw = new PrintWriter(fw)) {
			pw.write(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leerRenglon(Integer n, String nombre) {
		File archivo = new File(nombre);

		if (!archivo.exists()) {
			return null;
		}
		
		try (FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr)) {
			
                    String contenido = "";
		
                    String temporal = br.readLine();
			
                    int contador = 0;
                    while (temporal != null && contador<=n) {
                        if(contador == n) contenido += temporal;
                        temporal = br.readLine();
                        contador++;
		    }
			
			return contenido;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
    
}
