package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AtendimentoAuditoriaService;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoAuditoriaDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;

/**
 * Classe com regras atendimento cobranca/juridico
 * @author jose.viana
 *
 */
@Component
public class AtendimentoAuditoriaBusiness {

	@Autowired
	private AtendimentoAuditoriaService atendimentoAuditoriaService;
	
	public List<AtendimentoAuditoriaDTO> consultarAtendimentoCobrancaAuditoria(FiltroAtendimentoDTO filtro) {
		return atendimentoAuditoriaService.consultarAtendimentoCobranca(filtro);
	}

	
	public List<AtendimentoAuditoriaDTO> consultarAtendimentoJuridicoAuditoria(FiltroAtendimentoDTO filtro) {
		return atendimentoAuditoriaService.consultarAtendimentoJuridico(filtro);
	}
	
}
