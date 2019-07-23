package com.trusthub.cobranca.controller.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trusthub.cobranca.application.business.atendimento.AvisoAtendimentoBusiness;
import com.trusthub.cobranca.domain.dto.atendimento.aviso.AvisoAtendimentoDTO;

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
@Api(value = "API - Aviso Atendimento  - Serviço que realiza consulta de avisos atendimentos")
public class AvisoAtendimentoController {

	@Autowired
	private AvisoAtendimentoBusiness avisoAtendimentoBusiness;

	@ApiOperation(value = "Consultar Aviso Atendimento Cobranca - juridico")
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
	@GetMapping("/atendimento/aviso/usuario/{idUsuario}")
	public ResponseEntity<List<AvisoAtendimentoDTO>> consultarAvisoAtendimento(@PathVariable(value = "idUsuario", required = false) String idUsuario) {
		List<AvisoAtendimentoDTO> listaAvisoAtendimentoDTO = new ArrayList<>();
		listaAvisoAtendimentoDTO = this.avisoAtendimentoBusiness.consultarAvisoAtendimento(idUsuario);
		return ResponseEntity.ok().body(listaAvisoAtendimentoDTO);
	}
	
	@ApiOperation(value = "Desativar aviso Cobranca")
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
	@PatchMapping("/atendimento/desativar/aviso/cobranca/{idAtendimento}")
	public ResponseEntity<Integer> desativarAlertaCobranca(@PathVariable(value = "idAtendimento", required = false) String idAtendimento) {
		return ResponseEntity.ok().body(this.avisoAtendimentoBusiness.desativarAlertaCobranca(idAtendimento));
	}
	

	@ApiOperation(value = "Desativar aviso Juridico")
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
	@PatchMapping("/atendimento/desativar/aviso/juridico/{idAtendimento}")
	public ResponseEntity<Integer> desativarAlertaJuridico(@PathVariable(value = "idAtendimento", required = false) String idAtendimento) {
		return ResponseEntity.ok().body(this.avisoAtendimentoBusiness.desativarAlertaJuridico(idAtendimento));
	}

	
	
	
}
