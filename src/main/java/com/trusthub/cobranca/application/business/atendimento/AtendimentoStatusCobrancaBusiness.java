package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AtendimentoStatusCobrancaService;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoStatusCobrancaDTO;

/**
 * Classe com regras atendimento status cobranca
 * @author jose.viana
 *
 */
@Component
public class AtendimentoStatusCobrancaBusiness{
	
	@Autowired
	private AtendimentoStatusCobrancaService statusCobrancaService;

	/**
	 * Consultar status atendimento cobranca
	 * @return List<AtendimentoStatusCobrancaDTO> - Lista com os atendimentos de cobranca
	 */
	public List<AtendimentoStatusCobrancaDTO> consultarStatusAtendimentoCobranca() {
		return statusCobrancaService.consultarStatusAtendimentoCobranca();
	}
	
	/**
	 * Consultar status atendimento cobranca por id
	 * @param idStatusAtendimento
	 * @return AtendimentoStatusCobrancaDTO - atendimento cobranca
	 */
	public AtendimentoStatusCobrancaDTO consultarStatusAtendimentoCobrancaPorId(Long idStatusAtendimento) {
		return statusCobrancaService.consultarStatusAtendimentoCobrancaPorId(idStatusAtendimento);
	}
	
}
