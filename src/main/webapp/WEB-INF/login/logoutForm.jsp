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
<div style="position: absolute; left: 200px; top: 150px;">
${name}님이 로그인 중입니다 &nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="로그아웃"
onclick="location.href='${path }/login/logout'">
</div>
<img alt="" src="${path }/image/b7.png">
</body>
</html>