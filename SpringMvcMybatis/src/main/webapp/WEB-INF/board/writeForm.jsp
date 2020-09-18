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
<h1></h1>
<form action="write" method="post">
	<table class="table table-striped" style="width: 400px;">
		<caption><b>글쓰기</b></caption>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" style="width: 100px"
					class="form-control input-sm">
				</td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject"  style="width: 300p;" 
					class="form-control input-sm" >
				</td>
			</tr>	
			
		 	<tr>
		 		<td colspan="2">
		 			<textarea style="width: 400px; height: 150px;"
		 			name="content" class="form-control">
		 			
		 			</textarea>
		 		</td>
		 	</tr>
		 	
		 	<tr>
		 		<td colspan="2" align="center">
		 			<button type="submit" class="btn btn-info">db에 저장</button>
		 		</td>
		 	</tr>
				
	</table></form>
</body>
</html>