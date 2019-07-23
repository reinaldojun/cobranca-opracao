package com.trusthub.cobranca.domain.dto.atendimento.filtro;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * DTO - classe responsavel por entrada de dados para filtro de consultas. 
 * @author jose.viana
 */
@SuppressWarnings("serial")
@Data
public class FiltroAtendimentoDTO implements Serializable {
	
	@ApiModelProperty(value = "Data Inicial")
	@JsonProperty("dataInicial")  
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataInicial; 

	@ApiModelProperty(value = "Data Final")
	@JsonProperty("dataFinal")
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataFinal; 
	
	

}
