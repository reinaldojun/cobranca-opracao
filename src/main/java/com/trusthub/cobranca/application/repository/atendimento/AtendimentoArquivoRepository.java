package com.trusthub.cobranca.application.repository.atendimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.util.Constantes;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.repository.GenericJdbcTemplate;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoArquivoDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoArquivoEntity;

/**
 * responsavel por operacoes de atendimento Cedente, Sacado e arquivos da TRUST . 
 * @author jose.viana
 */
@Repository
public class AtendimentoArquivoRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar dados do arquivo por cedente e sacado
	 * @param idCedente - Cnpj / cpf do cliente
	 * @param idSacado - Cnpj / cpf do cliente
	 * @param idAtendimento - identificador do atendimento
	 * @param tipoArquivo - Se e C - Cobrança ou J - Juridico
	 * @return List<AtendimentoArquivoDTO> - retorna atendimentos e arquivos dos mesmos
	 */
	public List<AtendimentoArquivoDTO> consultarDadosArquivoPorCedenteSacado(String idCedente, String idSacado, Long idAtendimento, String tipoArquivo) {
		List<AtendimentoArquivoDTO> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idCedente", idCedente);
			parametro.addValue("idSacado", idSacado);
			parametro.addValue("idAtendimento", idAtendimento);
			parametro.addValue("tipoArquivo", tipoArquivo);
			if(tipoArquivo.equals(Constantes.COBRANCA)) {
				retorno = genericJdbcTemplate.queryForSQLName("consultar_dados_arquivo_cedente_sacado_cobranca", parametro, BeanPropertyRowMapper.newInstance(AtendimentoArquivoDTO.class));
			}else if(tipoArquivo.equals(Constantes.JURIDICO)) {
				retorno = genericJdbcTemplate.queryForSQLName("consultar_dados_arquivo_cedente_sacado_juridico", parametro, BeanPropertyRowMapper.newInstance(AtendimentoArquivoDTO.class));	
			}
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ARQUIVO_CEDENTE_SACADO)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Inclui dados de atendimento e identificador do arquivo incluido na base
	 * @param atendimentoArquivo  DTO com dados de atendimento e arquivo
	 */
	public void inserirAtendimentoArquivo(AtendimentoArquivoEntity atendimentoArquivo) {
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("id", atendimentoArquivo.getId());
			parametro.addValue("idArquivo", atendimentoArquivo.getIdArquivo());
			parametro.addValue("tipoArquivo", atendimentoArquivo.getTipoArquivo());
			parametro.addValue("idUsuario", atendimentoArquivo.getIdUsuario());
			parametro.addValue("dataInclusao", new Date());
			parametro.addValue("dataExclusao", null);
			int returnSql =  genericJdbcTemplate.updateForSQLName("inserir_atendimento_arquivo", parametro);
			if (returnSql != 1) {
				throw new AtendimentoCobrancaRepositoryException(Mensagens.REPOSITORY_INSERIR_ATENDIMENTO_ARQUIVO_CEDENTE_SACADO, CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY);
			}
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_INSERIR_ATENDIMENTO_ARQUIVO_CEDENTE_SACADO)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
	}
	
}
