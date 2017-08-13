<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <link href="datepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">
<!--<link href="datepicker/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen"> -->
<!-- <link href="datepicker/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen"> -->

<link href="bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet"
	media="screen">
<script src="bootstrap-3.3.7-dist/libs/jquery.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>



<title>PartnerRegistration</title>

</head>
<body>

	<div class="container containerNew" style="width: 100%">
		<h2 align="center">Partner Registration</h2>



		<!-- partner registration form -->

		<form:form modelAttribute="partnerRegistrationForm"
			class="form-horizontal formView">
			<br>

			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="registeredName">RegisteredName</label>
				<div class="col-xs-10 col-md-4">

					<form:input path="registeredName" class="form-control" />

				</div>
				<div style="color: red;">
					<form:errors path="registeredName"></form:errors>
				</div>

			</div>








			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="registrationNo">RegistrationNo</label>
				<div class="col-xs-10 col-md-4">
					<form:input path="registrationNo" class="form-control" />

				</div>
				<div style="color: red;">
					<form:errors path="registrationNo"></form:errors>
				</div>

			</div>







			<!--  <div class="control-group">
                <label class="control-label">DateTime Picking</label>
                <div class="controls input-append date form_datetime" data-date="1979-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                    <input size="16" type="text" value="" readonly>
                    <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
                </div>
				<input type="hidden" id="dtp_input1" value="" /><br/>
            </div>
 
  -->


			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="estYear">EstYear</label>
				<div class="col-xs-10 col-md-4">
			<div class="controls input-append date years"
					data-date="1979-09-16T05:25:07Z"
					data-date-format="dd MM yyyy - HH:ii p"
					data-link-field="dtp_input1">
					<form:input path="estYear" class="dtp_input1"/>
					 <span
						class="add-on"><i class="icon-remove"></i></span> <span
						class="add-on"><i class="icon-th"></i></span>
				</div>
	
				</div>
				<div style="color: red;">
					<form:errors path="estYear"></form:errors>
				</div>

			</div>








