package com.trusthub.cobranca.application.service.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.cliente.ClienteCobrancaRepositoryException;
import com.trusthub.cobranca.application.cliente.ClienteCobrancaServiceException;
import com.trusthub.cobranca.application.repository.cliente.ClienteRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.cliente.ClienteDTO;
import com.trusthub.cobranca.domain.entity.cliente.ClienteEntity;

/**
 * Classe service de cliente
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Consultar cliente documento
	 * @param documento -  CNPJ / CPF do cliente
	 * @return List<ClienteDTO>
	 */
	public List<ClienteDTO> consultarClienteDocumento(String documento) {
		List<ClienteDTO> listClienteDTO = new ArrayList<>();
		try {
			List<ClienteEntity> listaClienteEntity =  clienteRepository.consultarClienteDocumento(documento);
			listaClienteEntity.forEach(entity -> listClienteDTO.add(toDTO(entity)));
		}catch (ClienteCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new ClienteCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_CLIENTE)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listClienteDTO;
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return ClienteDTO
	 */
	public ClienteDTO toDTO(ClienteEntity entity){
		ClienteDTO dto = new ClienteDTO();
		BeanUtils.copyProperties(entity, dto); 
		return dto ;
	}
	
	/**
	 * Converte DTO para Entity 
	 * @param dto 
	 * @return ClienteEntity 
	 */
	public ClienteEntity toEntity(ClienteDTO dto){
		ClienteEntity entity = new ClienteEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
}
