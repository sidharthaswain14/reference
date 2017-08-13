<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verification Form</title> -->
<link rel="stylesheet" href="css/style.css">
<!-- </head>
<body> -->
		<form action="${pageContext.request.contextPath}/member-account-activation.htm?userId=${userId}" method="POST">
		  <header>Enter  Verification code to activate Your acount</header>
		  <label>verification code <span>*</span></label>
		<input type="text" name="verificationcode"/><br>
		 <div class="help"></div>
		<button>verify</button>
		</form>
<!-- </body> 
</html> -->

