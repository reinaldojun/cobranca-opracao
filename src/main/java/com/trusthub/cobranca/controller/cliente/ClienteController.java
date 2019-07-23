package com.trusthub.cobranca.controller.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trusthub.cobranca.application.business.cliente.ClienteBusiness;
import com.trusthub.cobranca.domain.dto.cliente.ClienteDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * API - Controller - responsavel por clientes na tabela cliente. 
 * @author jose.viana
 */
@RestController
@Validated
@CrossOrigin(value = "*")
@RequestMapping("/trusthub-cobranca-operacao/v1/cliente")
@Api(value = "API - Clientes - Serviço que realiza consulta na base Cliente (dbo.cliente)")
public class ClienteController {

	@Autowired
	private ClienteBusiness clienteBusiness;

	@ApiOperation(value = "Consultr Cliente Documento")
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
	@GetMapping("/cliente/{documento}")
	public ResponseEntity<List<ClienteDTO>> consultarClienteDocumento(@PathVariable(value = "documento", required = false) String documento) {
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();
		listaClienteDTO = this.clienteBusiness.consultarClienteDocumento(documento);
		return ResponseEntity.ok().body(listaClienteDTO);
	}
	
}
