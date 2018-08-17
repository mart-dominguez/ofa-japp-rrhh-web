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
public class ProyectoMaximoEmpleadosException extends GestionProyectosException{
 
    public ProyectoMaximoEmpleadosException(){
        super("Un proyecto no puede tener más de 3 empleados asignados");
    }
}
