package com.trusthub.cobranca.controller.atendimento;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trusthub.cobranca.application.business.atendimento.AtendimentoJuridicoBusiness;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoJuridicoDTO;
import com.trusthub.cobranca.domain.dto.atendimento.filtro.FiltroAtendimentoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * API - Controller - responsavel por atendimento juridico na tabela cobranca_juridico. 
 * @author jose.viana
 */
@RestController
@Validated
@CrossOrigin(value = "*")
@RequestMapping("/trusthub-cobranca-operacao/v1")
@Api(value = "API - Atendimento Jurídico - Serviço que realiza consulta na base atendimento Jurídico (cob.cobranca_juridico)")
public class AtendimentoJuridicoController {
	
	@Autowired
	private AtendimentoJuridicoBusiness atendimentoJuridicoBusiness;
	
	@ApiOperation(value = "Consultar Atendimento Jurídico")
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
	@GetMapping("/atendimento/juridico/cedente/{idCedente}/sacado/{idSacado}")
	public ResponseEntity<List<AtendimentoJuridicoDTO>> consultarAtendimentosJuridico(@PathVariable(value = "idCedente", required = false) String idCedente, 
			@PathVariable(value = "idSacado", required = false) String idSacado, @RequestParam(required = false) Integer idTitulo) {
		List<AtendimentoJuridicoDTO> listaAtendimentoJuridicoDTO = 
					this.atendimentoJuridicoBusiness.consultarAtendimentoJuridico(idCedente, idSacado, idTitulo);
		return ResponseEntity.ok().body(listaAtendimentoJuridicoDTO);
	}

	
	@ApiOperation(value = "Inserir Atendimento Jurídico")
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
							)
			}
	)
	@PostMapping("/atendimento/juridico")
	public ResponseEntity<AtendimentoJuridicoDTO> inserirAtendimentosJuridico(@RequestBody AtendimentoJuridicoDTO atendimentoJuridicoDTO) {
		atendimentoJuridicoDTO.setId(this.atendimentoJuridicoBusiness.inserirAtendimentoJuridico(atendimentoJuridicoDTO));
		return ResponseEntity.ok().body(atendimentoJuridicoDTO);
	}
	
	@PostMapping("/atendimentos/juridico")
	public ResponseEntity<List<AtendimentoJuridicoDTO>> listaAtendimentosJuridico(@RequestBody FiltroAtendimentoDTO filtroAtendimentoDTO) {
		List<AtendimentoJuridicoDTO> listaAtendimentoJuridicoDTO = new ArrayList<>();
		listaAtendimentoJuridicoDTO = this.atendimentoJuridicoBusiness.consultarAtendimentosJuridico(filtroAtendimentoDTO);
		return ResponseEntity.ok().body(listaAtendimentoJuridicoDTO);
	}
	
}
