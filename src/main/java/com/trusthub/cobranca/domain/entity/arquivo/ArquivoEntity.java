package com.trusthub.cobranca.domain.entity.arquivo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.trusthub.cobranca.domain.entity.atendimento.AuditoriaEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity - classe responsavel por operacoes na tabela de arquivo da TRUST . 
 * @author jose.viana
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class ArquivoEntity extends AuditoriaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "caminho")
	private String caminho;
	
	@Column(name = "nome_arquivo")
	private String nomeArquivo;
	
	@Column(name = "nome_arquivo_original")
	private String nomeArquivoOriginal;
		      
	@Column(name = "extensao")
	private String extensao;
	
	@Column(name = "tamanho")
	private BigDecimal tamanho;
	
	@Column(name = "id_componente")
	private Long idComponente;

}
