package com.trusthub.cobranca.application.business.arquivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trusthub.cobranca.application.service.arquivo.ArquivoService;
import com.trusthub.cobranca.domain.dto.arquivo.ArquivoDTO;

/**
 * Classe referente a regras de arquivos.
 * @author jose.viana
 *
 */
@Component
public class ArquivoBusiness{
	
	@Autowired
	private ArquivoService arquivoService;

	/**
	 * Consultar Arquivos
	 * @param idArquivo
	 * @return
	 */
	public ArquivoDTO consultarArquivo(String idArquivo) {
		return arquivoService.consultarArquivo(idArquivo);
	}
}
