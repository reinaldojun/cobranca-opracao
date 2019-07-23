package com.trusthub.cobranca.application.util;


/**
 * Inteface que centraliza as mensagens utilizada no cobranca operacao 
 * @author alan.franco
 */
public interface Mensagens {
	
	
	//SERVICE
	public static final String SERVICE_CONSULTAR_ARQUIVO = "Erro ao consultar arquivo no método (ArquivoService.consultarArquivo): ";
	public static final String SERVICE_INSERIR_ATENDIMENTO_ARQUIVO = "Erro ao inserir atendimento arquivo no método (AtendimentoArquivoService.inserirAtendimentoArquivo): ";
	public static final String SERVICE_CONSULTAR_ARQUIVO_CEDENTE_SACADO = "Erro ao consultar arquivo por cedente e sacado no método (AtendimentoArquivoService.consultarDadosArquivoPorCedenteSacado): ";
	public static final String SERVICE_CONSULTAR_AVISO_ATENDIMENTO_COBRANCA = "Erro ao consultar atendimento cobranca no método (AvisoAtendimentoService.consultarAvisoAtendimentoCobranca): ";
	public static final String SERVICE_CONSULTAR_AVISO_ATENDIMENTO_JURIDICO = "Erro ao consultar atendimento cobranca no método (AvisoAtendimentoService.consultarAvisoAtendimentoJuridico): ";
	public static final String SERVICE_DESATIVAR_ALERTAR_COBRANCA = "Erro ao desativar alerta cobranca no método (AvisoAtendimentoService.desativarAlertaCobranca): ";
	public static final String SERVICE_DESATIVAR_ALERTAR_JURIDICO = "Erro ao desativar alerta jurídico no método (AvisoAtendimentoService.desativarAlertaJuridico): ";
	public static final String SERVICE_INSERIR_ATENDIMENTO_COBRANCA = "Erro ao inserir atendimento cobranca no método (AtendimentoCobrancaService.inserirAtendimentoCobranca): ";
	public static final String SERVICE_CONSULTAR_ATENDIMENTO_JURIDICO = "Erro ao consultar atendimento juridico no método (AtendimentoJuridicoService.consultarAtendimentoJuridico): ";
	public static final String SERVICE_INSERIR_ATENDIMENTO_JURIDICO = "Erro ao inserir atendimento juridico no método (AtendimentoJuridicoService.inserirAtendimentoJuridico): ";
	public static final String SERVICE_CONSULTAR_ATENDIMENTO_COBRANCA = "Erro ao consultar atendimento cobranca no método (AtendimentoCobrancaService.consultarAtendimentoCobranca): ";
	public static final String SERVICE_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA = "Erro ao consultar status atendimento cobranca no método (AtendimentoStatusCobrancaService.consultarStatusAtendimentoCobranca): ";
	public static final String SERVICE_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA_ID = "Erro ao consultar status atendimento cobranca por id no método (AtendimentoStatusCobrancaService.consultarStatusAtendimentoCobrancaPorId): ";
	public static final String SERVICE_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO = "Erro ao consultar status atendimento juridico no método (AtendimentoStatusJuridicoService.consultarStatusAtendimentoJuridico): ";
	public static final String SERVICE_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO_ID = "Erro ao consultar status atendimento juridico por id no método (AtendimentoStatusJuridicoService.consultarStatusAtendimentoJuridicoPorId): ";
	public static final String SERVICE_INSERIR_ATENDIMENTO_TITULO = "Erro ao inserir atendimento titulo no método (AtendimentoTitulosService.inserirAtendimentoTitulo): ";
	public static final String SERVICE_CONSULTAR_TITULOS = "Erro ao consultar titulos no método (AtendimentoTitulosService.consultarTitulos): ";
	public static final String SERVICE_CONSULTAR_QUANTIDADE_ATENDIMENTOS = "Erro ao consultar quantidade de atendimentos no método (AtendimentoTitulosService.quantidadeAtendimentos): ";
	public static final String SERVICE_CONSULTAR_CLIENTE = "Erro ao consultar cliente documento no método (ClienteService.consultarClienteDocumento): ";
	
