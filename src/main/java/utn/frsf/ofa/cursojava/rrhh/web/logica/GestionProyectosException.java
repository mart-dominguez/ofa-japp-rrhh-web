/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.logica;

/**
 *
 * @author mdominguez
 */
public class GestionProyectosException extends Exception{
    
    public GestionProyectosException(){
        super("No se pudo procesar la peticion");
    }
    
    public GestionProyectosException(String msg){
        super(msg);
    }
    
}
