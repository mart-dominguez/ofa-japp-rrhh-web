/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import utn.frsf.ofa.cursojava.rrhh.web.logica.GestionProyectosException;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Proyecto;
import utn.frsf.ofa.cursojava.rrhh.web.service.ProyectoService;

/**
 *
 * @author mdominguez
 */
@Stateless
@Path("/proyecto")
public class ProyectoResource {

    @Inject 
    private ProyectoService proyectoService;
    
    @GET
    public Response listarProyectos(@QueryParam("nombre") String nombre){
        List<Proyecto> lista = new ArrayList<>();
        lista = proyectoService.todos();
        System.out.println(lista);
        return Response.ok(lista).build();
    }

    @GET
    @Path("{id}")
    public Response buscarPorId(@PathParam("id") Integer idProyecto){        
        return Response.ok(proyectoService.porId(idProyecto)).build();
    }

    @POST
    public Response crearProyecto(Proyecto cli){
        proyectoService.guardar(cli);
        return Response.ok().build();
    }

    @PUT
    public Response actualizarProyecto(Proyecto cli){
        proyectoService.guardar(cli);
        return Response.ok("PUT"+cli.getNombre()).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response actualizarProyecto(@PathParam("id") Integer idProyecto){
        proyectoService.borrar(idProyecto);
        return Response.ok("DELETE ok").build();
    }
    
    @PUT
    @Path("{id}/empleado")
    public Response agreagrEmpleado(@PathParam("id") Integer idProyecto,Empleado empleado){
        Proyecto p = proyectoService.porId(idProyecto);
        try {
            proyectoService.agregarEmpleado(p, empleado);
        } catch (GestionProyectosException ex) {
            Logger.getLogger(ProyectoResource.class.getName()).log(Level.SEVERE, null, ex);
            return  Response.status(Response.Status.BAD_REQUEST).entity("FALLO").build();
        }
        return Response.ok("EMPLEAOD AGREGADO").build();
    }
}
