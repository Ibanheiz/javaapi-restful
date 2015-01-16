package com.ibanheiz.expose;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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

import com.ibanheiz.connection.MongoConnection;
import com.ibanheiz.model.Cliente;
import com.ibanheiz.utils.LoggerUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * API de controle de Clientes
 * @author Nicolas IBanheiz
 */
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ClienteResource implements Serializable {
	private static final long serialVersionUID = 9035620292826255422L;

	@Inject
	private MongoConnection mongo;
	@Inject
	private LoggerUtil logger;

	/**
	 * Teste do método GET
	 * @author Nicolas Ibanheiz
	 * @return objeto JSON do Cliente teste
	 * @throws IOException
	 */
	@GET
	public List<Cliente> buscar() throws IOException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		mongo.connect();
		DBCursor cursor = mongo.getClientesCollection().find();
		while (cursor.hasNext()) {
			DBObject object = cursor.next();
			Cliente cliente = new Cliente();
			List<String> telefones = new ArrayList<String>();
			cliente.set_id(object.get("_id").toString());
			cliente.setRazaoSocial(object.get("razaoSocial").toString());
			cliente.setNomeFantasia(object.get("nomeFantasia").toString());
			cliente.setCnpj((object.get("cnpj") == null) ? null : object.get("cnpj").toString());
			cliente.setCpf((object.get("cpf") == null) ? null : object.get("cpf").toString());
			BasicDBList telefonesDocument = (BasicDBList) object.get("telefones");
			for (Object obj : telefonesDocument.toArray()) {
				telefones.add(obj.toString());
			}
			cliente.setTelefones(telefones);
			clientes.add(cliente);

		}
		mongo.close();
		return clientes;
	}

	@POST
	public Response cadastrar(Cliente cliente) {
		mongo.connect();
		DBCollection collection = mongo.getClientesCollection();
		BasicDBObject clienteDocument = new BasicDBObject();
		
		clienteDocument.put("razaoSocial", cliente.getRazaoSocial());
		clienteDocument.put("nomeFantasia", cliente.getNomeFantasia());
		clienteDocument.put("cnpj", cliente.getCnpj());
		clienteDocument.put("cpf", cliente.getCpf());
		clienteDocument.put("telefones", cliente.getTelefones());
		collection.insert(clienteDocument);
		logger.info("Inserindo o Cliente: " + cliente.getRazaoSocial());

		mongo.close();
		return Response.ok().build();
	}
}