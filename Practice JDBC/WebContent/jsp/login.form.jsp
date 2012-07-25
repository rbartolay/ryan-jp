<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
	String greet = "";

	if(request.getAttribute("greet") != null) {
		greet = request.getAttribute("greet").toString();
	}
%>
<%=greet %>

<form action="LoginServlet" method="POST">
	<table>
		<tr>
			<td>Email</td>
			<td><input type="text" name="txtEmail"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="txtPassword"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Login"></td>
		</tr>
	</table>	
</form>
</body>
</html>