package com.trusthub.cobranca.domain.dto.atendimento.aviso;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class AvisoAtendimentoDTO implements Serializable{
	
	private Integer idAtendimento;
	
	private String cnpjCedente;
	
	private String cnpjSacado;
	
	private Integer idCedenteSRM;
	
	private Integer idSacadoSRM;
	
	private String status;
	
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataPrevisao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataRetorno;
	   
	private Integer idTitulo;
	
	private String tipoAtendimento;
	
	private Boolean atraso;
	
	private Integer diasAtraso;
	
}
