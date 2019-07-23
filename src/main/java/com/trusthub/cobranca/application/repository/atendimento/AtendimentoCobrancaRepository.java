package com.trusthub.cobranca.application.repository.atendimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.repository.GenericJdbcTemplate;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoCobrancaEntity;

/**
 * Responsavel por operacoes de atendimento do cobranca. 
 * @author jose.viana
 */
@Repository
public class AtendimentoCobrancaRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar atendimento cobranca
	 * @param idCedente CPF/CNPJ do cliente
	 * @param idSacado CPF/CNPJ do cliente
	 * @return List<AtendimentoCobrancaEntity> lista de atendimentos da cobranca
	 */
	public List<AtendimentoCobrancaEntity> consultarAtendimentoCobranca(String idCedente, String idSacado, Integer idTitulo){
		List<AtendimentoCobrancaEntity> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idCedente", idCedente);
			parametro.addValue("idSacado", idSacado);
			parametro.addValue("idTitulo", idTitulo);
			retorno = genericJdbcTemplate.queryForSQLName(idTitulo == null ? "consultar_atendimento_cobranca" : "consultar_atendimento_cobranca_titulo", parametro, BeanPropertyRowMapper.newInstance(AtendimentoCobrancaEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Consultar atendimento cobranca
	 * @param filtro (Filtrar dataInicial e dataFinal)
	 * @return List<AtendimentoCobrancaEntity> lista de atendimentos da cobranca
	 */
	public List<AtendimentoCobrancaEntity> consultarAtendimentosCobranca(FiltroAtendimentoDTO filtro){
		List<AtendimentoCobrancaEntity> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("dataInicial", filtro.getDataInicial());
			parametro.addValue("dataFinal", filtro.getDataFinal());
			retorno = genericJdbcTemplate.queryForSQLName("consultar_atendimento_cobranca_filtro", parametro, BeanPropertyRowMapper.newInstance(AtendimentoCobrancaEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Inserir atendimentos do cobranca
	 * @param atendimentoCobranca objeto com dados do atendimento
	 * @return Long - Identificador do atendimento inserido na tabela
	 */
	public Long inserirAtendimentoCobranca(AtendimentoCobrancaEntity atendimentoCobranca) {
		Long id = 0L;
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idSacado", atendimentoCobranca.getIdSacado());
			parametro.addValue("idCedente", atendimentoCobranca.getIdCedente());
			parametro.addValue("idSacadoSRM", atendimentoCobranca.getIdSacadoSRM());
			parametro.addValue("idCedenteSRM", atendimentoCobranca.getIdCedenteSRM());
			parametro.addValue("idStatusAtendimento", atendimentoCobranca.getIdStatusAtendimento());
			parametro.addValue("descricao", atendimentoCobranca.getDescricao());
			parametro.addValue("dataRetorno", atendimentoCobranca.getDataRetorno());
			parametro.addValue("dataPrevisao", atendimentoCobranca.getDataPrevisao());
			parametro.addValue("idUsuario", atendimentoCobranca.getIdUsuario());
			parametro.addValue("dataInclusao", new Date());
			parametro.addValue("dataExclusao", null);
			int returnSql =  genericJdbcTemplate.updateForSQLName("inserir_atendimento_cobranca", parametro, keyHolder);
			if (returnSql != 1 && keyHolder.getKey() == null) {
				throw new AtendimentoCobrancaRepositoryException("Erro ao inserir atendimento cobranca " , CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY);
			}else {
				id = keyHolder.getKey().longValue();
			}
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_INSERIR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}			
		return id;
	}
	
}
