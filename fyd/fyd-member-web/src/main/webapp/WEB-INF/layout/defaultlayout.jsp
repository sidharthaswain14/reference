<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>
			<tiles:getAsString name="title" />
		</title>
	</head>
	<body>
		<table>
			<tr>
				<td>
					<tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr>
				<td colspan="2" width="40%">
					<tiles:insertAttribute name="leftnavigation" />
				</td>
				<td>
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
			<tr>
				<td>
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</table>
	</body>
</html>