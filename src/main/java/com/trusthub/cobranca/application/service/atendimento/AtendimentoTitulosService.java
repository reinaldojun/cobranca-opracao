package com.trusthub.cobranca.application.service.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AtendimentoTitulosRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoTitulosDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoTitulosEntity;

/**
 * Classe service de atendimento titulo.
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoTitulosService {
	
	@Autowired
	private AtendimentoTitulosRepository atendimentoTitulosRepository;

	/**
	 * Inserir atendimento titulo por tipo de arquivo C - Cobranca e J - Juridico
	 * @param atendimentoTitulosDTO 
	 */
	public void inserirAtendimentoTitulo(AtendimentoTitulosDTO atendimentoTitulosDTO) {
		try {
			atendimentoTitulosRepository.inserirAtendimentoTitulo(toEntity(atendimentoTitulosDTO));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_INSERIR_ATENDIMENTO_TITULO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
	}
	
	/**
	 * Consultar titulos
	 * @param idAtendimento - identificador de atendimento
	 * @param tipoArquivo - tipo de arquivo C - Cobranca  / J - Juridico
	 * @return List<AtendimentoTitulosDTO>
	 */
	public List<AtendimentoTitulosDTO> consultarTitulos(Long idAtendimento, String tipoArquivo) {
		List<AtendimentoTitulosDTO> listaAtendimentoTitulosDTOs = new ArrayList<>();
		
		try {
			List<AtendimentoTitulosEntity> listaAtendimentoEntity = atendimentoTitulosRepository.consultarTitulos(idAtendimento, tipoArquivo);
			listaAtendimentoEntity.forEach(entity -> listaAtendimentoTitulosDTOs.add(toDTO(entity)));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			 throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_TITULOS)
					 .append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listaAtendimentoTitulosDTOs;
	}
	
	
	/**
	 * Faz a contagem de atendimentos de titulos por cobranca e juridico
	 * @param idsTitulos
	 * @return
	 */
	public List<AtendimentoTitulosDTO> quantidadeAtendimentos(List<Integer> idsTitulos) {
		List<AtendimentoTitulosDTO> listaAtendimentoTitulosDTOs = new ArrayList<>();
		try {
			listaAtendimentoTitulosDTOs = atendimentoTitulosRepository.quantidadeAtendimentos(idsTitulos);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			 throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_QUANTIDADE_ATENDIMENTOS)
					 .append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listaAtendimentoTitulosDTOs;
	}

	
	/**
	 * Converte DTO para Entity 
	 * @param dto 
	 * @return AtendimentoTitulosEntity 
	 */
	public AtendimentoTitulosEntity toEntity(AtendimentoTitulosDTO dto) {
		AtendimentoTitulosEntity entity = new AtendimentoTitulosEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return AtendimentoTitulosDTO
	 */
	public AtendimentoTitulosDTO toDTO(AtendimentoTitulosEntity entity) {
		AtendimentoTitulosDTO dto = new AtendimentoTitulosDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
