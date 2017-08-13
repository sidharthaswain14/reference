<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
  <script src="bootstrap-3.3.7-dist/libs/jquery.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container containerNew" style="width: 100%;">
	<h2 align="center">Partner Login</h2>
      <span style="color: red;">
			<%if(request.getParameter("error") != null){ 
				out.print("un/pwd not valid");
			}
			%>
	  </span>




		<form action="${pageContext.request.contextPath}/partner_spring_security_check" method="post"
			class="form-horizontal formView">
			<br>


			<!-- <fieldset disabled> -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="userName">UserName/Email
					address:</label>
				<div class="col-sm-5">
					<input type="text" name="userName" class="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2" for="passWord">Password:</label>
				<div class="col-sm-5">
					<input type="password" name="passWord" class="form-control" />
				</div>
				
			</div>


		<div class="button" align="center">
				<input type="submit" value="login" class="btn btn-primary btn-md"/>
			</div>
		
</form>
	</div>
</body>
</html>