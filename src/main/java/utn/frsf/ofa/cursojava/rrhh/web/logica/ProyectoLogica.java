/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.logica;

import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Proyecto;

/**
 *
 * @author mdominguez
 */
public interface ProyectoLogica {

    public boolean cupoDisponible(Proyecto p);

    public boolean tieneEmpleadoEfectivo(Proyecto p);

    public boolean presupuestoDisponible(Proyecto p,Empleado e);
    
}
