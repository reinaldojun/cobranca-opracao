package com.trusthub.cobranca.application.service.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AtendimentoStatusCobrancaRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoStatusCobrancaDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoStatusCobrancaEntity;

/**
 * Classe service atendimento status cobranca.
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoStatusCobrancaService {

	@Autowired
	private AtendimentoStatusCobrancaRepository statusCobrancaRepository;

	/**
	 * Consultar status do atendimento da cobraca
	 * @return List<AtendimentoStatusCobrancaDTO>
	 */
	public List<AtendimentoStatusCobrancaDTO> consultarStatusAtendimentoCobranca() {
		List<AtendimentoStatusCobrancaDTO> listaAtendimentoStatusCobrancaDTO = new ArrayList<>();
		try {
			List<AtendimentoStatusCobrancaEntity> listaAtendimentoStatusCobrancaEntity = statusCobrancaRepository.consultarStatusAtendimentoCobranca();
			listaAtendimentoStatusCobrancaEntity.forEach(entity -> {
				listaAtendimentoStatusCobrancaDTO.add(toDTO(entity));
			});
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}			
		return listaAtendimentoStatusCobrancaDTO;
	}
	
    /**
     * Consultar status atendimento cobranca por id
     * @param idStatusAtendimento - identificador do status
     * @return AtendimentoStatusCobrancaDTO
     */
	public AtendimentoStatusCobrancaDTO consultarStatusAtendimentoCobrancaPorId(Long idStatusAtendimento) {
		try {
			return toDTO(statusCobrancaRepository.consultarStatusAtendimentoCobrancaPorId(idStatusAtendimento));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA_ID)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}	
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return AtendimentoStatusCobrancaDTO
	 */
	public AtendimentoStatusCobrancaDTO toDTO(AtendimentoStatusCobrancaEntity entity){
		AtendimentoStatusCobrancaDTO dto = new AtendimentoStatusCobrancaDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
