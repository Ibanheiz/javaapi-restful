package com.ibanheiz.expose;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	 * Teste do método GET
	 * @author Nicolas Ibanheiz
	 * @return objeto JSON do Cliente teste
	 * @throws IOException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> buscar(){
		logger.info("Consumindo Web Service de consulta de Clientes");
		return clienteDAO.buscarTodos();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Cliente cliente) {
		logger.info("Consumindo Web Service de cadastro de Clientes");
		clienteDAO.salvar(cliente);
		return Response.ok().build();
	}
}