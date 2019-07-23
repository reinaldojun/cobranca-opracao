package com.trusthub.cobranca.domain.entity.atendimento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity - classe responsavel por operacoes na tabela de atendimento_cobranca da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class AtendimentoCobrancaEntity extends AuditoriaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_sacado")
	private String idSacado;
	
	@Column(name = "id_cedente")
	private String idCedente;
	
	@Column(name = "id_sacadoSRM")
	private Integer idSacadoSRM;
	
	@Column(name = "id_cedenteSRM")
	private Integer idCedenteSRM;
	
	@Column(name = "id_status_atendimento")
	private Long idStatusAtendimento;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "data_retorno")
	@Temporal(TemporalType.DATE)
	private Date dataRetorno;
	
	@Column(name = "data_previsao")
	@Temporal(TemporalType.DATE)
	private Date dataPrevisao;

}
