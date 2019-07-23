package com.trusthub.cobranca.domain.dto.atendimento;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO - classe auxiliar para entrada de dados de auditoria da TRUST . 
 * @author jose.viana
 */
@Data
public class AuditoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "empresa")
	private String empresa;

	@ApiModelProperty(value = "Id do Usuário")
	@JsonProperty("idUsuario")
	private Long idUsuario;
	
	@JsonProperty("nomeUsuario")
	private String nomeUsuario;
	
	@ApiModelProperty(value = "Data da Inclusão")
	private LocalDateTime dataInclusao;
	
	@ApiModelProperty(value = "Data de Exclusão")
	@JsonProperty("dataExclusao")
	private LocalDateTime dataExclusao;

}
