package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AtendimentoJuridicoService;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoJuridicoDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;

/**
 * Classe com regras de atendimento juridico
 * @author jose.viana
 *
 */
@Component
public class AtendimentoJuridicoBusiness{
	
	@Autowired
	private AtendimentoJuridicoService atendimentoJuridicoService;

	/**
	 * Consultar atendimento juridico
	 * @param idCedente
	 * @param idSacado
	 * @return List<AtendimentoJuridicoDTO> - Lista de atendimento juridico
	 */
	public List<AtendimentoJuridicoDTO> consultarAtendimentoJuridico(String idCedente, String idSacado, Integer idTitulo) {
		return atendimentoJuridicoService.consultarAtendimentoJuridico(idCedente, idSacado, idTitulo);
	}
	
	public List<AtendimentoJuridicoDTO> consultarAtendimentosJuridico(FiltroAtendimentoDTO filtroAtendimentoDTO) {
		return atendimentoJuridicoService.consultarAtendimentosJuridico(filtroAtendimentoDTO);
	}
	
	
	/**
	 * Inserir atendimento juridico
	 * @param atendimentoJuridicoDTO
	 * @return Long
	 */
	public Long inserirAtendimentoJuridico(AtendimentoJuridicoDTO atendimentoJuridicoDTO) {
		return atendimentoJuridicoService.inserirAtendimentoJuridico(atendimentoJuridicoDTO);
	}


}
