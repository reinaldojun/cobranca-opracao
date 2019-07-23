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
import com.trusthub.cobranca.domain.dto.atendimento.aviso.AvisoAtendimentoDTO;

/**
 * Responsavel por operacoes de aviso de atendimento. 
 * @author jose.viana
 */
@Repository
public class AvisoAtendimentoRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar aviso de atendimentoa
	 * @param idUsuario identificador do usuario
	 * @return List<AvisoAtendimentoDTO> lista de avisos de atendimentos
	 */
	public List<AvisoAtendimentoDTO> consultarAvisoAtendimento(String idUsuario){
		List<AvisoAtendimentoDTO> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idUsuario", idUsuario);
			retorno = genericJdbcTemplate.queryForSQLName( "buscar_aviso_atendimento" , parametro, BeanPropertyRowMapper.newInstance(AvisoAtendimentoDTO.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_AVISO_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Desativar alerta cobranca
	 * @param idUsuario
	 * @return
	 */
	public int desativarAlertaCobranca(String idAtendimento){
		Integer retorno;
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idAtendimento", idAtendimento);
			retorno = genericJdbcTemplate.updateForSQLName( "desativar_alerta_cobranca" , parametro);
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_DESATIVAR_ALERTA_COBRANCA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Desativar alerta juridico
	 * @param idUsuario
	 * @return
	 */
	public int desativarAlertaJuridico(String idAtendimento){
		Integer retorno;
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idAtendimento", idAtendimento);
			retorno = genericJdbcTemplate.updateForSQLName( "desativar_alerta_juridico" , parametro);
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_DESATIVAR_ALERTA_JURIDICO)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
		
}
