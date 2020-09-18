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
<form action="upload" method="post" enctype="multipart/form-data">
	<table style="width: 400px;" class="table table-bordered">
		<caption><b>이미지업로드 연습</b></caption>	
		<tr>
			<th style="width: 150px;">메세지</th>		
			<td>
				<input type="text" name="msg" class="form-control">
			</td>
		</tr>
		<tr>
			<th style="width: 150px;">이미지</th>
			<td>
				<input type="file" name="photo" class="form-control">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-danger">이미지 업로드 하기</button>
			</td>
		</tr>		
	</table>
</form>
</body>
</html>