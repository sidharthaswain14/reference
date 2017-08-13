<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
  <script src="bootstrap-3.3.7-dist/libs/jquery.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PrimeryRegistrationSuccess</title>
</head>
<body>
<div class="container containerNew"  style="width: 100%;min-height: 100%;">

<div class="container formView"  style="width: 100%;height: 100%">
<h1>Partner Primery Registration Success </h1>

<h4>Dear <c:out value="${notification.partnerRegisteredName}"></c:out>,</h4>

<p><c:out value=""></c:out></p>
<h4>A confirmation mail has been send to your:- ${notification.emailId} mail account</h4>
<h4>Please for confirm primary registration success check your mailbox...</h4>
</div>
</div>
</body>
</html>