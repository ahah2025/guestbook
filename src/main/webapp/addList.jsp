<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"    %>    
<%@ page import="com.javaex.vo.GbookVO"  %>

<% //자바문법
	List<GbookVO> gbookList = (List<GbookVO>)request.getAttribute("gList");
	
    System.out.println("여기는 jsp");
    System.out.println(gbookList);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form>
		<h1>guest</h1>
		
		<h2>guest 리스트</h2>
		<p>guest 리스트입니다.</p>
		
		<%
			for(int i=0; i<gbookList.size(); i++){
		%>
		
		<table border="1" width="540px">
			<tr>
				<td>이름</td><td><input type="text" name=""></td>
				<td>비밀번호</td><td><input type="password" name=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols="72" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="">등록</button></td>
			</tr>
		</table>
	</form>
	<br>

	
	<table border="1" width="540px">
		<tr>
			<td>[1]</td>
			<td>이효리</td>
			<td>2022-01-01</td>
			<td><a href="">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">방문하고 갑니다.</td>
		</tr>
	</table>
	<br>
	
	<table border="1" width="540px">
		<tr>
			<td>[2]</td>
			<td>유재석</td>
			<td>2022-02-02</td>
			<td><a href="">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">방문하고 갑니다.</td>
		</tr>
	</table>
	<br>

	<table border="1" width="540px">
		<tr>
			<td>[3]</td>
			<td>강호동</td>
			<td>2021-11-10</td>
			<td><a href="">삭제</a></td>
		</tr>
		<tr>
			<td colspan="4">방문하고 갑니다.</td>
		</tr>
		<tr>
			<td>[수정폼으로 이동]</td>
			<td><a href="http://localhost:8080/guestbook/gbc?action=delete&no=1">[삭제]</a></td>
		</tr>
	</table>
	<br>
	
	<%
	}
	%>
	
	[주소록 작성폼 이동] : 주소창에 <br>
	http://localhost:8080/phonebook2/pbc?action=wform
				
	<br>입력하시고 엔터입력
		
	<a href="http://localhost:8080/guestbook/gbc?action=add">주소록 작성폼 이동</a>
	</body>
</html>