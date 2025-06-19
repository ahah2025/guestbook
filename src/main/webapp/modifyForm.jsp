<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.javaex.vo.GbookVO" %>

<%
	GbookVO gbookVO = (GbookVO)request.getAttribute("gVO");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>주소록</h1>
	
		<h2>게스트 등록폼</h2>
		<p>게스트를 등록하는 폼 입니다.</p>
		<%
			System.out.println("게스트를 등록하는 폼입니다.");
		
		%>
		<form action="http://localhost:8080/guestbook/gbc"  method="get">
			
		
			<label>이름(name)</label>
			<input type="text" name="name" value="<%=gbookVO.getName()%>">
			<input type="text" name="action" value="modify">
			<br>
			
			<label>비밀번호(password)</label>
			<input type="text" name="hp" value="<%=gbookVO.getPassword()%>">
			<input type="text" name="action" value="modify">
			<br>
	
			<label>본문(content)</label>
			<input type="text" name="company" value="<%=gbookVO.getContent()%>">
			<input type="text" name="action" value="modify">
			<br>
			
			<label>등록일(regDate)</label>
			<input type="text" name="no" value="<%=gbookVO.getRegDate()%>">
			<input type="text" name="action" value="modify">
			<br>
			
			<label>액션</label>
			<input type="text" name="no" value="<%=gbookVO.getNo()%>">
			<input type="text" name="action" value="modify">
			<br>
			
			<button>등록</button>
		</form>
	</body>
</html>