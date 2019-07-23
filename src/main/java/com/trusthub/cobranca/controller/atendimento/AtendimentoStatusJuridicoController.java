package com.trusthub.cobranca.controller.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trusthub.cobranca.application.business.atendimento.AtendimentoStatusJuridicoBusiness;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoStatusJuridicoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * API - Controller - responsavel por atendimento status juridico na tabela  status_juridico. 
 * @author jose.viana
 */
@RestController
@Validated
@CrossOrigin(value = "*")
@RequestMapping("/trusthub-cobranca-operacao/v1")
@Api(value = "API - Atendimento Status Jurídico - Serviço que realiza consulta na base atendimento status Jurídico (cob.status_juridico)")
public class AtendimentoStatusJuridicoController {

	@Autowired
	private AtendimentoStatusJuridicoBusiness statusJuridicoBusiness;

	@ApiOperation(value = "Consultar Status Atendimento Jurídico")
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
	@GetMapping("/atendimento/status/juridico")
	public ResponseEntity<List<AtendimentoStatusJuridicoDTO>> consultarStatusAtendimentoJuridico() {
		List<AtendimentoStatusJuridicoDTO> listaStatusJuridicoDTO = this.statusJuridicoBusiness.consultarStatusAtendimentoJuridico();
		return ResponseEntity.ok().body(listaStatusJuridicoDTO);
	}
	
	
	@ApiOperation(value = "Consultar Status Atendimento Jurídico por Id")
	@ApiResponses(
			value= {
					@ApiResponse(code = 200 , message = "Sucessfull"),
					@ApiResponse(code = 500, message = "Erro Internal Server Error: Contact your support \n"
														+ "Mensagem de erro:  { timestamp, errorCode, errorDescription, message, path  }  \n"							
														+ "  - errorCode: 1000 - Erro na api (Emprestimo Operação) na camada de Business \n"
														+ "  - errorCode: 2000 - Erro na api (Emprestimo Operação) na camada de Service \n"
														+ "  - errorCode: 3000 - Erro na api (Emprestimo Operação) na camada de Acesso a dados \n"
														+ "  - errorCode: 6 - Erro na api (Cobrança Operação) com integração com o componente cobranca acesso \n"
							)
			}
	)
	@GetMapping("/atendimento/status/juridico/{idAtendimento}")
	public ResponseEntity<AtendimentoStatusJuridicoDTO> consultarStatusAtendimentoJuridicoPorId(@PathVariable(value = "idAtendimento", required = false) Long id) {
		AtendimentoStatusJuridicoDTO statusJuridicoDTO = this.statusJuridicoBusiness.consultarStatusAtendimentoJuridicoPorId(id);
		return ResponseEntity.ok().body(statusJuridicoDTO);
	}
	
}
