package com.ibanheiz.expose;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibanheiz.dao.ClienteDAO;
import com.ibanheiz.model.Cliente;
import com.ibanheiz.utils.LoggerUtil;

/**
 * API de controle de Clientes
 * @author Nicolas IBanheiz
 */
@Path("/clientes")
@RequestScoped
public class ClienteResource implements Serializable {
	private static final long serialVersionUID = 9035620292826255422L;

	@Inject
	private ClienteDAO clienteDAO;
	@Inject
	private LoggerUtil logger;

	/**
	 * @author Nicolas Ibanheiz
	 * @return objeto JSON de todos os Clientes
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> buscar(){
		logger.info("Consumindo Web Service de consulta de Clientes");
		return clienteDAO.buscarTodos();
	}

	/**
	 * @author Nicolas Ibanheiz
	 * @param cliente
	 * @return Response Ok
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente) {
		logger.info("Consumindo Web Service de cadastro de Clientes");
		clienteDAO.salvar(cliente);
		return Response.ok().build();
	}

	/**
	 * @author Nicolas Ibanheiz
	 * @param id do cliente a ser removido
	 * @param cliente com valores alterados
	 * @return Response ok
	 */
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(@PathParam("id") String id, Cliente cliente) {
		logger.info("Consumindo o Web Service de alteração para o Cliente id: " + id);
		clienteDAO.alterar(id, cliente);
		return Response.ok().build();
	}
	
	/**
	 * @author Nicolas Ibanheiz
	 * @param id do cliente a ser removido
	 * @return Response ok
	 */
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") String id) {
		logger.info("Consumindo o Web Service de exclusão para o Cliente id: " + id);
		clienteDAO.remover(id);
		return Response.ok().build();
	}
}