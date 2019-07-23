package com.trusthub.cobranca.controller.atendimento;

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
import org.springframework.web.bind.annotation.RestController;

import com.trusthub.cobranca.application.business.atendimento.AtendimentoTituloBusiness;
import com.trusthub.cobranca.domain.dto.atendimento.AtendimentoTitulosDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * API - Controller - responsavel por atendimento titulo na tabela titulos_atendimento. 
 * @author jose.viana
 */
@RestController
@Validated
@CrossOrigin(value = "*")
@RequestMapping("/trusthub-cobranca-operacao/v1")
@Api(value = "API - Atendimento Título - Serviço que realiza consulta na base atendimento título (cob.titulos_atendimento)")
public class AtendimentoTituloController {

	@Autowired
	private AtendimentoTituloBusiness atendimentoTituloBusiness;

	@ApiOperation(value = "Inserir Atendimento Titulo")
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
	@PostMapping("/atendimento/titulo")
	public ResponseEntity<AtendimentoTitulosDTO> inserirAtendimentosTitulo(@RequestBody AtendimentoTitulosDTO atendimentoTitulosDTO) {
		this.atendimentoTituloBusiness.inserirAtendimentoTitulo(atendimentoTitulosDTO);
		return ResponseEntity.ok().body(atendimentoTitulosDTO);
	}
	
	@ApiOperation(value = "Consultar Títulos")
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
	@GetMapping("/atendimento/titulo/atendimento/{idAtendimento}/tipoArquivo/{tipoArquivo}")
	public ResponseEntity<List<AtendimentoTitulosDTO>> consultarTitulo(
				@PathVariable(value = "idAtendimento", required = false) Long   idAtendimento,
				@PathVariable(value = "tipoArquivo",   required = false) String tipoArquivo) {
		List<AtendimentoTitulosDTO> listaAtendimentoTitulosDTOs = atendimentoTituloBusiness.consultarTitulos(idAtendimento, tipoArquivo);
		return ResponseEntity.ok().body(listaAtendimentoTitulosDTOs);
	}
	
	
	@PostMapping("/atendimento/quantidade/atendimentos")
	public ResponseEntity<List<AtendimentoTitulosDTO>> quantidadeAtendimentos(@RequestBody AtendimentoTitulosDTO atendimentoTitulosDTO) {
		List<AtendimentoTitulosDTO> listaAtendimentoTitulosDTOs = atendimentoTituloBusiness.quantidadeAtendimentos(atendimentoTitulosDTO.getListaIdTitulo());
		return ResponseEntity.ok().body(listaAtendimentoTitulosDTOs);
	}

	
}
