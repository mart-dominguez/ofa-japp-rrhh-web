/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.logica;

import javax.enterprise.context.ApplicationScoped;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;

/**
 *
 * @author mdominguez
 */
@ApplicationScoped 
public class EmpleadoLogicaDefault implements EmpleadoLogica {

    @Override
    public boolean puedeSumarseProyectoNuevo(Empleado e) {
        return e.getProyectosAsignados().size()<2;
    }
    
}
