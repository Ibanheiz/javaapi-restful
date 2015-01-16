package com.ibanheiz.connection;

import java.net.UnknownHostException;

import javax.inject.Inject;

import com.ibanheiz.utils.LoggerUtil;
import com.ibanheiz.utils.enums.MongoCollections;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoConnection {

	@Inject
	private LoggerUtil loggerUtil;

	private MongoClient mongo;
	
	/**
	 * Conectar com o MongoDb
	 * @author Nicolas Ibanheiz
	 */
	public void connect() {
		try {
			mongo = new MongoClient("localhost", 27017);
			loggerUtil.info("Abrindo conexão com o MongoDb");
		} catch (UnknownHostException e) {
			loggerUtil.error("Erro ao conectar com o MongoDb");
			e.printStackTrace();
		}
	}

	/**
	 * Fecha conexão com o MongoDb
	 * @author Nicolas Ibanheiz
	 */
	public void close() {
		if (mongo != null) {
			mongo.close();
			loggerUtil.info("Fechando conexão com o MongoDb");
		}
	}
	
	/**
	 * @author Nicolas Ibanheiz
	 * @return Objeto DB do mongo com conexão da base 'javaapi'
	 */
	public DB getJavaApiDatabase() {
		return mongo.getDB("javaapi");
	}

	/**
	 * @author Nicolas Ibanheiz
	 * @return Nome da coleção de clientes
	 */
	public DBCollection getClientesCollection() {
		return getJavaApiDatabase().getCollection(MongoCollections.CLIENTES.getName());
	}
}
