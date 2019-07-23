package com.trusthub.cobranca.application.service.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AtendimentoCobrancaRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoCobrancaDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoCobrancaEntity;

/**
 * Classe service atendimento cobranca
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoCobrancaService {

	@Autowired
	private AtendimentoCobrancaRepository atendimentoCobrancaRepository;

	/**
	 * Consultar atendimentos da cobranca
	 * @param idCedente -  CNPJ / CPF do cliente
	 * @param idSacado - CNPJ / CPF do cliente
	 * @return List<AtendimentoCobrancaDTO>
	 */
	public List<AtendimentoCobrancaDTO> consultarAtendimentoCobranca(String idCedente, String idSacado, Integer idTitulo) {
		List<AtendimentoCobrancaDTO> listAtendimentoCobrancaDTO = new ArrayList<>();
		try {
			List<AtendimentoCobrancaEntity> listaAtendimentoCobrancaEntity =  atendimentoCobrancaRepository.consultarAtendimentoCobranca(idCedente, idSacado, idTitulo);
			listaAtendimentoCobrancaEntity.forEach(entity -> listAtendimentoCobrancaDTO.add(toDTO(entity)));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listAtendimentoCobrancaDTO;
	}
	
	/**
	 * Consultar atendimentos da cobranca
	 * @param filtroAtendimentoDTO (Filtrar dataInclusao inicial e final)
	 * @return List<AtendimentoCobrancaDTO>
	 */
	public List<AtendimentoCobrancaDTO> consultarAtendimentosCobranca(FiltroAtendimentoDTO filtroAtendimentoDTO) {
		List<AtendimentoCobrancaDTO> listAtendimentoCobrancaDTO = new ArrayList<>();
		try {
			List<AtendimentoCobrancaEntity> listaAtendimentoCobrancaEntity =  atendimentoCobrancaRepository.consultarAtendimentosCobranca(filtroAtendimentoDTO);
			listaAtendimentoCobrancaEntity.forEach(entity -> listAtendimentoCobrancaDTO.add(toDTO(entity)));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listAtendimentoCobrancaDTO;
	}
	
	/**
	 * Inserir atendimento para cobranca
	 * @param atendimentoCobrancaDTO dados do atendimento
	 * @return Long - Idenditificador da tabela atendimento_cobranca 
	 */
	public Long inserirAtendimentoCobranca(AtendimentoCobrancaDTO atendimentoCobrancaDTO) {
		Long id;
		try {
			id = atendimentoCobrancaRepository.inserirAtendimentoCobranca(toEntity(atendimentoCobrancaDTO));
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_INSERIR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return id;
	}
	
	/**
	 * Converte Entity para DTO
	 * @param entity
	 * @return AtendimentoCobrancaDTO
	 */
	public AtendimentoCobrancaDTO toDTO(AtendimentoCobrancaEntity entity){
		AtendimentoCobrancaDTO dto = new AtendimentoCobrancaDTO();
		BeanUtils.copyProperties(entity, dto); 
		return dto ;
	}
	
	/**
	 * Converte DTO para Entity 
	 * @param dto 
	 * @return AtendimentoCobrancaEntity 
	 */
	public AtendimentoCobrancaEntity toEntity(AtendimentoCobrancaDTO dto){
		AtendimentoCobrancaEntity entity = new AtendimentoCobrancaEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
}
