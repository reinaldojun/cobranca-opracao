package com.trusthub.cobranca.domain.dto.atendimento;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO - classe responsavel por entrada de dados da tabela tutulos_atendimento da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AtendimentoTitulosDTO extends AuditoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id")
	@JsonProperty("id")
	private Long id;
	
	@ApiModelProperty(value = "Id do Título")
	@JsonProperty("idTitulo")
	private Long idTitulo;
	
	@ApiModelProperty(value = "Tipo do Arquivo")
	@JsonProperty("tipoArquivo")
	private String tipoArquivo;
	
	@ApiModelProperty(value = "Lista Id Titulo")
	@JsonProperty("listaIdTitulo")
	private List<Integer> listaIdTitulo;
	
	@ApiModelProperty(value = "Quantidade Atendimento Cobranca")
	@JsonProperty("quantidadeAtendimentoCobranca")
	private Integer quantidadeAtendimentoCobranca;

	@ApiModelProperty(value = "Quantidade Atendimento Juridico")
	@JsonProperty("quantidadeAtendimentoJuridico")
	private Integer quantidadeAtendimentoJuridico;


}
