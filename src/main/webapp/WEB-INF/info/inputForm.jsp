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
<form action="insert">
	<table class="table table-borderd"  style="width: 800px">
	<caption>정보입력란</caption>
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" name="name" style="width: 100px;">
		</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			<input type="text" name="addr" style="width: 300px;">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="submit" class="btn btn-sm btn-danger">제출</button>
		</td>
	</tr>
	
	</table>
</form>
</body>
</html>