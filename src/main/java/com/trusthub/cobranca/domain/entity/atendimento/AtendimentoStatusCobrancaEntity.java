package com.trusthub.cobranca.domain.entity.atendimento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity - classe responsavel por operacoes na tabela de status_cobanca da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class AtendimentoStatusCobrancaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;

}
