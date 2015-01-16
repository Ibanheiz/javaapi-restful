package com.ibanheiz.utils;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil implements Serializable {
	private static final long serialVersionUID = -8233504751160790161L;
	
	private Logger logger;
	
	/**
	 * @param classe Class utilizada pelo logger
	 */
	public LoggerUtil(Class<?> classe) {
		logger = Logger.getLogger(classe.getSimpleName());
	}
	
	/**
	 * Log de informação
	 * @author Nicolas Ibanheiz
	 * @param mensagem
	 */
	public void info(String mensagem) {
		logger.setLevel(Level.INFO);
		logger.info(mensagem);
	}
	
	/**
	 * Log de alerta
	 * @author Nicolas Ibanheiz
	 * @param mensagem
	 */
	public void warnnig(String mensagem) {
		logger.setLevel(Level.WARNING);
		logger.warning(mensagem);		
	}
	
	/**
	 * Mensagem de erro fatal
	 * @author Nicolas Ibanheiz
	 * @param mensagem
	 */
	public void error(String mensagem) {
		logger.setLevel(Level.SEVERE);
		logger.severe(mensagem);		
	}
}
