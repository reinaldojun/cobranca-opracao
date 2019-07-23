package com.trusthub.cobranca.configuration.validation;

import com.trusthub.cobranca.configuration.validation.generic.domain.TrustHubError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CobrancaOperacaoError implements TrustHubError {

	ERROR_COBRANCA_BUSINESS(1000, "ERRO NA API (COBRANCA OPERACAO) NA CAMADA BUSINESS"), 
	ERROR_COBRANCA_SERVICE(2000, "ERRO NA API (COBRANCA OPERACAO) NA CAMADA SERVICE"),
	ERROR_COBRANCA_REPOSITORY(3000, "ERRO NA API (COBRANCA OPERACAO) NA CAMADA DE ACESSO A DADOS"),
	ERROR_COBRANCA_SECURITY(6, "ERRO NA API (COBRANCA OPERACAO) ERRO - COBRANCA ACESSO");
	 
	Integer errorCode;
	String errorDescription;

	@Override
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
