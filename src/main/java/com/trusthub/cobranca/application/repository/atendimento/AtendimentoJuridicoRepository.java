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
import com.trusthub.cobranca.domain.entity.atendimento.AtendimentoJuridicoEntity;

/**
 * responsavel por operacoes de atendimento juridico Cedente, Sacado da TRUST . 
 * @author jose.viana
 */
@Repository
public class AtendimentoJuridicoRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar Atendimento Juridico 
	 * @param idCedente idCedente CPF/CNPJ do cliente
	 * @param idSacado idCedente CPF/CNPJ do cliente
	 * @return List<AtendimentoJuridicoEntity> retorna lista de atendimento juridico
	 */
	public List<AtendimentoJuridicoEntity> consultarAtendimentoJuridico(String idCedente, String idSacado, Integer idTitulo) {
		List<AtendimentoJuridicoEntity> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idCedente", idCedente);
			parametro.addValue("idSacado", idSacado);
			parametro.addValue("idTitulo", idTitulo);
			retorno = genericJdbcTemplate.queryForSQLName(idTitulo == null ? "consultar_atendimento_juridico" : "consultar_atendimento_juridico_titulo", parametro, BeanPropertyRowMapper.newInstance(AtendimentoJuridicoEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ATENDIMENTO_JURIDICO)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	/**
	 * Consultar atendimento juridico
	 * @param filtro (Filtrar dataInicial e dataFinal)
	 * @return List<AtendimentoJuridicoEntity> lista de atendimentos juridico
	 */
	public List<AtendimentoJuridicoEntity> consultarAtendimentosJuridico(FiltroAtendimentoDTO filtro){
		List<AtendimentoJuridicoEntity> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("dataInicial", filtro.getDataInicial());
			parametro.addValue("dataFinal", filtro.getDataFinal());
			retorno = genericJdbcTemplate.queryForSQLName("consultar_atendimento_juridico_filtro", parametro, BeanPropertyRowMapper.newInstance(AtendimentoJuridicoEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_CONSULTAR_ATENDIMENTO_COBRANCA)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
	
	/**
	 * Inserir atendimento juridico
	 * @param atendimentoJuridico a objeto com dados do atendimento juridico
	 * @return identificador do registro inserido na tabela
	 */
	public Long inserirAtendimentoJuridico(AtendimentoJuridicoEntity atendimentoJuridico) {
		Long id = 0L;
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("idCedente", atendimentoJuridico.getIdCedente());
			parametro.addValue("idSacado", atendimentoJuridico.getIdSacado());
			parametro.addValue("idSacadoSRM", atendimentoJuridico.getIdSacadoSRM());
			parametro.addValue("idCedenteSRM", atendimentoJuridico.getIdCedenteSRM());
			parametro.addValue("idStatusJuridico", atendimentoJuridico.getIdStatusJuridico());
			parametro.addValue("numeroProcesso", atendimentoJuridico.getNumeroProcesso());
			parametro.addValue("autor", atendimentoJuridico.getAutor());
			parametro.addValue("reu", atendimentoJuridico.getReu());
			parametro.addValue("vara", atendimentoJuridico.getVara());
			parametro.addValue("comarca", atendimentoJuridico.getComarca());
			parametro.addValue("uf", atendimentoJuridico.getUf());
			parametro.addValue("objeto", atendimentoJuridico.getObjeto());
			parametro.addValue("dataDistribuicao", atendimentoJuridico.getDataDistribuicao());
			parametro.addValue("descricao", atendimentoJuridico.getDescricao());
			parametro.addValue("dataRetorno", atendimentoJuridico.getDataRetorno());
			parametro.addValue("dataPrevisao", atendimentoJuridico.getDataPrevisao());
			parametro.addValue("idUsuario", atendimentoJuridico.getIdUsuario());
			parametro.addValue("dataInclusao", new Date());
			parametro.addValue("dataExclusao", null);
			int returnSql =  genericJdbcTemplate.updateForSQLName("inserir_atendimento_juridico", parametro, keyHolder);
			if (returnSql != 1 && keyHolder.getKey() == null) {
				throw new AtendimentoCobrancaRepositoryException(Mensagens.REPOSITORY_INSERIR_ATENDIMENTO_JURIDICO, CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY);
			}else {
				id = keyHolder.getKey().longValue();
			}
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_INSERIR_ATENDIMENTO_JURIDICO)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return id;
	}
	
}
