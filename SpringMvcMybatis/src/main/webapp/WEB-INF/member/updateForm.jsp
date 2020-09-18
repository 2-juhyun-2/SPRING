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
		<table class="table table-striped" style="width: 350px;">
			<caption>회원정보입력폼</caption>
			<tr>
				<th>회원명</th>
				<td>
					<input type="text" name="name" size="7" class="control-form" 
					value="${dto.name }">
				</td>
			</tr>
			<tr>
				<th>클래스명</th>
				<td>
					<input type="text" name="ban" size="15" class="control-form" 
					value="${dto.ban }">
				</td>
			</tr>
			<tr>
				<th>핸드폰</th>
				<td>
					<input type="text" name="hp" size="20" class="control-form" 
					value="${dto.hp }">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<!-- num hidden으로 넘기기 -->
		 		<input type="hidden" name="no" value="${dto.no}">
		 		
					<button type="submit" value="수정" class="btn btn-danger">수정완료</button>
					
				</td>
			</tr>
		
		
		</table>	
	</form>
</div>
<h1></h1>
</body>
</html>