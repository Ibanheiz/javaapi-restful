package com.ibanheiz.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@XmlType(name = "Cliente", propOrder = { "id", "razaoSocial", "nomeFantasia", "cnpj", "cpf" })
@XmlRootElement
@Entity("clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1163352535446803731L;

	@Id
	private ObjectId id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String cpf;

	/**
	 * @return the id
	 */
	public String getId() {
		return id.toString();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = new ObjectId(id);
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * @param nomeFantasia the nomeFantasia to set
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
