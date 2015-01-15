package com.ibanheiz.utils.factory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.ibanheiz.utils.LoggerUtil;

public class LoggerProducer {
	
	@Produces
	public LoggerUtil criarLogger(InjectionPoint injectionPoint) {
		return new LoggerUtil(injectionPoint.getMember().getDeclaringClass());
	}
}
