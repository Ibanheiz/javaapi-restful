package com.ibanheiz.connection;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MongoConnection {

	private MongoClient mongo;
	
	private Morphia morphia;

	private static final String DATABASE = "javaapi";

	/**
	 * @return the mongoClient
	 */
	public MongoClient getMongo() {
		try {
			mongo = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return mongo;
	}

	/**
	 * @return DataStore criada
	 */
	public Datastore getDataStore() {
		morphia = new Morphia();
		return morphia.createDatastore(getMongo(), DATABASE);
	}
}
