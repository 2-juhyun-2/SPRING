<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="<%=request.getContextPath() %>"></c:set>
<meta charset="utf-8">
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<button type="button" class="btn btn-info"
style="width: 100px; margin-left: 500px;"
onclick="location.href=${path}/member/insertform">회원가입</button>

<br><br>
<div class="container">
<table class="table table-bordered">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>가입날짜</th>
		<th>편집</th>
	</tr>
	<c:forEach var="a" items="${list }" varStatus="i">
		<tr>
			<td>${i.count}</td>
			<td>${a.name}</td>
			<td>${a.id}</td>
			<td>${a.pass}</td>
			<td><fmt:formatDate value="${a.gaipday }"
				pattern="yyyy-MM-dd HH:mm"/></td>
			<td><a href="updateform?num=${a.num }">수정</a>/
				<a href="delete?num=${a.num }">삭제</a></td>	
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>