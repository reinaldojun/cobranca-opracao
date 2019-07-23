package com.trusthub.cobranca.domain.dto.cliente;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO - classe para entrada de dados de Cliente da TRUST . 
 * @author jose.viana
 */
@Data
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Id")
	@JsonProperty("id")
	private Long id;
	
	@ApiModelProperty(value = "Id do Segmento")
	@JsonProperty("idSegmento")
	private Long idSegmento;
	
	@ApiModelProperty(value = "Id da Pessoa")
	@JsonProperty("idPessoa")
	private Long idPessoa;
	
	@ApiModelProperty(value = "Faturamento Anual")
	@JsonProperty("faturamentoAnual")
	private BigDecimal faturamentoAnual;
	
	@ApiModelProperty(value = "Id Conta Externa")
	@JsonProperty("idContaExterna")
	private Long idContaExterna;

}
