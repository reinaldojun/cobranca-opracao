package com.trusthub.cobranca.application.repository.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.repository.GenericJdbcTemplate;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoTitulosDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoTitulosEntity;

/**
 * Responsavel por operacoes com titulos da TRUST . 
 * @author jose.viana
 */
@Repository
public class AtendimentoTitulosRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar de titulos
	 * @param idAtendimento identificador do atendimento
	 * @param tipoArquivo C - Cobranca e J - Juridico
	 * @return List<AtendimentoTitulosEntity> lista atendimentos
	 */
	public List<AtendimentoTitulosEntity> consultarTitulos(Long idAtendimento, String tipoArquivo) {
		List<AtendimentoTitulosEntity> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idAtendimento", idAtendimento);
			parametro.addValue("tipoArquivo", tipoArquivo);
			retorno = genericJdbcTemplate.queryForSQLName("consultar_titulos_cobranca", parametro, BeanPropertyRowMapper.newInstance(AtendimentoTitulosEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ATENDIMENTO_TITULOS)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Inserir atendimento titulo
	 * @param atendimentoTitulo objeto com identificador de titulo e atendimento
	 */
	public void inserirAtendimentoTitulo(AtendimentoTitulosEntity atendimentoTitulo) {
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("id", atendimentoTitulo.getId());
			parametro.addValue("idTitulo", atendimentoTitulo.getIdTitulo());
			parametro.addValue("tipoArquivo", atendimentoTitulo.getTipoArquivo());
			int returnSql =  genericJdbcTemplate.updateForSQLName("inserir_atendimento_titulo", parametro);
			if (returnSql != 1) {
				throw new AtendimentoCobrancaRepositoryException(Mensagens.REPOSITORY_INSERIR_ATENDIMENTO_TITULOS, CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY);
			}
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_INSERIR_ATENDIMENTO_TITULOS)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
	}
	
	
	
	/**
	 * Faz a contagem de atendimentos de titulos por cobranca e juridico
	 * @param idsTitulos
	 * @return
	 */
	public List<AtendimentoTitulosDTO> quantidadeAtendimentos(List<Integer> idsTitulos) {
		List<AtendimentoTitulosDTO> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idsTitulos", idsTitulos);
			retorno = genericJdbcTemplate.queryForSQLName("consultar_quantidade_atendimentos", parametro, BeanPropertyRowMapper.newInstance(AtendimentoTitulosDTO.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_QUANTIDADE_ATENDIMENTOS)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}

	
}
