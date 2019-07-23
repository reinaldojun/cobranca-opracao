package com.trusthub.cobranca.application.business.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.cliente.ClienteService;
import com.trusthub.cobranca.domain.dto.cliente.ClienteDTO;

/**
 * Classe com regras de cliente
 * @author jose.viana
 *
 */
@Component
public class ClienteBusiness{

	@Autowired
	private ClienteService clienteService;
	
	/**
	 * Consultar Cliente Documento
	 * @param documento
	 * @return List<ClienteDTO> - Lista de Clientes
	 */
	public List<ClienteDTO> consultarClienteDocumento(String documento) {
		return clienteService.consultarClienteDocumento(documento);
	}

}
