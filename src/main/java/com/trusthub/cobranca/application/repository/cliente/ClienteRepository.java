package com.trusthub.cobranca.application.repository.cliente;

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
import com.trusthub.cobranca.domain.entity.cliente.ClienteEntity;

/**
 * responsavel por operacoes da tabela Cliente da TRUST . 
 * @author jose.viana
 */
@Repository
public class ClienteRepository {
	
	@Autowired
	private GenericJdbcTemplate genericJdbcTemplate;
	
	/**
	 * Consultar cliente documento 
	 * @param documento - CPF/CNPJ do cliente
	 * @return List<ClienteEntity> - Lista de clientes
	 */
	public List<ClienteEntity> consultarClienteDocumento(String documento){
		List<ClienteEntity> retorno = new ArrayList<>();
		try {
			MapSqlParameterSource parametro = new MapSqlParameterSource();
			parametro.addValue("documento", documento);
			retorno = genericJdbcTemplate.queryForSQLName("buscar_dados_cliente", parametro, BeanPropertyRowMapper.newInstance(ClienteEntity.class));
		}catch (Exception e) {
			throw new AtendimentoCobrancaRepositoryException(new StringBuilder(Mensagens.REPOSITORY_INSERIR_CLIENTE)
					.append(e.getMessage()).toString(), CobrancaOperacaoError.ERROR_COBRANCA_REPOSITORY, e);
		}
		return retorno;
	}
	
}
