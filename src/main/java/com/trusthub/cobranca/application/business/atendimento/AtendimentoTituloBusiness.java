package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AtendimentoTitulosService;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoTitulosDTO;

/**
 * Classe com regras atendimento titulos
 * @author jose.viana
 *
 */
@Component
public class AtendimentoTituloBusiness{
	
	@Autowired
	private AtendimentoTitulosService atendimentoTitulosService;

	/**
	 * Inserir atendimento titulo
	 * @param atendimentoTitulosDTO
	 */
	public void inserirAtendimentoTitulo(AtendimentoTitulosDTO atendimentoTitulosDTO) {
		atendimentoTitulosService.inserirAtendimentoTitulo(atendimentoTitulosDTO);
	}
	
	/**
	 * Consultar Titulos
	 * @param idAtendimento
	 * @param tipoArquivo
	 * @return List<AtendimentoTitulosDTO> - Lista com os titulos
	 */
	public List<AtendimentoTitulosDTO> consultarTitulos(Long idAtendimento, String tipoArquivo) {
		return atendimentoTitulosService.consultarTitulos(idAtendimento, tipoArquivo);
	}
	
	/**
	 * Faz a contagem de atendimentos de titulos por cobranca e juridico
	 * @param idsTitulos
	 * @return
	 */
	public List<AtendimentoTitulosDTO> quantidadeAtendimentos(List<Integer> idsTitulos) {
		return atendimentoTitulosService.quantidadeAtendimentos(idsTitulos);
	}

	
}