<%-- 
			<div class="control-group">
				<label class="control-label">DateTime Picking</label>
				<div class="controls input-append date years"
					data-date="1979-09-16T05:25:07Z"
					data-date-format="dd MM yyyy - HH:ii p"
					data-link-field="dtp_input1">
					<input size="16" type="text" value="" readonly> <span
						class="add-on"><i class="icon-remove"></i></span> <span
						class="add-on"><i class="icon-th"></i></span>
				</div>
				<input type="hidden" id="dtp_input1" value="" /><br />
			</div>






			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="estYear">EstYear</label>
				<div class="col-xs-10 col-md-4">
					 <form:input path="estYear" class="form-control" />

					<form:input path="estYear" class="datepicker" id="datepicker" />
				</div>
				<div style="color: red;">
					<form:errors path="estYear"></form:errors>
				</div>

			</div>

 --%>



			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="description">Description</label>
				<div class="col-xs-10 col-md-4">
					<form:textarea path="description" class="form-control" rows="5" />
				</div>
				<div style="color: red;">
					<form:errors path="description"></form:errors>
				</div>
			</div>

			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="primeryMobileNo">PrimeryMobileNo</label>
				<div class="col-xs-10 col-md-4">
					<form:input path="primeryMobileNo" class="form-control" />
				</div>

				<div style="color: red;">
					<form:errors path="primeryMobileNo"></form:errors>
				</div>
			</div>

			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="secondaryMobileNo">SecondaryMobileNo</label>
				<div class="col-xs-10 col-md-4">
					<form:input path="secondaryMobileNo" class="form-control" />
				</div>
				<div style="color: red;">
					<form:errors path="secondaryMobileNo"></form:errors>
				</div>
			</div>

			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="primeryEmailid">PrimeryEmailid</label>
				<div class="col-xs-10 col-md-4">
					<form:input path="primeryEmailid" class="form-control"
						onkeyup="showHint(this.value)"></form:input>
				</div>
				<div style="color: red;" id="emailId_error">
					<form:errors path="primeryEmailid"></form:errors>
				</div>
			</div>

			<div class="form-group form-inline">
				<label class="control-label col-sm-2" for="secondaryEmailid">SecondaryEmailid</label>
				<div class="col-xs-10 col-md-4">
					<form:input path="secondaryEmailid" class="form-control" />
				</div>
			</div>

			<div class="container" style="width: 100%">
				<table class="table">
					<tr>
						<td>
							<!-- primery address -->
							<h4 align="left">Primery Address</h4>


							<div class="form-group">
								<label class="control-label col-sm-2" for="primeryAddressLine1">AddressLine1</label>
								<div class="col-sm-7">
									<form:input path="primeryAddressLine1" class="form-control" />
								</div>
								<div style="color: red;">
									<form:errors path="primeryAddressLine1"></form:errors>
								</div>
							</div>

						</td>

						<td>
							<h4>Secondary Address</h4>
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="secondaryAddressLine1">AddressLine1</label>
								<div class="col-sm-7">
									<form:input path="secondaryAddressLine1" class="form-control" />
								</div>
							</div>

						</td>
					</tr>
					<tr>
						<td>
							<div class="form-group">
								<label class="control-label col-sm-2" for="primeryAddressLine2">AddressLine2</label>
								<div class="col-sm-7">
									<form:input path="primeryAddressLine2" class="form-control" />
								</div>

							</div>


						</td>
						<td>
							<div class="form-group">
								<label class="control-label col-sm-2"
									for="secondaryAddressLine2">AddressLine2</label>
								<div class="col-sm-7">
									<form:input path="secondaryAddressLine2" class="form-control" />
								</div>
							</div>


						</td>
					</tr>

					<tr>
						<td>

							<div class="form-group">
								<label class="control-label col-sm-2" for="primeryCity">City</label>
								<div class="col-sm-7">
									<form:input path="primeryCity" class="form-control" />
								</div>
								<div style="color: red;">
									<form:errors path="primeryCity"></form:errors>
								</div>
							</div>


						</td>
						<td>

							<div class="form-group">
								<label class="control-label col-sm-2" for="secondaryCity">City</label>
								<div class="col-sm-7">
									<form:input path="secondaryCity" class="form-control" />
								</div>
							</div>



						</td>
					</tr>

					<tr>
						<td>
							<div class="form-group">
								<label class="control-label col-sm-2" for="primeryState">State</label>
								<div class="col-sm-7">
									<form:input path="primeryState" class="form-control" />
								</div>
								<div style="color: red;">
									<form:errors path="primeryState"></form:errors>
								</div>
							</div>


						</td>
						<td>

							<div class="form-group">
								<label class="control-label col-sm-2" for="secondaryState">State</label>
								<div class="col-sm-7">
									<form:input path="secondaryState" class="form-control" />
								</div>
							</div>


						</td>
					</tr>

					<tr>
						<td>
							<div class="form-group">
								<label class="control-label col-sm-2" for="primeryZip">Zip</label>
								<div class="col-sm-7">
									<form:input path="primeryZip" class="form-control" />
								</div>
								<div style="color: red;">
									<form:errors path="primeryZip"></form:errors>
								</div>
							</div>


						</td>
						<td>
							<div class="form-group">
								<label class="control-label col-sm-2" for="secondaryZip">Zip</label>
								<div class="col-sm-7">
									<form:input path="secondaryZip" class="form-control" />
								</div>
							</div>



						</td>
					</tr>

					<tr>
						<td>
							<div class="form-group">
								<label class="control-label col-sm-2" for="primeryCountry">Country</label>
								<div class="col-sm-7">
									<form:input path="primeryCountry" class="form-control" />
								</div>
								<div style="color: red;">
									<form:errors path="primeryCountry"></form:errors>
								</div>
							</div>


						</td>
						<td>

							<div class="form-group">
								<label class="control-label col-sm-2" for="secondaryCountry">Country</label>
								<div class="col-sm-7">
									<form:input path="secondaryCountry" class="form-control" />
								</div>
							</div>



						</td>
					</tr>

					<tr>
						<td align="right"><form:button class="btn btn-primary btn-md">Register</form:button>
						</td>

						<td></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>

	<script type="text/javascript"
		src="datepicker/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>

	<script type="text/javascript"
		src="datepicker/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript"
		src="datepicker/js/locales/bootstrap-datetimepicker.fr.js"
		charset="UTF-8"></script>
	<script type="text/javascript">
		function showHint(str) {
			var xhttp;
			if (str.length == 0) {
				document.getElementById("emailId_error").innerHTML = "";
				return;
			}
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById("emailId_error").innerHTML = this.responseText;
				}
			};
			xhttp.open("GET", "partner-email-exist.htm?emailId=" + str, true);
			xhttp.send();
		}

		/*  $('.form_datetime').datetimepicker({
		     //language:  'fr',
		     weekStart: 1,
		     todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
		     showMeridian: 1
		 }); */

		$(".years").datetimepicker({
			format : "yyyy",
			startView : 'decade',
			minView : 'decade',
			viewSelect : 'decade',
			autoclose : true,
		});
	</script>






</body>
</html>