package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AvisoAtendimentoService;
import com.trusthub.cobranca.domain.dto.atendimento.aviso.AvisoAtendimentoDTO;

/**
 * Classe com regras de aviso atendimento
 * @author jose.viana
 *
 */
@Component
public class AvisoAtendimentoBusiness {

	@Autowired
	private AvisoAtendimentoService avisoAtendimentoService;
	
	/**
	 * Consultar aviso atendimento cobranca/juridico
	 * @param idUsuario
	 * @return List<AvisoAtendimentoDTO> - Lista com aviso atendimento
	 */
	public List<AvisoAtendimentoDTO> consultarAvisoAtendimento(String idUsuario) {
		return avisoAtendimentoService.consultarAvisoAtendimento(idUsuario);
	}
	
	/**
	 * Desativar alerta cobranca
	 * @param idUsuario
	 * @return
	 */
	public int desativarAlertaCobranca(String idAtendimento) {
		return avisoAtendimentoService.desativarAlertaCobranca(idAtendimento);
	}
	
	/**
	 * Desativar alerta juridico
	 * @param idUsuario
	 * @return
	 */
	public int desativarAlertaJuridico(String idAtendimento) {
		return avisoAtendimentoService.desativarAlertaJuridico(idAtendimento);
	}

}
