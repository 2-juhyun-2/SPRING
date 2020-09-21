<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<a href="insertform">데이터 추가</a><br><br>
<hr>
<table class="table table-striped" style="width: 400px;">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>편집</th>	
	</tr>
	
	<c:forEach var="a" items="${list }" varStatus="i">
		<tr>
			<td align="center">${i.count }</td>
			<td>${a.name }</td>
			<td>${a.addr }</td>
			<td><a href="updateform?num=${a.num }">수정</a>/<a href="delete?num=${a.num }">삭제</a></td>
		
		</tr>	
	</c:forEach>
</table>
</body>
</html>