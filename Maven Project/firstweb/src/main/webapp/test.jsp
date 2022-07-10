<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert Title here</title>
</head>
<body>

<select>
<%-- <%for(int i=2565; i >= 2499; i--){ %>
	<option>
		<% out.println(i); %>
	</option>
<% } %> --%>

<!-- OR -->

<%
int i;
for(i=2565; i >= 2499; i--){
	out.println("<option>" + i + "</option>");
}

%>
</select>
<br><b><%=i%></br></b>

</body>
</html>