/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frsf.ofa.cursojava.rrhh.web.controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import utn.frsf.ofa.cursojava.rrhh.web.modelo.Cliente;
import utn.frsf.ofa.cursojava.rrhh.web.service.ClienteService;

/**
 *
 * @author marti
 */
@RequestScoped
@Named("listaClientesCtrl")
public class ListaClienteController  {
    
    @Inject ClienteService clienteService;
    
    @Inject ClienteController clienteController;
    
    private Cliente clienteSeleccionado;

    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }
    
    
    public List<Cliente> getClientes(){
        return clienteService.todos();
    }
    
    public String seleccionarCliente(){        
        clienteController.setCliente(clienteSeleccionado);
        return "altaCliente.xhtml";
    }
    
    public String nuevoCliente(){        
        clienteController.setCliente(new Cliente());
        return "altaCliente.xhtml";
    }
}
