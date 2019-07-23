package com.trusthub.cobranca.application.service.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AtendimentoAuditoriaRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoAuditoriaDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;

/**
 * Classe service atendimento cobranca/juridico
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AtendimentoAuditoriaService {

	@Autowired
	private AtendimentoAuditoriaRepository atendimentoAuditoriaRepository;

	/**
	 * consultarAtendimentoCobrancaAuditoria
	 * @param filtro dataInicial e dataFinal
	 * @return List<AtendimentoAuditoriaDTO>
	 */
	public List<AtendimentoAuditoriaDTO> consultarAtendimentoCobranca(FiltroAtendimentoDTO filtro) {
		List<AtendimentoAuditoriaDTO> listAtendimentoAuditoriaDTO = new ArrayList<>();
		try {
			listAtendimentoAuditoriaDTO = atendimentoAuditoriaRepository.consultarAtendimentoCobrancaAuditoria(filtro);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listAtendimentoAuditoriaDTO;
	}
	
	/**
	 * consultarAtendimentoJuridicoAuditoria
	 * @param filtro dataInicial e dataFinal
	 * @return List<AtendimentoAuditoriaDTO>
	 */
	public List<AtendimentoAuditoriaDTO> consultarAtendimentoJuridico(FiltroAtendimentoDTO filtro) {
		List<AtendimentoAuditoriaDTO> listAtendimentoAuditoriaDTO = new ArrayList<>();
		try {
			listAtendimentoAuditoriaDTO = atendimentoAuditoriaRepository.consultarAtendimentoJuridicoAuditoria(filtro);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listAtendimentoAuditoriaDTO;
	}
	
}
