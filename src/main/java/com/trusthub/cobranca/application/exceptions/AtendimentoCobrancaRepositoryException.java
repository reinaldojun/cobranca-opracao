package com.trusthub.cobranca.application.exceptions;

import org.springframework.http.HttpStatus;

import com.trusthub.cobranca.configuration.validation.generic.domain.TrustHubError;
import com.trusthub.cobranca.configuration.validation.generic.layers.TrustHubRepositoryException;

/**
 * Exception atendimento cobranca repository 
 * @author alan.franco
 */
public class AtendimentoCobrancaRepositoryException extends TrustHubRepositoryException{

	private static final long serialVersionUID = 1L;

	public AtendimentoCobrancaRepositoryException(String msg, TrustHubError trustHubError, HttpStatus httpStatus,
			Throwable cause) {
		super(msg, trustHubError, httpStatus, cause);
	}

	public AtendimentoCobrancaRepositoryException(String msg, TrustHubError trustHubError, HttpStatus httpStatus) {
		super(msg, trustHubError, httpStatus);
	}

	public AtendimentoCobrancaRepositoryException(String msg, TrustHubError trustHubError, Throwable cause) {
		super(msg, trustHubError, cause);
	}

	public AtendimentoCobrancaRepositoryException(String msg, TrustHubError trustHubError) {
		super(msg, trustHubError);
	}

}
