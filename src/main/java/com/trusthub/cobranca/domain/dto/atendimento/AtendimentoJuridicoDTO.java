package com.trusthub.cobranca.domain.dto.atendimento;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO - classe responsavel por entrada de dados das tabela de atendimento juridico da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AtendimentoJuridicoDTO extends AuditoriaDTO implements Serializable {
	
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
	
	@ApiModelProperty(value = "Id Status Jurídico")
	@JsonProperty("idStatusJuridico")  
	private Long idStatusJuridico;
	
	@ApiModelProperty(value = "Número do Processo")
	@JsonProperty("numeroProcesso")  
	private String numeroProcesso;

	@ApiModelProperty(value = "Autor")
	@JsonProperty("autor")  
	private String autor;
	
	@ApiModelProperty(value = "Réu")
	@JsonProperty("reu")  
	private String reu;

	@ApiModelProperty(value = "Vara")
	@JsonProperty("vara")  
	private String vara;

	@ApiModelProperty(value = "Comarca")
	@JsonProperty("comarca") 
	private String comarca;
	
	@ApiModelProperty(value = "Uf")
	@JsonProperty("uf") 
	private String uf;

	@ApiModelProperty(value = "Objeto")
	@JsonProperty("objeto") 
	private String objeto;
	
	@ApiModelProperty(value = "Data de Distribuição")
	@JsonProperty("dataDistribuicao")  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataDistribuicao;
	
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
	

}
