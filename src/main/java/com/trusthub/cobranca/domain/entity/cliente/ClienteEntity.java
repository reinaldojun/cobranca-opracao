package com.trusthub.cobranca.domain.entity.cliente;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.trusthub.cobranca.domain.entity.atendimento.AuditoriaEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity - classe responsavel por operacoes na tabela de Cliente da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class ClienteEntity extends AuditoriaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(name = "id_segmento")
	private Long idSegmento;
	
	@Column(name = "id_pessoa")
	private Long idPessoa;
	
	@Column(name = "faturamento_anual")
	private BigDecimal faturamentoAnual;
	
	@Column(name = "id_conta_externa")
	private Long idContaExterna;

}
