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
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoStatusCobrancaEntity;

import comum.jdbc.util.MapParameterSource;

/**
 * Status de atendimento cobranca da TRUST . 
 * @author jose.viana
 */
@Repository
public class AtendimentoStatusCobrancaRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar status atendimento cobranca
	 * @return List<AtendimentoStatusCobrancaEntity> - lista de status de atendimento da cobranca
	 */
	public List<AtendimentoStatusCobrancaEntity> consultarStatusAtendimentoCobranca() {
		List<AtendimentoStatusCobrancaEntity> retorno = new ArrayList<>();
		try {
			retorno = genericJdbcTemplate.queryForSQLName("buscar_status_atendimento_cobranca", BeanPropertyRowMapper.newInstance(AtendimentoStatusCobrancaEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}

	/**
	 * Consultar status atendimento cobranca por id.
	 * @param idStatusAtendimento identifica o status do atendimento
	 * @return AtendimentoStatusCobrancaEntity - o objeto AtendimentoStatusCobrancaEntity
	 */
	public AtendimentoStatusCobrancaEntity consultarStatusAtendimentoCobrancaPorId(Long idStatusAtendimento) {
		AtendimentoStatusCobrancaEntity retorno = new AtendimentoStatusCobrancaEntity();
		try {
			MapParameterSource parametro = new MapParameterSource();
			parametro.add("idStatusAtendimento", idStatusAtendimento);
			retorno = genericJdbcTemplate.queryForObjectForSQLName("buscar_status_atendimento_cobranca_id", parametro, BeanPropertyRowMapper.newInstance(AtendimentoStatusCobrancaEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA_ID)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}			
		return retorno;
	}
	
}
