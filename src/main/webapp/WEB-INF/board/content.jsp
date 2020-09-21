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
<table style="width: 500px;" class="table table-bordered">
	<tr>
		<th>
			${dto.subject }
			<span style="margin-left: 200px; color: gray;">
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
			</span>
		</th>
	</tr>
	<tr>
		<td>
		작성자: ${dto.writer }
			<span style="margin-left: 300px; color: gray">조회: ${dto.readcount }</span>
			<br>
			<pre><span>${dto.content }</span></pre>
		</td>	
	</tr>
</table>
<!-- 수정,삭제,목록 버튼들 -->

<div>
<button type="button" class="btn btn-info btn-sm" style="width: 80px;"
onclick="location.href='${path}/board/list?pageNum=${pageNum }'">목록</button>

<button type="button" class="btn btn-danger btn-sm" style="width: 80px;"
onclick="location.href='${path}/board/writeform?pageNum=${pageNum }'">글쓰기</button>

<button type="button" class="btn btn-success btn-sm" style="width: 80px;"
onclick="location.href='${path}/board/updateform?num=${dto.num }&pageNum=${pageNum }'">수정</button>

<button type="button" class="btn btn-info btn-sm" style="width: 80px;"
onclick="location.href='${path}/board/delete?num=${dto.num }&pageNum=${pageNum }'">삭제</button>

</div>
</body>
</html>