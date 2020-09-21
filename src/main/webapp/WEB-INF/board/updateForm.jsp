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
<form action="update" method="post">
	<table class="table table-striped" style="width: 400px;">
		<caption>게시판 글쓰기</caption>
		<tr>
			<th>작성자</th>
			<td>
				<input type="text" name="writer" class="form-control" value="${dto.writer }">
			</td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" class="form-control" value="${dto.subject }">
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2">
				<textarea rows="10" cols="40" name="content"
				class="form-control">	
				${dto.content }			
				</textarea>
			</td>
		</tr>
		
		<tr>			
			<td colspan="2" align="center">
			<input type="hidden" name="num" value="${dto.num }" />
			<input type="hidden" name="pageNum" value="${pageNum }">
				<button class="btn btn-default btn-lg"
				type="submit">수정하기</button>
			</td>
		</tr>
		
	</table>
</form>
</body>
</html>