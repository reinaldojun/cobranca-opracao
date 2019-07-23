package com.trusthub.cobranca.application.cliente;

import org.springframework.http.HttpStatus;

import com.trusthub.cobranca.configuration.validation.generic.domain.TrustHubError;
import com.trusthub.cobranca.configuration.validation.generic.layers.TrustHubServiceException;

/**
 * Exception atendimento cobranca service 
 * @author alan.franco
 */
public class ClienteCobrancaServiceException extends TrustHubServiceException{

	private static final long serialVersionUID = 1L;

	public ClienteCobrancaServiceException(String msg, TrustHubError trustHubError, HttpStatus httpStatus,
			Throwable cause) {
		super(msg, trustHubError, httpStatus, cause);
	}

	public ClienteCobrancaServiceException(String msg, TrustHubError trustHubError, HttpStatus httpStatus) {
		super(msg, trustHubError, httpStatus);
	}

	public ClienteCobrancaServiceException(String msg, TrustHubError trustHubError, Throwable cause) {
		super(msg, trustHubError, cause);
	}

	public ClienteCobrancaServiceException(String msg, TrustHubError trustHubError) {
		super(msg, trustHubError);
	}

}
