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
<span class="alert alert-danger">
	<b>총 ${totalCount}개의 데이타가 있습니다</b>

</span>
<br>
<button type="button" class="btn btn-info"
onclick="location.href='writeform'" style="margin-left: 400px;">글쓰기</button>

<hr>

<div class="container">
<table class="table table-bordered" style="width: 700px;" >
	<tr>
		<th width="50">번호</th>
		<th width="200">제목</th>
		<th width="80">작성자</th>
		<th width="120">작성일</th>
	</tr>
	
	<c:forEach var="dto" items="${list }" varStatus="i">
		<tr>
			<td align="center">${i.count}</td>
			<td><a href="content?num=${dto.num }">${dto.subject }</a></td>
			<td>${dto.writer }</td>
			<td><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd"/></td>
		</tr>
	
	</c:forEach>

</table>
</div>
</body>
</html>