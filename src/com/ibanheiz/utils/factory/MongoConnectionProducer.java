package com.ibanheiz.utils.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

import org.mongodb.morphia.Datastore;

import com.ibanheiz.connection.MongoConnection;
import com.ibanheiz.utils.annotation.JavaApiConnection;

/**
 * Produtor da conexão com MongoDb
 * @author Nicolas IBanheiz
 */
public class MongoConnectionProducer {

	/**
	 * @author Nicolas Ibanheiz
	 * @return MongoConnection para o base 'javaapi'
	 */
	@Produces
	@ApplicationScoped
	@JavaApiConnection
	public MongoConnection criarMongoConnection() {
		return new MongoConnection();
	}

	/**
	 * @author Nicolas Ibanheiz
	 * @param mongoConnection
	 * @return DataStopre para conexão da base 'javaapi'
	 */
	@Produces
	@RequestScoped
	public Datastore criarDataStore(@JavaApiConnection MongoConnection mongoConnection) {
		return mongoConnection.getDataStore();
	}
}
