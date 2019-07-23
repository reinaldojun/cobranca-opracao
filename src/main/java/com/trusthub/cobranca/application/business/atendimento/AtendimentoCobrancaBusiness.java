package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AtendimentoCobrancaService;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoCobrancaDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;

/**
 * Classe com regras atendimento cobranca
 * @author jose.viana
 *
 */
@Component
public class AtendimentoCobrancaBusiness {

	@Autowired
	private AtendimentoCobrancaService atendimentoCobrancaService;
	
	/**
	 * Consultar atendimento cobranca
	 * @param idCedente
	 * @param idSacado
	 * @return List<AtendimentoCobrancaDTO> - Lista com atendimento cobranca
	 */
	public List<AtendimentoCobrancaDTO> consultarAtendimentoCobranca(String idCedente, String idSacado, Integer idTitulo) {
		return atendimentoCobrancaService.consultarAtendimentoCobranca(idCedente, idSacado, idTitulo);
	}

	/**
	 * Inserir atendimento cobranca
	 * @param atendimentoCobrancaDTO
	 * @return Long
	 */
	public Long inserirAtendimentoCobranca(AtendimentoCobrancaDTO atendimentoCobrancaDTO) {
		return atendimentoCobrancaService.inserirAtendimentoCobranca(atendimentoCobrancaDTO);
	}
	
	
	public List<AtendimentoCobrancaDTO> consultarAtendimentosCobranca(FiltroAtendimentoDTO filtroAtendimentoDTO) {
		return atendimentoCobrancaService.consultarAtendimentosCobranca(filtroAtendimentoDTO);
	}
}
