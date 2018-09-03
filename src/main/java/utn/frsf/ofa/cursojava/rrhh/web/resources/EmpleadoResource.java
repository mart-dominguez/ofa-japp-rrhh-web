/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.resources;

import java.util.ArrayList;
import java.util.List;
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
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Empleado;
import utn.frsf.ofa.cursojava.rrhh.web.service.EmpleadoService;

/**
 *
 * @author mdominguez
 */
@Stateless
@Path("/emplleado")
public class EmpleadoResource {

    @Inject 
    private EmpleadoService clienteService;
    
    @GET
    public Response listarEmpleados(@QueryParam("nombre") String nombre){
        List<Empleado> lista = new ArrayList<>();
        if(nombre!=null && nombre.trim().length()>0){
            lista = clienteService.porNombre(nombre);
        }
        else {
            lista = clienteService.todos();
        }
        System.out.println(lista);
        return Response.ok(lista).build();
    }

    @GET
    @Path("{id}")
    public Response buscarPorId(@PathParam("id") Integer idEmpleado){        
        return Response.ok(clienteService.porId(idEmpleado)).build();
    }

    @POST
    public Response crearEmpleado(Empleado cli){
        clienteService.guardar(cli);
        return Response.ok().build();
    }

    @PUT
    public Response actualizarEmpleado(Empleado cli){
        clienteService.guardar(cli);
        return Response.ok("PUT"+cli.getNombre()).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response actualizarEmpleado(@PathParam("id") Integer idEmpleado){
        clienteService.borrar(idEmpleado);
        return Response.ok("DELETE ok").build();
    }
    
}
