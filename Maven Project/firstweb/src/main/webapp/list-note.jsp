<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Note" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	ArrayList<Note> list = (ArrayList<Note>)request.getAttribute("list");
	for(Note note: list){
		out.println("<li>" + note.getDetail() + "</li>");
	}
%>

</body>
</html>