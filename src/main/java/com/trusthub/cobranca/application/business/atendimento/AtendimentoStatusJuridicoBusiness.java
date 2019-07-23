package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AtendimentoStatusJuridicoService;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoStatusJuridicoDTO;

/**
 * Classe com regras atendimento status juridico
 * @author jose.viana
 *
 */
@Component
public class AtendimentoStatusJuridicoBusiness{
	
	@Autowired
	private AtendimentoStatusJuridicoService statusJuridicoService;

	/**
	 * Consultar status atendimento juridico
	 * @return List<AtendimentoStatusJuridicoDTO> - Lista com atendimento juridico
	 */
	public List<AtendimentoStatusJuridicoDTO> consultarStatusAtendimentoJuridico() {
		return statusJuridicoService.consultarStatusAtendimentoJuridico();
	}
	
	/**
	 * Consultar status atendimento juridico por id
	 * @param idStatusAtendimento
	 * @return AtendimentoStatusJuridicoDTO - Atendimento Juridico
	 */
	public AtendimentoStatusJuridicoDTO consultarStatusAtendimentoJuridicoPorId(Long idStatusAtendimento) {
		return statusJuridicoService.consultarStatusAtendimentoJuridicoPorId(idStatusAtendimento);
	}
	
}
