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
<span class="alert alert-danger"><b>총 ${totalcount }개의 데이터가 있습니다</b></span>
<button type="button" class="btn btn-sm btn-info"
onclick="location.href='form'" style="margin-left: 400px">글쓰기</button>

<hr>
<c:forEach var="dto" items="${list }" varStatus="i">
<table class="table table-bordered" style="width: 400px">
	<tr>	
	<td>
	작성자: ${dto.writer }<br>
	작성일: <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
	<hr>
	${dto.photoname }
	<img alt="" src="save/${dto.photoname }" style="max-width: 300px;">
	<pre>${dto.content }</pre>
	</td>
	</tr>
	
	<tr>
	<td align="right">
	<button type="button" class="btn btn-danger"
	onclick="location.href='delete?num=${dto.num}'">delete</button>
	<button type="button" class="btn btn-info"
	onclick="location.href='updateform?num=${dto.num}'">update</button>
	
	</td>
	</tr>
	
</table>
<br><br>

</c:forEach>
</body>
</html>