package com.trusthub.cobranca.application.service.arquivo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.arquivo.ArquivoRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.arquivo.ArquivoDTO;
import com.trusthub.cobranca.domain.entity.arquivo.ArquivoEntity;

/**
 * Classe de servico arquivo. 
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ArquivoService {
	
	@Autowired
	private ArquivoRepository arquivoRepository;

    /**
     * Consultar arquivo
     * @param idArquivo
     * @return ArquivoDTO
     */
	public ArquivoDTO consultarArquivo(String idArquivo) {
		ArquivoDTO arquivoDTO = new ArquivoDTO();
		try {
			ArquivoEntity arquivoEntity = arquivoRepository.consultarArquivo(idArquivo);
			arquivoDTO = toDTO(arquivoEntity);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ARQUIVO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return arquivoDTO;
	}
	
	/**
	 * Converte DTO para Entity 
	 * @param dto 
	 * @return AtendimentoArquivoEntity 
	 */
	public ArquivoEntity toEntity(ArquivoDTO dto) {
		ArquivoEntity entity = new ArquivoEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return AtendimentoArquivoDTO
	 */
	public ArquivoDTO toDTO(ArquivoEntity entity) {
		ArquivoDTO dto = new ArquivoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
