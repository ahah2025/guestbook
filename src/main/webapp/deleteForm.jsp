<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.javaex.vo.GbookVO" %>

<%
	GbookVO gbookVO = (GbookVO)request.getAttribute("gVO");
%>
    
<% //자바문법

	System.out.println("손님 정보를 수정하는 jsp");

%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>주소록</h1>
		
		<h2>손님 정보 수정</h2>
		<p>손님 정보를 수정하는 폼 입니다.</p>
		<form action="http://localhost:8080/guestbook/gbc" method="get">
			<table>
				<tr>
					<td>식별번호</td>
					<td><input type="text" name=""></td>
					<td><button type="submit">삭제</button></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name=""></td>
					<td><button type="submit">삭제</button></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name=""></td>
					<td><button type="submit">삭제</button></td>
				</tr>
				<tr>
					<td>본문</td>
					<td><input type="content" name=""></td>
					<td><button type="submit">삭제</button></td>
				</tr>
				<tr>
					<td>등록일</td>
					<td><input type="regDate" name=""></td>
					<td><button type="submit">삭제</button></td>
				</tr>
			</table>
		</form>
		
		<br><br>
		<a href="">메인으로 돌아가기</a>
		<a href="http://localhost:8080/guestbook/gbc?action=list"></a>
	</body>
</html>