package com.trusthub.cobranca.domain.entity.atendimento;

import java.io.Serializable;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity - classe responsavel por operacoes na tabela de status_juridico da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class AtendimentoStatusJuridicoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("descricao")
	private String descricao;

}
