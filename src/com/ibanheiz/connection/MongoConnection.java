package com.ibanheiz.connection;

import java.net.UnknownHostException;

import javax.inject.Inject;

import com.ibanheiz.utils.LoggerUtil;
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
		}
	}

	/**
	 * @return the mongo
	 */
	public MongoClient getMongo() {
		return mongo;
	}
}
