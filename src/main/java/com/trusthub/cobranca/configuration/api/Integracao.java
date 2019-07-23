package com.trusthub.cobranca.configuration.api;

import org.springframework.beans.factory.annotation.Value;

/**
 * Interface que fica o contexto e uri das aplicacoes acessadas 
 * @author alan.franco
 */
public class Integracao {
	
	
	@Value("${app.cobranca.operacao.cobranca.acesso.contexto}")
	public String CONTEXTO_INTEGRACAO_COBRANCA_ACESSO;
	
	@Value("${app.cobranca.operacao.cobranca.acesso.uri}")
	public String INTEGRACAO_COBRANCA_ACESSO;
	
}
