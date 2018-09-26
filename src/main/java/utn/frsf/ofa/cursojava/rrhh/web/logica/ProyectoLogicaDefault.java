/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.logica;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Proyecto;

/**
 *
 * @author mdominguez
 */
@ApplicationScoped 
public class ProyectoLogicaDefault implements ProyectoLogica{

    @Override
    public boolean cupoDisponible(Proyecto p) {
        return p.getEmpleados().size()<3;
    }

    @Override
    public boolean tieneEmpleadoEfectivo(Proyecto p) {
        for(Empleado e: p.getEmpleados()){
            if(e.esEfectivo()) return true;
        }
        return false;
    }

    @Override
    public boolean presupuestoDisponible(Proyecto p, Empleado e) {
        double total = 0.0;
        for(Empleado emp: p.getEmpleados() ){
            total += emp.salario();
        }
        return (p.getPresupuestoMaximo()- total - e.salario())>0;
    }
    
}
