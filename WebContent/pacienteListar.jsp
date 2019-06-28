<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="modelo.dominio.Paciente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function confirmar(idPaciente, nome) // parametro formal fica na declaração do metodo/função
	{
		if (confirm ('Deseja realmente excluir o paciente ['+ nome + ']?'))
			{
				// modelo DOM
				window.location = 'excluir?idPaciente=' +idPaciente;
			}
	}	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Paciente</title>
</head>
<%
// 			TYPE CAST / CASTING
List<Paciente> lista = (List<Paciente>) request.getAttribute("lista");
%>
<body>
	Opções: <br>
	<a href="abrirInclusao">Novo Paciente</a>
	
	<br><br>
	Lista de Pacientes:<br>
	<table border="1" cellpadding="4" cellspacing="0">
		<tr>
			<th>Opções</th>
			<th>ID</th>
			<th>Nome</th>
			<th>RG</th>
			<th>Sexo</th>
			<th>Data de Nascimento</th>
			<th>Telefone</th>
			<th>Logradouro</th>
			<th>CEP</th>
			<th>Número</th>
			<th>Complemento</th>
			<th>Bairro</th>
			<th>Cidade</th>
			<th>Estado</th>			
		</tr>

	<c:forEach var="pcte" items="${lista}">

			<tr>
				<td><a href="editar?idPaciente=${pcte.idPaciente}">Alterar</a>
					<a href="javascript:confirmar('${pcte.idPaciente}', '${pcte.nome}')">Excluir</a>
				</td> 
				<td>${pcte.idPaciente}></td>
				<td>${pcte.nome}</td>
				<td>${pcte.rg}</td>
				<td>${pcte.sexo}</td>
				<td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${pcte.dataNasc}"/></td>
				<td>${pcte.telefone}</td>
				<td>${pcte.endereco.cep}</td>
				<td>${pcte.endereco.logradouro}</td>
				<td>${pcte.endereco.numero}</td>
				<td>${pcte.endereco.complemento}</td>
				<td>${pcte.endereco.bairro}</td>
				<td>${pcte.endereco.cidade}</td>
				<td>${pcte.endereco.estado}</td>
			</tr>

	</c:forEach>

	</table>
</body>
</html>