package com.trusthub.cobranca.application.service.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AtendimentoJuridicoRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoJuridicoDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoJuridicoEntity;

/**
 * Classe service atendimento juridico.
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoJuridicoService {
	
	@Autowired
	private AtendimentoJuridicoRepository atendimentoJuridicoRepository;
	
	/**
	 * Consultar atendimentos do juridico
	 * @param idCedente CNPJ / CPF do cliente
	 * @param idSacado CNPJ / CPF do cliente
	 * @return List<AtendimentoJuridicoDTO>
	 */
	public List<AtendimentoJuridicoDTO> consultarAtendimentoJuridico(String idCedente, String idSacado, Integer idTitulo) {
		List<AtendimentoJuridicoDTO> listAtendimentoJuridicoDTO = new ArrayList<>();
		try {
			List<AtendimentoJuridicoEntity> listaAtendimentoJuridicoEntity =  atendimentoJuridicoRepository.consultarAtendimentoJuridico(idCedente, idSacado, idTitulo);
			listaAtendimentoJuridicoEntity.forEach(entity -> listAtendimentoJuridicoDTO.add(toDTO(entity)));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ATENDIMENTO_JURIDICO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listAtendimentoJuridicoDTO;
	}
	
	public List<AtendimentoJuridicoDTO> consultarAtendimentosJuridico(FiltroAtendimentoDTO filtroAtendimentoDTO) {
		List<AtendimentoJuridicoDTO> listAtendimentoJuridicoDTO = new ArrayList<>();
		try {
			List<AtendimentoJuridicoEntity> listaAtendimentoJuridicoEntity =  atendimentoJuridicoRepository.consultarAtendimentosJuridico(filtroAtendimentoDTO);
			listaAtendimentoJuridicoEntity.forEach(entity -> listAtendimentoJuridicoDTO.add(toDTO(entity)));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ATENDIMENTO_JURIDICO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listAtendimentoJuridicoDTO;
	}

	/**
	 * Inserir atendimento do juridico
	 * @param atendimentoJuridicoDTO
	 * @return Long - Identificador do atendimento para o juridico
	 */
	public Long inserirAtendimentoJuridico(AtendimentoJuridicoDTO atendimentoJuridicoDTO) {
		Long id;
		try {
			AtendimentoJuridicoEntity atendimentoJuridicoEntity = toEntity(atendimentoJuridicoDTO);
			id = atendimentoJuridicoRepository.inserirAtendimentoJuridico(atendimentoJuridicoEntity);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_INSERIR_ATENDIMENTO_JURIDICO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return AtendimentoJuridicoDTO
	 */
	public AtendimentoJuridicoDTO toDTO(AtendimentoJuridicoEntity entity){
		AtendimentoJuridicoDTO dto = new AtendimentoJuridicoDTO();
		BeanUtils.copyProperties(entity, dto); 
		return dto ;
	}
	
	/**
	 * Converte DTO para Entity 
	 * @param dto 
	 * @return AtendimentoJuridicoEntity 
	 */
	public AtendimentoJuridicoEntity toEntity(AtendimentoJuridicoDTO dto){
		AtendimentoJuridicoEntity entity = new AtendimentoJuridicoEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
}
