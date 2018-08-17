/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;

/**
 *
 * @author mdominguez
 */
@Stateless
public class EmpleadoService {

    @PersistenceContext(unitName = "RRHH_WEB_PU")
    private EntityManager em;

    public Empleado guardar(Empleado c){
        if(c.getId()==null) em.persist(c);
        else c = em.merge(c);
        em.flush();
        em.refresh(c);
        return c;
    }

    public Empleado porId(Integer id){
        return this.em.find(Empleado.class,id);
    }

    public void borrar(Integer id){
        this.em.remove(this.em.find(Empleado.class,id));        
    }
    
    public List<Empleado> todos(){
        return this.em.createQuery("SELECT e FROM Empleado e").getResultList();
    }
    
    public List<Empleado> porNombre(String nombre){
        return this.em
                .createQuery("SELECT e FROM Empleado e WHERE e.nombre LIKE CONCAT('%',:P_NOMBRE,'%')")
                .setParameter("P_NOMBRE", nombre)
                .getResultList();
    }
    
}
