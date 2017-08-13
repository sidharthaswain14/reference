<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="bootstrap-3.3.7-dist/libs/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SecondPhaseRegistration</title>
</head>
<div class="container containerNew" style="width: 100%;">
	<h2 align="center">Partner Second Phase Registration</h2>

	<body>


		<form:form modelAttribute="partnerOnlineUserForm"
			class="form-horizontal formView">
			</br>

			<form:hidden path="partnerId" />


			<!-- <fieldset disabled> -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="userName">UserName/Email
					address:</label>
				<div class="col-sm-5">
					<form:input path="userName" class="form-control" />
				</div>
				<form:errors path="userName" />
			</div>
			<!--  </fieldset> -->

			<div class="form-group">
				<label class="control-label col-sm-2" for="passWord">Password:</label>
				<div class="col-sm-5">
					<form:password path="passWord" class="form-control" />
				</div>
				<div style="color: red;">
					<form:errors path="passWord"></form:errors>
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-sm-2" for="confirmPassWord">Confirm
					Password:</label>
				<div class="col-sm-5">
					<form:password path="confirmPassWord" class="form-control" />
					<br>
				</div>
				<div style="color: red;">
					<form:errors path="confirmPassWord"></form:errors>
				</div>
			</div>

			<table class="table table-bordered">
				<thead>
					<tr>
						<h4>&#160 &#160 &#160 Accept One Terms&Condition</h4>
						<div style="color: red;">
							<form:errors path="termsAndConditionId"></form:errors>
						</div>
					</tr>
					<tr>
						<th></th>
						<th>MentainanceCharge Per SixMonth</th>
						<th>PerTicketFactor</th>
						<th>CancellationCharge PerTicket</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${termsAndConditions}" var="termsAndCondition">
						<tr>
							<td>
								<div class="radio">
									<label> <input type="radio" name="termsAndConditionId"
										value="${termsAndCondition.termsAndConditionId}"
										style="height: 20px; width: 20px;">
							</td>
							<c:if test="${termsAndCondition.perTicketFactorType eq 'R'}">
								<td>&#8377 ${termsAndCondition.mentainanceCharge} &times
									TOTAL NO OF SELLED TICKET</td>
								<td>&#8377 ${termsAndCondition.perTicketFactor}</td>
								<td>&#8377 ${termsAndCondition.cancellationCharge}</td>
							</c:if>

							<c:if test="${termsAndCondition.perTicketFactorType eq 'P'}">
								<td>${termsAndCondition.mentainanceCharge}%OF SIX MONTH
									REVENUE</td>
								<td>${termsAndCondition.perTicketFactor}%</td>
								<td>${termsAndCondition.cancellationCharge}%</td>
							</c:if>

						</tr>
						</input>
						</label>
					</c:forEach>
				</tbody>
				</div>
			</table>

			<div class="button" align="center">
				<form:button class="btn btn-primary btn-md">Register</form:button>
			</div>
			<br>




		</form:form>
		</br>
</div>
</body>
</html>