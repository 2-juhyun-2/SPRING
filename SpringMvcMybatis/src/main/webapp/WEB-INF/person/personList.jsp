<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>

<h1></h1>
<b style="color: magenta">총${cnt}개의 데이터가 있습니다</b>
<hr>
<a href="personform">자료추가하기</a>
<div class="container">
<table class="table table-striped">
	<tr bgcolor="lightgray">
		<th width="100">번호</th>
		<th width="100">이름</th>
		<th width="100">나이</th>
		<th width="300">주소</th>
		<th width="200">작성일</th>
		<th width="150">편집</th>	
	</tr>
	
	<!-- list dto를 변수로 반복문으로 출력 -->
	<c:forEach var="dto" items="${list }" varStatus="i">
		<tr>
			<td align="center">${i.count }</td>
			<td align="center">${dto.name }</td>
			<td align="center">${dto.age }</td>
			<td align="center">${dto.addr }</td>
			<td align="center"><fmt:formatDate value="${dto.sdate }" pattern="yyyy-MM-dd HH:mm"/></td>
			<td align="center"><a href="updateform?num=${dto.num }">수정</a>
			/<a href="delete?num=${dto.num }">삭제</a></td>
			
			
				
	</c:forEach>

</table>
</div>

</body>

</html>