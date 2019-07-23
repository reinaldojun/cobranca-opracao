package com.trusthub.cobranca.application.service.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaServiceException;
import com.trusthub.cobranca.application.repository.atendimento.AvisoAtendimentoRepository;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.aviso.AvisoAtendimentoDTO;

/**
 * Classe service aviso atendimento
 * @author jose.viana
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AvisoAtendimentoService {

	@Autowired
	private AvisoAtendimentoRepository avisoAtendimentoRepository;

	/**
	 * Consultar aviso atendimentos cobranca/juridico
	 * @param idUsuario -  identificador de usuario
	 * @return List<AvisoAtendimentoDTO>
	 */
	public List<AvisoAtendimentoDTO> consultarAvisoAtendimento(String idUsuario) {
		List<AvisoAtendimentoDTO> listAvisoAtendimentoDTO  = new ArrayList<AvisoAtendimentoDTO>();
		try {
			listAvisoAtendimentoDTO =  avisoAtendimentoRepository.consultarAvisoAtendimento(idUsuario);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_CONSULTAR_AVISO_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return listAvisoAtendimentoDTO;
	}
	
	/**
	 * Desativar alerta cobranca
	 * @param idUsuario
	 * @return
	 */
	public int desativarAlertaCobranca(String idAtendimento) {
		int retorno  = 0;
		try {
			retorno =  avisoAtendimentoRepository.desativarAlertaCobranca(idAtendimento);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_DESATIVAR_ALERTAR_COBRANCA)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return retorno;
	}
	
	
	/**
	 * Desativar alerta juridico
	 * @param idUsuario
	 * @return
	 */
	public int desativarAlertaJuridico(String idAtendimento) {
		int retorno  = 0;
		try {
			retorno =  avisoAtendimentoRepository.desativarAlertaJuridico(idAtendimento);
		}catch (AtendimentoCobrancaRepositoryException e) {
			throw e;
		}catch (Exception e) {
			throw new AtendimentoCobrancaServiceException(new StringBuilder(Mensagens.SERVICE_DESATIVAR_ALERTAR_JURIDICO)
					.append(e.getMessage()).toString(),  CobrancaOperacaoError.ERROR_COBRANCA_SERVICE, e);
		}
		return retorno;
	}
	
	
}
