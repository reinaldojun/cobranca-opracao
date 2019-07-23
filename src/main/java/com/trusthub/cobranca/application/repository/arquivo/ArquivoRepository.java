package com.trusthub.cobranca.application.repository.arquivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.repository.GenericJdbcTemplate;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.entity.arquivo.ArquivoEntity;

/**
 * Responsavel por operacoes de arquivo da TRUST. 
 * @author jose.viana
 */
@Repository
public class ArquivoRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
    /**
     * Consultar dados do arquivo
     * @param idArquivo - Id do arquivo
     * @return ArquivoEntity - Dados do arquivo
     */
	public ArquivoEntity consultarArquivo(String idArquivo) {
		ArquivoEntity retorno = new ArquivoEntity();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idArquivo", idArquivo);
			retorno = genericJdbcTemplate.queryForObjectForSQLName("buscar_arquivo", parametro, BeanPropertyRowMapper.newInstance(ArquivoEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ARQUIVO)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
}
