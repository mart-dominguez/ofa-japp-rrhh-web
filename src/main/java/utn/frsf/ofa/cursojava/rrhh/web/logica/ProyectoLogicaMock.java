/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.logica;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Proyecto;

/**
 *
 * @author mdominguez
 */
@ApplicationScoped
@Alternative
@Priority(Interceptor.Priority.APPLICATION+10)
public class ProyectoLogicaMock implements ProyectoLogica{

    @Override
    public boolean cupoDisponible(Proyecto p) {
        return true;
    }

    @Override
    public boolean tieneEmpleadoEfectivo(Proyecto p) {
        return true;
    }

    @Override
    public boolean presupuestoDisponible(Proyecto p, Empleado e) {
        return true;
    }
    
}
