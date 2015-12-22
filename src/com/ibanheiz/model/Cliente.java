package com.ibanheiz.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@XmlType(name = "Cliente", propOrder = { "id", "nome", "genero", "idade", "email" })
@XmlRootElement
@Entity("clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1163352535446803731L;

	@Id
	private ObjectId id;
	private String nome;
	private String genero;
	private String idade;
	private String email;

	public String getId() {
		return id.toString();
	}

	public void setId(String id) {
		this.id = new ObjectId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
