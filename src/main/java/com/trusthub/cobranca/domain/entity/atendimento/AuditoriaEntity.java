package com.trusthub.cobranca.domain.entity.atendimento;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

/**
 * Classe auxiliar para auditoria da TRUST . 
 * @author jose.viana
 */
@Data
@Entity
public class AuditoriaEntity {
	
	@Column(name = "empresa")
	private String empresa;
	
	@Column(name = "nomeUsuario")
	private String nomeUsuario;
	
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "data_inclusao")
	private LocalDateTime dataInclusao;
	
	@Column(name = "data_exclusao")
	private LocalDateTime dataExclusao;

}
