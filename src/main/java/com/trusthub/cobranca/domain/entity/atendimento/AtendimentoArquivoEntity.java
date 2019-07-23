package com.trusthub.cobranca.domain.entity.atendimento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity - classe responsavel por operacoes na tabela de atendimento_arquivo da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class AtendimentoArquivoEntity extends AuditoriaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "id_arquivo")
	private Long idArquivo;
	
	@Column(name = "tipo_arquivo")
	private String tipoArquivo;

}
