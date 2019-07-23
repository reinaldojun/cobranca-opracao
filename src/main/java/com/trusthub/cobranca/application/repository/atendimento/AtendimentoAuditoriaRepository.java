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
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoAuditoriaDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;

/**
 * Responsavel por operacoes de atendimento do cobranca/ juridico. 
 * @author jose.viana
 */
@Repository
public class AtendimentoAuditoriaRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	

	/**
	 * consultarAtendimentoCobrancaAuditoria
	 * @param filtro dataInicial e dataFinal
	 * @return List<AtendimentoAuditoriaDTO>
	 */
	public List<AtendimentoAuditoriaDTO> consultarAtendimentoCobrancaAuditoria(FiltroAtendimentoDTO filtro){
		List<AtendimentoAuditoriaDTO> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("dataInicial", filtro.getDataInicial());
			parametro.addValue("dataFinal", filtro.getDataFinal());
			retorno = genericJdbcTemplate.queryForSQLName("consultar_atendimento_cobranca_auditoria", parametro, BeanPropertyRowMapper.newInstance(AtendimentoAuditoriaDTO.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ATENDIMENTO_COBRANCA_AUDITORIA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * consultarAtendimentoJuridicoAuditoria
	 * @param filtro dataInicial e dataFinal
	 * @return List<AtendimentoAuditoriaDTO>
	 */
	public List<AtendimentoAuditoriaDTO> consultarAtendimentoJuridicoAuditoria(FiltroAtendimentoDTO filtro){
		List<AtendimentoAuditoriaDTO> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("dataInicial", filtro.getDataInicial());
			parametro.addValue("dataFinal", filtro.getDataFinal());
			retorno = genericJdbcTemplate.queryForSQLName("consultar_atendimento_juridico_auditoria", parametro, BeanPropertyRowMapper.newInstance(AtendimentoAuditoriaDTO.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ATENDIMENTO_JURIDICO_AUDITORIA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
}
