package com.trusthub.cobranca.domain.dto.arquivo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trusthub.cobranca.domain.entity.atendimento.AuditoriaEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO - Arquivo
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ArquivoDTO extends AuditoriaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id")
	@JsonProperty("id")
	private Long id;
	
	@ApiModelProperty(value = "Caminho")
	@JsonProperty("caminho")
	private String caminho;
	
	@ApiModelProperty(value = "Nome do Arquivo")
	@JsonProperty("nomeArquivo")
	private String nomeArquivo;
	
	@ApiModelProperty(value = "Nome do Arquivo Original")
	@JsonProperty("nomeArquivoOriginal")
	private String nomeArquivoOriginal;
		      
	@ApiModelProperty(value = "Extensão")
	@JsonProperty("extensao")
	private String extensao;
	
	@ApiModelProperty(value = "Tamanho")
	@JsonProperty("tamanho")
	private BigDecimal tamanho;
	
	@ApiModelProperty(value = "Id do Componente")
	@JsonProperty("idComponente")
	private Long idComponente;	

}
