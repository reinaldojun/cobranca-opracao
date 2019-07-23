package com.trusthub.cobranca.security;

import org.springframework.http.HttpStatus;

import com.trusthub.cobranca.configuration.validation.generic.domain.TrustHubError;
import com.trusthub.cobranca.configuration.validation.generic.layers.TrustHubInternalIntegrationException;

/**
 *  Classe que representa exception de security
 *  @author alan.franco
 */
public class CobrancaOperacaoSecurityException extends TrustHubInternalIntegrationException {

	private static final long serialVersionUID = 1L;

	public CobrancaOperacaoSecurityException(String msg, TrustHubError trustHubError, HttpStatus httpStatus,
			Throwable cause) {
		super(msg, trustHubError, httpStatus, cause);
	}

	public CobrancaOperacaoSecurityException(String msg, TrustHubError trustHubError,
			HttpStatus httpStatus) {
		super(msg, trustHubError, httpStatus);
	}

	public CobrancaOperacaoSecurityException(String msg, TrustHubError trustHubError, Throwable cause) {
		super(msg, trustHubError, cause);
	}

	public CobrancaOperacaoSecurityException(String msg, TrustHubError trustHubError) {
		super(msg, trustHubError);
	}
	
}
