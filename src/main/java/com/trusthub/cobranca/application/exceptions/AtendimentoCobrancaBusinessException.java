package com.trusthub.cobranca.application.exceptions;

import org.springframework.http.HttpStatus;

import com.trusthub.cobranca.configuration.validation.generic.domain.TrustHubError;
import com.trusthub.cobranca.configuration.validation.generic.layers.TrustHubBusinessException;

/**
 * Exception atendimento cobranca business 
 * @author alan.franco
 */
public class AtendimentoCobrancaBusinessException extends TrustHubBusinessException{

	private static final long serialVersionUID = 1L;

	public AtendimentoCobrancaBusinessException(String msg, TrustHubError trustHubError, HttpStatus httpStatus,
			Throwable cause) {
		super(msg, trustHubError, httpStatus, cause);
	}

	public AtendimentoCobrancaBusinessException(String msg, TrustHubError trustHubError, HttpStatus httpStatus) {
		super(msg, trustHubError, httpStatus);
	}

	public AtendimentoCobrancaBusinessException(String msg, TrustHubError trustHubError, Throwable cause) {
		super(msg, trustHubError, cause);
	}

	public AtendimentoCobrancaBusinessException(String msg, TrustHubError trustHubError) {
		super(msg, trustHubError);
	}

}
