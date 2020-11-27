<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FrontController?option=doListaCuentas" method="post" >	
		
		Elige Cliente:<select name="dni">
			<%List<Cliente> clientes=(List<Cliente>)request.getAttribute("clientes");
			for(Cliente cliente:clientes){%>
			<option value="<%=cliente.getDni()%>"><%=cliente.getNombre()%></option>
			<%} %>
		</select>
		<input type="submit" value="Siguiente">	
	</form>
</body>
</html>