package com.trusthub.cobranca.configuration.validation.generic.layers;

import org.springframework.http.HttpStatus;

import com.trusthub.cobranca.configuration.validation.generic.TrustHubException;
import com.trusthub.cobranca.configuration.validation.generic.domain.TrustHubError;

/**
 * Exception that will occur in internal integration 
 * @author alan.franco
 */
public class TrustHubExternalIntegrationException extends TrustHubException {

	private static final long serialVersionUID = 1L;

	public TrustHubExternalIntegrationException(String msg, TrustHubError trustHubError) {
		super(msg, trustHubError);
	}

	public TrustHubExternalIntegrationException(String msg, TrustHubError trustHubError, Throwable cause) {
		super(msg, trustHubError, cause);
	}

	public TrustHubExternalIntegrationException(String msg, TrustHubError trustHubError, HttpStatus httpStatus) {
		super(msg, trustHubError, httpStatus);
	}

	public TrustHubExternalIntegrationException(String msg, TrustHubError trustHubError, HttpStatus httpStatus, Throwable cause) {
		super(msg, trustHubError, httpStatus, cause);
	}

}
