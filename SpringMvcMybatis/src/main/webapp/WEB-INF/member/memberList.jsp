<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<b style="color: magenta">총${cnt}개의 데이터가 있습니다</b>
<hr>
<a href="memberform">자료추가하기</a>
<table class="table table-bordered" style="width: 700px">
	<tr bgcolor="pink">
		<th>번호</th>
		<th>이름</th>
		<th>클래스</th>
		<th>핸드폰</th>
		<th>가입일자</th>
		<th>편집</th>
	</tr>
	<c:forEach var="dto" items="${list }" varStatus="i">
	<tr>
		<td align="center">${i.count}</td>
		<td>${dto.name }</td>
		<td>${dto.ban }</td>
		<td>${dto.hp }</td>
		<td><fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd"/></td>
		
		<td><a href="updateform?no=${dto.no }">수정</a>/
		<a href="delete?no=${dto.no }">삭제</a></td>
	
	</tr>
	
	</c:forEach>
	</table>

</body>
</html>