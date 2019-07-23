package com.trusthub.cobranca.controller.arquivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trusthub.cobranca.application.business.arquivo.ArquivoBusiness;
import com.trusthub.cobranca.domain.dto.arquivo.ArquivoDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * API - Controller - responsavel por arquivo 
 * @author jose.viana
 */
@RestController
@Validated
@CrossOrigin(value = "*")
@RequestMapping("/trusthub-cobranca-operacao/v1")
@Api(value = "API - Arquivo - Serviço que realiza consulta na base arquivo (arquivo.arquivo)")
public class ArquivoController {

	@Autowired
	private ArquivoBusiness arquivoBusiness;

	@ApiOperation(value = "Consultar Dados do Arquivo")
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
	@GetMapping("/arquivo/{idArquivo}")
	public ResponseEntity<ArquivoDTO> consultarDadosArquivo(@PathVariable(value = "idArquivo",     required = false) String idArquivo) {
		ArquivoDTO arquivoDTO = arquivoBusiness.consultarArquivo(idArquivo);
		return ResponseEntity.ok().body(arquivoDTO);
	}
	
}
