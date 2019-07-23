package com.trusthub.cobranca.application.cliente;

import org.springframework.http.HttpStatus;

import com.trusthub.cobranca.configuration.validation.generic.domain.TrustHubError;
import com.trusthub.cobranca.configuration.validation.generic.layers.TrustHubRepositoryException;

/**
 * Exception atendimento cobranca repository 
 * @author alan.franco
 */
public class ClienteCobrancaRepositoryException extends TrustHubRepositoryException{

	private static final long serialVersionUID = 1L;

	public ClienteCobrancaRepositoryException(String msg, TrustHubError trustHubError, HttpStatus httpStatus,
			Throwable cause) {
		super(msg, trustHubError, httpStatus, cause);
	}

	public ClienteCobrancaRepositoryException(String msg, TrustHubError trustHubError, HttpStatus httpStatus) {
		super(msg, trustHubError, httpStatus);
	}

	public ClienteCobrancaRepositoryException(String msg, TrustHubError trustHubError, Throwable cause) {
		super(msg, trustHubError, cause);
	}

	public ClienteCobrancaRepositoryException(String msg, TrustHubError trustHubError) {
		super(msg, trustHubError);
	}

}
