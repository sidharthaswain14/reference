<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form modelAttribute="memberRegistrationForm">
	<table>
		<tr>
			<td colspan="2"><span style="color: red;"> <form:errors
						path="*" />
			</span></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><form:input path="firstName" /></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><form:input path="lastName" /></td>
		</tr>
		<tr>
			<td>Mobile Number:</td>
			<td><form:input path="mobileNumber" /></td>
		</tr>
		<tr>
			<td>Email Id:</td>
			<td><form:input path="emailId" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td>Confirm Password:</td>
			<td><form:password path="confirmPassword" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register"></td>
		</tr>
	</table>
</form:form>