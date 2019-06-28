<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="modelo.dominio.Endereco"%>
<%@page import="modelo.dominio.Paciente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
<title>Cadastro de Pacientes</title>
</head>
<body>
<jsp:useBean id="pcte" scope="request" class="modelo.dominio.Paciente"></jsp:useBean>
<%
//	Paciente pcte = (Paciente) request.getAttribute("pcte");
//	if (pcte == null)
//		pcte = new Paciente();
%>

<%
	List<Endereco> listaEnd = (List<Endereco>) request.getAttribute("listaEnd");

	List<String> erros = (List<String>) request.getAttribute("erros");
	if (erros != null)
	{
		out.print("<ul>");
		for (String erro : erros)
			out.print("<li>" + erro + "</li>");
		
		out.print("</ul>");
	}
%>

	<form action="salvarPaciente" method="post">
	
	<fieldset id = "paciente"><legend> Dados do Paciente</legend>
	
	<table>
		<tr>
			<td><label for="idPaciente"> ID:</label></td>
			<td><input type="hidden" name="idPaciente" id="idPaciente" value="${pcte.idPaciente}" 
			size="20" maxlength="20" placeholder="Digite o ID" autofocus required></td>
		</tr>
		<tr>
			<td><label for="nome"> Nome:</label></td>
			<td><input type="text" name="nome" id="nome" value="${pcte.nome}" 
			size="40" maxlength="120" placeholder="Digite o nome completo" autofocus required></td>
		</tr>		
		<tr>
			<td><label for="rg"> RG:</label></td>
			<td><input type="text" name="rg" id="rg" value="${pcte.rg}" 
			size="20" maxlength="60" placeholder="Digite o RG" autofocus required></td>

		</tr>		
		<tr>
			<td><label for="sexo"> Sexo:</label></td>
			<td><input type="radio" name="myradio" id="myradio" value="Masculino">
				<label for="cmasc">Masculino</label>
				<br>
				<input type="radio" name="myradio" id="myradio" value="Feminino">
				<label for="cfem">Feminino</label></td>
		</tr>		
		<tr>
			<td><label for="dataNasc"> Data de Nascimento:</label></td>
			<td><input type="text" name="dataNasc" id="dataNasc" value="${pcte.dataNasc}
			size="15" maxlength="15" placeholder="Data de nascimento" autofocus required></td>
			<script type="text/javascript">$("#dataNasc").mask("00/00/0000");</script>
		</tr>		
		<tr>
			<td><label for="telefone"> Telefone:</label></td>
			<td><input type="text" name="telefone" id="telefone" value="${pcte.telefone}" 
			pattern="\([0-9]{2}\)[\s][0-9]{4}-[0-9]{4,5}"size="15" maxlength="15" 
			placeholder="Telefone residencial" autofocus required></td>
			<script type="text/javascript">$("#telefone").mask("(00) 0000-00009");</script>
		</tr>
		<tr>
			<td><label for="logradouro"> Logradouro:</label></td>
			<td><input type="text" name="logradouro" id="logradouro" value="${pcte.endereco.logradouro}" 
			size="40" maxlength="120" placeholder="Digite o logradouro" autofocus required></td>
		</tr>
		<tr>
			<td><label for="cep"> CEP:</label></td>
			<td><input type="text" name="cep" id="cep" value="${pcte.endereco.cep}" 
			size="12" maxlength="15" placeholder="Digite o cep" autofocus required></td>
			
		</tr>
		<tr>
			<td><label for="numero"> Número:</label></td>
			<td><input type="text" name="numero" id="numero" value="${pcte.endereco.numero}" 
			size="12" maxlength="15" placeholder="Digite o nº" autofocus required></td>
		</tr>
		<tr>
			<td><label for="complemento"> Complemento:</label></td>
			<td><input type="text" name="complemento" id="complemento" value="${pcte.endereco.complemento}" 
			size="40" maxlength="120" placeholder="Digite o complemento" autofocus required></td>
		</tr>
		<tr>
			<td><label for="bairro"> Bairro:</label></td>
			<td><input type="text" name="bairro" id="bairro" value="${pcte.endereco.bairro}" 
			size="40" maxlength="120" placeholder="Digite o bairro" autofocus required></td>
		</tr>
		<tr>
			<td><label for="cidade"> Cidade:</label></td>
			<td><input type="text" name="cidade" id="cidade" value="${pcte.endereco.cidade}" 
			size="40" maxlength="120" placeholder="Digite a cidade" autofocus required></td>
		</tr>
		<tr>
			<td><label for="estado"> Estado:</label></td>
			<td><input type="text" name="estado" id="estado" value="${pcte.endereco.estado}" 
			size="30" maxlength="30" placeholder="Digite o estado" autofocus required></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Salvar">
				<input type="button" value="Cancelar"
						onclick="window.location = 'listarPaciente'">
			</td>
		</tr>
					
	</table>
	</fieldset>
	
	</form>
</body>
</html>