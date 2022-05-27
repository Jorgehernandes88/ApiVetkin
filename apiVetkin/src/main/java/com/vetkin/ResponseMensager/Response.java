package com.vetkin.ResponseMensager;

public class Response {
	//TutorCliente
	
	public static final String SUCESSO_INCLUSAO = "Tutor incluído com sucesso.";
	public static final String SUCESSO_INCLUSAO_PACIENTE = "Paciente incluído com sucesso.";
	public static final String SUCESSO_ATUALIZADO = "Tutor Atualizado com sucesso.";
	public static final String SUCESSO_ATUALIZADO_PACIENTE = "Paciente Atualizado com sucesso.";
	public static final String SUCESSO_EXCLUSAO = "Tutor Excluido com sucesso.";
	public static final String SUCESSO_EXCLUSAO_PACIENTE = "Paciente Excluido com sucesso.";
	
	
    public static final String ERRO_INCLUIR_CAMPOS_OBRIGATORIOS = "Campos obrigatórios não preenchidos";
    public static final String ERRO_CPF_INVALIDO = "CPF inválido";
    public static final String ERRO_CPF_EXISTENTE = "CPF já existente";
    public static final String ERRO_CLIENTE_TEM_PEDIDO = "Esse cliente está associado a Pedidos";
    public static final String ERRO_CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado";
    public static final String ERRO_PACIENTE_NAO_ENCONTRADO = "Cliente não encontrado";
    public static final String ERRO_BUSCAR_PEDIDOS = "Não foi possivel buscar os pedidos";
    public static final String ERRO_ATUALIZAR_REGISTRO = "Não foi possivel atualizar o registro";
    
    public static final String ERRO_MENSAGEM_RESTRICAO = "could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement";
    public static final String ERRO = "Erro";
    public static final String STATUS = "Status";

}
