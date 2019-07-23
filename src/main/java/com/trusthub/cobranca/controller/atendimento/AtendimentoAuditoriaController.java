package com.trusthub.cobranca.controller.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trusthub.cobranca.application.business.atendimento.AtendimentoAuditoriaBusiness;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoAuditoriaDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * API - Controller - responsavel por atendimento cobranca na tabela cobranca_atendimento. 
 * @author jose.viana
 */
@RestController
@Validated
@CrossOrigin(value = "*")
@RequestMapping("/trusthub-cobranca-operacao/v1")
@Api(value = "API - Atendimento Cobranca - Serviço que realiza consulta na base atendimento")
public class AtendimentoAuditoriaController {

	@Autowired
	private AtendimentoAuditoriaBusiness atendimentoAuditoriaBusiness;

	@ApiOperation(value = "Consultar Atendimento Cobranca Auditoria")
	@ApiResponses(
			value= {
					@ApiResponse(code = 200 , message = "Sucessfull"),
					@ApiResponse(code = 401 , message = "Unauthorized"),
					@ApiResponse(code = 403 , message = "Access denied"),
					@ApiResponse(code = 500, message = "Erro Internal Server Error: Contact your support \n"
														+ "Mensagem de erro:  { timestamp, errorCode, errorDescription, message, path  }  \n"							
														+ "  - errorCode: 1000 - Erro na api (Emprestimo Operação) na camada de Business \n"
														+ "  - errorCode: 2000 - Erro na api (Emprestimo Operação) na camada de Service \n"
														+ "  - errorCode: 3000 - Erro na api (Emprestimo Operação) na camada de Acesso a dados \n"
														+ "  - errorCode: 6 - Erro na api (Cobrança Operação) com integração com o componente cobranca acesso \n"
							)
			}
	)
	@PostMapping("/atendimentos/auditoria/cobranca")
	public ResponseEntity<List<AtendimentoAuditoriaDTO>> listaAtendimentosCobranca(@RequestBody FiltroAtendimentoDTO filtroAtendimentoDTO) {
		List<AtendimentoAuditoriaDTO> listaAtendimentoAuditoriaDTO = new ArrayList<>();
		listaAtendimentoAuditoriaDTO = this.atendimentoAuditoriaBusiness.consultarAtendimentoCobrancaAuditoria(filtroAtendimentoDTO);
		return ResponseEntity.ok().body(listaAtendimentoAuditoriaDTO);
	}
	
	@ApiOperation(value = "Consultar Atendimento Cobranca")
	@ApiResponses(
			value= {
					@ApiResponse(code = 200 , message = "Sucessfull"),
					@ApiResponse(code = 401 , message = "Unauthorized"),
					@ApiResponse(code = 403 , message = "Access denied"),
					@ApiResponse(code = 500, message = "Erro Internal Server Error: Contact your support \n"
														+ "Mensagem de erro:  { timestamp, errorCode, errorDescription, message, path  }  \n"							
														+ "  - errorCode: 1000 - Erro na api (Emprestimo Operação) na camada de Business \n"
														+ "  - errorCode: 2000 - Erro na api (Emprestimo Operação) na camada de Service \n"
														+ "  - errorCode: 3000 - Erro na api (Emprestimo Operação) na camada de Acesso a dados \n"
														+ "  - errorCode: 6 - Erro na api (Cobrança Operação) com integração com o componente cobranca acesso \n"
							)
			}
	)
	@PostMapping("/atendimentos/auditoria/juridico")
	public ResponseEntity<List<AtendimentoAuditoriaDTO>> listaAtendimentosJuridico(@RequestBody FiltroAtendimentoDTO filtroAtendimentoDTO) {
		List<AtendimentoAuditoriaDTO> listaAtendimentoAuditoriaDTO = new ArrayList<>();
		listaAtendimentoAuditoriaDTO = this.atendimentoAuditoriaBusiness.consultarAtendimentoJuridicoAuditoria(filtroAtendimentoDTO);
		return ResponseEntity.ok().body(listaAtendimentoAuditoriaDTO);
	}
	
}
