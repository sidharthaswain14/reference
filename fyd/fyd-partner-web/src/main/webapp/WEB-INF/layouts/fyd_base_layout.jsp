<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>Insert title here</title> -->

<style>
div.relative {
    position: relative;
    width: auto;
    height: 110px;
} 

div.absolute {
    position: absolute;
    top: 80px;
    right: 0;
    width: 200px;
    height: 100px;
    border: 3px solid #73AD21;
}
div.footer{
    position: relative;
    width: auto;
    height: auto;
    bottom: 50px

}
.bg-4 {
    background-color: #2f2f2f;
    color: #ffffff;
}
</style>

<%-- <body>

<div class="relative">
<tiles:insertAttribute name="header"/>
</div>

</head>

<div class="relative">
<tiles:insertAttribute name="body"/>

</div>

<!-- 
 <div class="footer">

</div>
 -->


</body>




<!-- <div class="footer navbar-fixed-bottom"> -->
<div class="footer navbar-fixed-bottom">
    <div class="container" >
<tiles:insertAttribute name="footer"/>
    </div>
</div>
 --%>

<body>
<table>
<tr class="container containerNew">
<tiles:insertAttribute name="header"/>
</tr>
</table>


<tiles:insertAttribute name="body"/>

<table>
<tr class="container containerNew">
<tiles:insertAttribute name="footer"/>
</tr>

</table>

</body>

</html>