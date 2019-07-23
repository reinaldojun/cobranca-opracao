package com.trusthub.cobranca.application.service.atendimento;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AtendimentoArquivoRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoArquivoDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoArquivoEntity;

/**
 * Classe service atendimento arquivo 
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoArquivoService {
	
	@Autowired
	private AtendimentoArquivoRepository atendimentoArquivoRepository;

	/**
	 * Inserir DTO de atendimento arquivo
	 * @param atendimentoArquivoDTO objeto com dados de atendimento e identificador de arquivo
	 */
	public void inserirAtendimentoArquivo(AtendimentoArquivoDTO atendimentoArquivoDTO) {
		try {
			atendimentoArquivoRepository.inserirAtendimentoArquivo(toEntity(atendimentoArquivoDTO));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			 throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_INSERIR_ATENDIMENTO_ARQUIVO)
					 .append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
	}
	
	/**
	 * Consultar dados arquivo por cedente e sacado
	 * @param idCedente CNPJ / CPF do cliente
	 * @param idSacado CNPJ / CPF do cliente
	 * @param idAtendimento identificador do atendimento
	 * @param tipoArquivo C- Cobranca / J - Juridico
	 * @return List<AtendimentoArquivoDTO> lista arquivos por atendimento
	 */
	public List<AtendimentoArquivoDTO> consultarDadosArquivoPorCedenteSacado(String idCedente, String idSacado, Long idAtendimento, String tipoArquivo) {
		try {
			return atendimentoArquivoRepository.consultarDadosArquivoPorCedenteSacado(idCedente, idSacado, idAtendimento, tipoArquivo);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ARQUIVO_CEDENTE_SACADO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
	}
	
	/**
	 * Converte DTO para Entity 
	 * @param dto 
	 * @return AtendimentoArquivoEntity 
	 */
	public AtendimentoArquivoEntity toEntity(AtendimentoArquivoDTO dto) {
		AtendimentoArquivoEntity entity = new AtendimentoArquivoEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return AtendimentoArquivoDTO
	 */
	public AtendimentoArquivoDTO toDTO(AtendimentoArquivoEntity entity) {
		AtendimentoArquivoDTO dto = new AtendimentoArquivoDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
