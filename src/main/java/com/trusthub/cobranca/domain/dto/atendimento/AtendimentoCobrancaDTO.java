package com.trusthub.cobranca.domain.dto.atendimento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO - classe responsavel por entrada de dados das tabela de atendimento cobranca da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AtendimentoCobrancaDTO extends AuditoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id")
	@JsonProperty("id")
	private Long id;
	
	@ApiModelProperty(value = "Id do Sacado")
	@JsonProperty("idSacado")
	private String idSacado;
	
	@ApiModelProperty(value = "Id do Cedente")
	@JsonProperty("idCedente")
	private String idCedente;
	
	@ApiModelProperty(value = "Id do Sacado do SRM")
	@JsonProperty("idSacadoSRM")
	private Integer idSacadoSRM;
	
	@ApiModelProperty(value = "Id do Cedentedo SRM")
	@JsonProperty("idCedenteSRM")
	private Integer idCedenteSRM;
	
	@ApiModelProperty(value = "Id Status Atendimento")
	@JsonProperty("idStatusAtendimento") 
	private Long idStatusAtendimento;
	
	@ApiModelProperty(value = "Descrição")
	@JsonProperty("descricao")   
	private String descricao;
	
	@ApiModelProperty(value = "Data de Retorno")
	@JsonProperty("dataRetorno")  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataRetorno;
	
	@ApiModelProperty(value = "Data de Previsao")
	@JsonProperty("dataPrevisao")  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataPrevisao;
	
	@ApiModelProperty(value = "Titulos")
	@JsonProperty("idsTitulos")   
	private List<Integer> idsTitulos;
	
}
