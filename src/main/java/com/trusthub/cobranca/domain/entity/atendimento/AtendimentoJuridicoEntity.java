package com.trusthub.cobranca.domain.entity.atendimento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity - classe responsavel por operacoes na tabela de atendimento_juridico da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class AtendimentoJuridicoEntity extends AuditoriaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_sacado")
	private String idSacado;
	
	@Column(name =  "id_cedente")
	private String idCedente;
	
	@Column(name = "id_sacadoSRM")
	private Integer idSacadoSRM;
	
	@Column(name = "id_cedenteSRM")
	private Integer idCedenteSRM;
	
	@Column(name = "id_status_juridico")
	private Long idStatusJuridico;
	
	@Column(name = "numero_processo")
	private String numeroProcesso;

	@Column(name = "autor")
	private String autor;
	
	@Column(name = "reu")
	private String reu;

	@Column(name = "vara")
	private String vara;

	@Column(name = "comarca")
	private String comarca;
	
	@Column(name = "uf")
	private String uf;

	@Column(name = "objeto")
	private String objeto;
	
	@Column(name = "data_distribuicao")
	@Temporal(TemporalType.DATE)
	private Date dataDistribuicao;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "data_retorno")
	@Temporal(TemporalType.DATE)
	private Date dataRetorno;
	
	@Column(name = "data_previsao")
	@Temporal(TemporalType.DATE)
	private Date dataPrevisao;


}
