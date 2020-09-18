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
<div class="container">
	<form action="update">
		<table class="table table-hover" style="width: 350px;">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" size="7" class="control-form"
					value="${dto.name }">
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<input type="text" name="age" size="5" class="control-form"
					value="${dto.age }">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="addr" size="10" class="control-form"
					value="${dto.addr }">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<!-- num hidden으로 넘기기 -->
		 		<input type="hidden" name="num" value="${dto.num }">
		 			
					<button type="submit" value="수정" class="btn btn-danger">수정완료</button>
				
				</td>
			</tr>
		
		
		</table>	
	</form>
</div>
<h1></h1>
</body>
</html>