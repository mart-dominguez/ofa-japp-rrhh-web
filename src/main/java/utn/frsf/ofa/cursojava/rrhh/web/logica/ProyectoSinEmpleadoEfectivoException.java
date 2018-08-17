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
public class ProyectoSinEmpleadoEfectivoException extends GestionProyectosException{
 
    public ProyectoSinEmpleadoEfectivoException(){
        super("Antes de asignar un empleado contratado, tiene que haberse asignado al menos un empleado Efectivo");
    }
}
