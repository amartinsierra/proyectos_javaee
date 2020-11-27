<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FrontController?option=doRegistrarCuenta" method="post" >	
		
		Elige Cuenta:<select name="numeroCuenta">
			<%List<Cuenta> cuentas=(List<Cuenta>)request.getAttribute("cuentas");
			for(Cuenta cuenta:cuentas){%>
			<option value="<%=cuenta.getNumeroCuenta()%>"><%=cuenta.getNumeroCuenta()%></option>
			<%} %>
		</select>
		<input type="submit" value="Asignar">	
	</form>
</body>
</html>