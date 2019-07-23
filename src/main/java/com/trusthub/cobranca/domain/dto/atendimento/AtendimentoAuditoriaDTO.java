package com.trusthub.cobranca.domain.dto.atendimento;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO - classe responsavel por entrada de dados do atendimento da TRUST . 
 * @author jose.viana
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper=false)
public class AtendimentoAuditoriaDTO implements Serializable {
	
	@ApiModelProperty(value = "Id")
	@JsonProperty("id")
	private Long id;
	
	@ApiModelProperty(value = "Id do Cedente")
	@JsonProperty("idCedente")
	private String idCedente;
	
	@ApiModelProperty(value = "Id do Sacado")
	@JsonProperty("idSacado")
	private String idSacado;
	
	@ApiModelProperty(value = "Id Status Atendimento")
	@JsonProperty("idStatus") 
	private Integer idStatus;
	
	@ApiModelProperty(value = "Id Status Atendimento")
	@JsonProperty("status") 
	private String status;
	
	@ApiModelProperty(value = "Id Usuario Atendimento")
	@JsonProperty("idUsuario") 
	private Integer idUsuario;
	
	@ApiModelProperty(value = "Usuario do Atendimento")
	@JsonProperty("usuario") 
	private String usuario;
	
	@ApiModelProperty(value = "Data de Inclusao")
	@JsonProperty("dataInclusao")  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataInclusao;
	
	@ApiModelProperty(value = "Empresa do Atendimento")
	@JsonProperty("empresa") 
	private String empresa;
	
	@ApiModelProperty(value = "Quantidade de titulos")
	@JsonProperty("qtdTitulos") 
	private Integer qtdTitulos;

}
