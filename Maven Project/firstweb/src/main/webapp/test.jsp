<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="firstweb.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert Title here</title>
</head>
<body>

<%
	Product result = (Product)request.getAttribute("result"); /* ต้องสอดคล้องกับ setAttribute ใน Controller 
	และต้อง Casting and import*/	
%>
	<br><%=result.getProductName() %>
	<br><%=result.getProductDetail() %>
	<br><%=result.getPrice() %> บาท
<select>

</select>

</body>
</html>