	//REPOSITORY
	public static final String REPOSITORY_CONSULTAR_ARQUIVO = "Erro ao consultar dados do arquivo no método (ArquivoRepository.consultarArquivo): ";
	public static final String REPOSITORY_CONSULTAR_ARQUIVO_CEDENTE_SACADO = "Erro ao consultar dados do arquivo por cedente e sacado no método (AtendimentoArquivoRepository.consultarDadosArquivoPorCedenteSacado): ";
	public static final String REPOSITORY_INSERIR_ATENDIMENTO_ARQUIVO_CEDENTE_SACADO = "Erro ao inserir atendimento arquivo no método (AtendimentoArquivoRepository.inserirAtendimentoArquivo): ";
	public static final String REPOSITORY_CONSULTAR_ATENDIMENTO_COBRANCA = "Erro ao consultar atendimento cobranca no método (AtendimentoCobrancaRepository.consultarAtendimentoCobranca): ";
	public static final String REPOSITORY_CONSULTAR_ATENDIMENTO_COBRANCA_AUDITORIA = "Erro ao consultar atendimento cobranca no método (AtendimentoAuditoriaRepository.consultarAtendimentoCobrancaAuditoria): ";
	public static final String REPOSITORY_CONSULTAR_ATENDIMENTO_JURIDICO_AUDITORIA = "Erro ao consultar atendimento juridico no método (AtendimentoAuditoriaRepository.consultarAtendimentoJuridicoAuditoria): ";
	public static final String REPOSITORY_CONSULTAR_AVISO_ATENDIMENTO_COBRANCA = "Erro ao consultar aviso de atendimento Cobranca no método (AvisoAtendimentoRepository.consultarAvisoAtendimentoCobranca): ";
	public static final String REPOSITORY_CONSULTAR_AVISO_ATENDIMENTO_JURIDICO = "Erro ao consultar aviso de atendimento Jurídico no método (AvisoAtendimentoRepository.consultarAvisoAtendimentoJuridico): ";
	public static final String REPOSITORY_DESATIVAR_ALERTA_COBRANCA = "Erro ao desativar alerta cobranca no método (AvisoAtendimentoRepository.desativarAlertaCobranca): ";
	public static final String REPOSITORY_DESATIVAR_ALERTA_JURIDICO = "Erro ao desativar alerta juridico no método (AvisoAtendimentoRepository.desativarAlertaJuridico): ";
	public static final String REPOSITORY_INSERIR_ATENDIMENTO_COBRANCA = "Erro ao inserir atendimento cobranca no método (AtendimentoCobrancaRepository.inserirAtendimentoCobranca): ";
	public static final String REPOSITORY_CONSULTAR_ATENDIMENTO_JURIDICO = "Erro ao consultar atendimento juridico no método (AtendimentoJuridicoRepository.consultarAtendimentoJuridico): ";
	public static final String REPOSITORY_INSERIR_ATENDIMENTO_JURIDICO = "Erro ao inserir atendimento juridico no método (AtendimentoJuridicoRepository.inserirAtendimentoJuridico): ";
	public static final String REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA = "Erro ao consultar status atendimento cobranca no método (AtendimentoStatusCobrancaRepository.consultarStatusAtendimentoCobranca): ";
	public static final String REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_COBRANCA_ID = "Erro ao consultar status atendimento cobranca por id no método (AtendimentoStatusCobrancaRepository.consultarStatusAtendimentoCobrancaPorId): ";
	public static final String REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO = "Erro ao consultar status atendimento juridico no método (AtendimentoStatusJuridicoRepository.consultarStatusAtendimentoJuridico): ";
	public static final String REPOSITORY_CONSULTAR_STATUS_ATENDIMENTO_JURIDICO_ID = "Erro ao consultar status atendimento juridico por id no método (AtendimentoStatusJuridicoRepository.consultarStatusAtendimentoJuridicoPorId): ";
	public static final String REPOSITORY_CONSULTAR_ATENDIMENTO_TITULOS = "Erro ao consultar atendimento titulos no método (AtendimentoTitulosRepository.consultarTitulos): ";
	public static final String REPOSITORY_CONSULTAR_QUANTIDADE_ATENDIMENTOS = "Erro ao consultar quantidade de atendimentos no método (AtendimentoTitulosRepository.quantidadeAtendimentos): ";
	public static final String REPOSITORY_INSERIR_ATENDIMENTO_TITULOS = "Erro ao inserir atendimento titulos no método (AtendimentoTitulosRepository.inserirAtendimentoTitulo): ";
	public static final String REPOSITORY_INSERIR_CLIENTE = "Erro ao inserir cliente no método (ClienteRepository.consultarClienteDocumento): ";
	public static final String REPOSITORY_NAO_AUTORIZADO = "Usuário ou senha Inválidos !";
	
	
	//SECURITY
	public static final String  SECURITY_NO_AUTHORIZATION = "Authorization nulo ou vazio.";
	public static final String  SECURITY_TOKEN_INVALID = "Token Invalido.";
	public static final String  SECURITY_PERFIL_NO_AUTHORIZATION = "Perfil não autorizado.";
	public static final String  SECURITY_VALIDAR_TOKEN = "Erro no na validação do token no método: (CobrancaOperacaoSecurityService.validarToken)";
	public static final String  SECURITY_ERRO_VALIDAR_RESPOSTA_VALIDAR_TOKEN = "Erro ao validar resposta da validacao do token no metodo: (CobrancaOperacaoSecurityService.validarRespostaValidarToken)";
	
}

