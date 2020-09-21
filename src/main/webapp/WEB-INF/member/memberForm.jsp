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
<form action="${path }/member/insert" method="post">
	<table class="table table-hover" style="width: 400px;">
		<caption>[회원가입]</caption>
			<tr>
				<th>회원명</th>
				<td>
					<input type="text" size="10" name="name"
					autofocus="autofocus" required="required"
					class="form-cotrol">
				</td>	
			</tr>
			
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" size="15" name="id"
					required="required"
					class="form-cotrol">
				</td>	
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" size="15" name="pass"
					required="required"
					class="form-cotrol" >
				</td>	
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원가입"
					class="btn btn-info">
					<input type="button" value="회원목록"
					class="btn btn-info"
					onclick="location.href='${path }/member/list'">
				</td>	
			</tr>
			
	</table>
</form>
</body>
</html>