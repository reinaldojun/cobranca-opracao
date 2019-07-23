package com.trusthub.cobranca.application.repository.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.trusthub.cobranca.application.exceptions.AtendimentoCobrancaRepositoryException;
import com.trusthub.cobranca.application.util.Mensagens;
import com.trusthub.cobranca.configuration.repository.GenericJdbcTemplate;
import com.trusthub.cobranca.configuration.validation.CobrancaOperacaoError;
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoStatusJuridicoEntity;

import comum.jdbc.util.MapParameterSource;
/**
 * Status de atendimento juridico da TRUST . 
 * @author jose.viana
 */
@Repository
public class AtendimentoStatusJuridicoRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar status atendimento juridico
	 * @return List<AtendimentoStatusJuridicoEntity> - todos atendimentos status juridico
	 */
	public List<AtendimentoStatusJuridicoEntity> consultarStatusAtendimentoJuridico() {
		List<AtendimentoStatusJuridicoEntity> retorno = new ArrayList<>();
		try {
			retorno = genericJdbcTemplate.queryForSQLName("buscar_status_atendimento_juridico", BeanPropertyRowMapper.newInstance(AtendimentoStatusJuridicoEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Consultar status atendimento juridico por id.
	 * @param idStatusJuridico identifica o objeto status juridico
	 * @return AtendimentoStatusJuridicoEntity 
	 */
	public AtendimentoStatusJuridicoEntity consultarStatusAtendimentoJuridicoPorId(Long idStatusJuridico) {
		AtendimentoStatusJuridicoEntity retorno = new AtendimentoStatusJuridicoEntity();
		try {
			MapParameterSource parametro = new MapParameterSource();
			parametro.add("idStatusJuridico", idStatusJuridico);
			retorno = genericJdbcTemplate.queryForObjectForSQLName("buscar_status_atendimento_juridico_id", parametro, BeanPropertyRowMapper.newInstance(AtendimentoStatusJuridicoEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO_ID)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
}
