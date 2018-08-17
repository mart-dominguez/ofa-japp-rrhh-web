/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.ApplicationException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frsf.ofa.cursojava.rrhh.web.logica.EmpleadoLogica;
import utn.frsf.ofa.cursojava.rrhh.web.logica.EmpleadoMaximoProyectosAsignadosException;
import utn.frsf.ofa.cursojava.rrhh.web.logica.GestionProyectosException;
import utn.frsf.ofa.cursojava.rrhh.web.logica.PresupuestoSobrepasadoException;
import utn.frsf.ofa.cursojava.rrhh.web.logica.ProyectoLogica;
import utn.frsf.ofa.cursojava.rrhh.web.logica.ProyectoMaximoEmpleadosException;
import utn.frsf.ofa.cursojava.rrhh.web.logica.ProyectoSinEmpleadoEfectivoException;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Proyecto;

/**
 *
 * @author mdominguez
 */
@Stateless
@ApplicationException(rollback=true)
public class ProyectoService {

    @Inject
    ProyectoLogica logicaProyecto;
    @Inject
    EmpleadoLogica logicaEmpleado;

    @PersistenceContext(unitName = "RRHH_WEB_PU")
    private EntityManager em;

    public Proyecto guardar(Proyecto c) {
        if (c.getId() == null) {
            em.persist(c);
        } else {
            c = em.merge(c);
        }
        em.flush();
        em.refresh(c);
        return c;
    }

    public Proyecto porId(Integer id) {
        return this.em.find(Proyecto.class, id);
    }

    public void borrar(Integer id) {
        this.em.remove(this.em.find(Proyecto.class, id));
    }

    public List<Proyecto> todos() {
        return this.em.createQuery("SELECT e FROM Proyecto e").getResultList();
    }

    public void agregarEmpleado(Proyecto p, Empleado e) throws GestionProyectosException {
        p = em.find(Proyecto.class, p.getId());
        e = em.find(Empleado.class, e.getId());
        
        // si no se cumple ninguna de las siguientes condiciones lanzar una excepcion
        if (!logicaProyecto.cupoDisponible(p) ) throw new ProyectoMaximoEmpleadosException();
        if (!logicaProyecto.tieneEmpleadoEfectivo(p) && e.esContratado() ) throw new ProyectoSinEmpleadoEfectivoException();
        if (!logicaEmpleado.puedeSumarseProyectoNuevo(e) ) throw new EmpleadoMaximoProyectosAsignadosException();
        if (!logicaProyecto.presupuestoDisponible(p,e) ) throw new PresupuestoSobrepasadoException();

        // si la lista de empleados no existe iniciarla con la lista vacia
        if (p.getEmpleados() == null) {
                p.setEmpleados(new ArrayList<Empleado>());
        }
        
        p.getEmpleados().add(e);
    }

}
