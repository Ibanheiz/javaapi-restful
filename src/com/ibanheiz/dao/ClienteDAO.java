package com.ibanheiz.dao;

import java.util.List;

import javax.inject.Inject;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import com.ibanheiz.model.Cliente;
import com.ibanheiz.utils.LoggerUtil;

public class ClienteDAO {

	@Inject
	private Datastore datastore;
	@Inject
	private LoggerUtil logger;
	
	/**
	 * Salva um Cliente
	 * @author Nicolas Ibanheiz
	 * @param cliente
	 */
	public void salvar(Cliente cliente) {
		datastore.save(cliente);
		logger.info("Salvando Cliente: " + cliente.getRazaoSocial());
	}
	
	/**
	 * Busca todos os Clientes
	 * @author Nicolas Ibanheiz
	 */
	public List<Cliente> buscarTodos() {
		Query<Cliente> query = datastore.find(Cliente.class);
		logger.info("Buscando todos os Clientes");
		return query.asList();
	}
}
