/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.logica;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;

/**
 *
 * @author mdominguez
 */
@ApplicationScoped
@Alternative
@Priority(Interceptor.Priority.APPLICATION+10)
public class EmpleadoLogicaMock implements EmpleadoLogica{

    @Override
    public boolean puedeSumarseProyectoNuevo(Empleado e) {        
        return true;
    }
    
}
