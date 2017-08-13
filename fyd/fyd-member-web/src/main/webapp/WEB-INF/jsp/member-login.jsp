<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
  <script src="bootstrap-3.3.7-dist/libs/jquery.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>










</head>


<body>


<form:form modelAttribute="memberLoginForm" class="form-horizontal formView"><br>
<div class="login">
<div class="container" style="border:10cm;width : 366px; height : 247px;">
	<h1>Login</h1>
        <label class="control-label col-sm-2" for="registeredName">USER NAME</label>
    	<input type="text" name="u" placeholder="Username" required="required" />
    	<label class="control-label col-sm-2" for="registeredName">PASSWORD</label>
        <input type="password" name="p" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
   
</div>
</div>
</form:form>





</body>
</html>