package com.trusthub.cobranca.application.business.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.atendimento.AtendimentoArquivoService;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoArquivoDTO;

/**
 * Classe com regras atendimento arquivo.
 * @author jose.viana
 *
 */
@Component
public class AtendimentoArquivoBusiness{
	
	@Autowired
	private AtendimentoArquivoService atendimentoArquivoService;

	/**
	 * Inserir atendimento arquivo
	 * @param atendimentoArquivoDTO
	 */
	public void inserirAtendimentoArquivo(AtendimentoArquivoDTO atendimentoArquivoDTO) {
		atendimentoArquivoService.inserirAtendimentoArquivo(atendimentoArquivoDTO);
	}
	
	/**
	 * Consultar dados dos arquivos por cedente e sacado
	 * @param idCedente
	 * @param idSacado
	 * @param idAtendimento
	 * @param tipoArquivo
	 * @return List<AtendimentoArquivoDTO> - Lista de arquivos atendimento
	 */
	public List<AtendimentoArquivoDTO> consultarDadosArquivoPorCedenteSacado(String idCedente, String idSacado, Long idAtendimento, String tipoArquivo) {
		return atendimentoArquivoService.consultarDadosArquivoPorCedenteSacado(idCedente, idSacado, idAtendimento, tipoArquivo);
	}
}
