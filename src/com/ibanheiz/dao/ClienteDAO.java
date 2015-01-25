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
		logger.info("Salvando Cliente: " + cliente.getRazaoSocial());
		datastore.save(cliente);
	}
	
	/**
	 * Busca todos os Clientes
	 * @author Nicolas Ibanheiz
	 */
	public List<Cliente> buscarTodos() {
		logger.info("Buscando todos os Clientes");
		Query<Cliente> query = datastore.find(Cliente.class);
		return query.asList();
	}
	
	/**
	 * Utilizada o método save(T Entity) para alterar o objeto completo.
	 * Lança Runtime Exception no caso de não encontrar o ID referenciado
	 * @author Nicolas Ibanheiz
	 * @param id do Cliente
	 * @param cliente para ser alterado
	 */
	public void alterar(String id, Cliente cliente) {
		try {
			cliente.setId(id);
			datastore.save(cliente);
			logger.info("Alterando cliente de id: " + id);
		} catch (RuntimeException e) {
			logger.error("Provavel erro de ID ao alterar o Cliente:" + id + "\nErro: " + e.getMessage());
		}
	}
	
	/**
	 * Remove o Cliente
	 * @author Nicolas Ibanheiz
	 * @param id do cliente a ser removido
	 */
	public void remover(String id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		datastore.delete(cliente);
		logger.info("Removendo cliente de id: " + id);
	}
}
