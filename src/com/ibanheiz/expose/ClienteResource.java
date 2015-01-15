package com.ibanheiz.expose;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibanheiz.model.Cliente;

/**
 * API de controle de Clientes
 * @author Nicolas IBanheiz
 */
@Path("/clientes")
public class ClienteResource {

	/**
	 * Teste do método GET
	 * @author Nicolas Ibanheiz
	 * @return objeto JSON do Cliente teste
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarCliente() {
		Cliente cliente = new Cliente();
		List<String> telefones = new ArrayList<String>();
		
		cliente.setId(1);
		cliente.setNome("Nicolas");
		telefones.add("(11) 0000-0000");
		telefones.add("(11) 9999-9999");
		cliente.setTelefones(telefones);
		
		return cliente;
	}
}