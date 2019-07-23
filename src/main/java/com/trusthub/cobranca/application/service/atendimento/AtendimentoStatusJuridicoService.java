package com.trusthub.cobranca.application.service.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AtendimentoStatusJuridicoRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoStatusJuridicoDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoStatusJuridicoEntity;

/**
 * Classe service atendimento status juridico.
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoStatusJuridicoService {

	@Autowired
	private AtendimentoStatusJuridicoRepository statusJuridicoRepository;

	/**
	 * Consultar status do atendimento juridico
	 * @return List<AtendimentoStatusJuridicoDTO>
	 */
	public List<AtendimentoStatusJuridicoDTO> consultarStatusAtendimentoJuridico() {
		List<AtendimentoStatusJuridicoDTO> listaAtendimentoStatusJuridicoDTO = new ArrayList<>();
		try {
			List<AtendimentoStatusJuridicoEntity> listaAtendimentoStatusJuridicoEntity = statusJuridicoRepository.consultarStatusAtendimentoJuridico();
			listaAtendimentoStatusJuridicoEntity.forEach(entity -> {
				listaAtendimentoStatusJuridicoDTO.add(toDTO(entity));
			});
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}	
		return listaAtendimentoStatusJuridicoDTO;
	}
	
	/**
	 * Consultar status atendimento juridico por id.
	 * @param idStatusAtendimento - identificador do status do atendimento juridico
	 * @return AtendimentoStatusJuridicoDTO
	 */
	public AtendimentoStatusJuridicoDTO consultarStatusAtendimentoJuridicoPorId(Long idStatusAtendimento) {
		try {
			return toDTO(statusJuridicoRepository.consultarStatusAtendimentoJuridicoPorId(idStatusAtendimento));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO_ID)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}	
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return AtendimentoStatusJuridicoDTO
	 */
	public AtendimentoStatusJuridicoDTO toDTO(AtendimentoStatusJuridicoEntity entity){
		AtendimentoStatusJuridicoDTO dto = new AtendimentoStatusJuridicoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
