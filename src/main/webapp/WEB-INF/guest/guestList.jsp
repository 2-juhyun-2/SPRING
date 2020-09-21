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
<div>
	<button type="button" class="btn btn-success btn-sm"
	style="width: 100px;" onclick="location.href='form'">방명록 글쓰기</button>
</div>
<br>
<div>
	<b>총 ${totalCount }개의 방명록이 있습니다</b>
	<hr align="left" width="500" size="3" color="gray">
	<c:forEach var="dto" items="${list }">
		<b>no.${no }</b>
		<span style="margin-left: 400px;">추천
			<span style="color: red; font-weight: bold;" class="chu">${dto.chu }</span>
		</span><br>
		
		<c:set var="no" value="${no-1 }"/>
		<table class="table table-bordered" style="width: 500px;">
		<tr>
			<td>
			
			작성자: ${dto.writer }
			<span style="margin-left: 200px; ">
			
			<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
			
			
			</span><br><br>
			<pre>${dto.content}</pre><br>
			<c:if test="${dto.imagename!='noimage'}">
				
				<c:forTokens var="myimg" items="${dto.imagename}" delims=",">
				<a href="${path }/save/${myimg}"><img alt="" src="${path }/save/${myimg}" 
				style="max-width: 100px;" class="img-circle">
				<!-- "img-thumbnail","img-circle","img-rounded" -->
				 </a>
				
				</c:forTokens>
			</c:if>
			</td>	
		</table>
		
		<!-- 수정, 삭제 -->
		<span style="margin-left: 350px;">
			<button type="button" class="btn btn-success" style="width: 60px;"
			onclick="">수정</button>	
			<button type="button" class="btn btn-danger" style="width: 60px;"
			onclick="location.href='delete?num=${dto.num}&pageNum=${currentPage }'">삭제</button>	
		</span><br><br>
		
	</c:forEach>
	

	
	<!-- 요기에 페이징 처리  -->

<div style="width:1000px; text-align: center;">
	<ul class="pagination">
		<c:if test="${startPage>1 }">
			<li>
				<a href="list?pageNum=${startPage-1 }">◀ </a>
			
			</li>		
		</c:if>
	
	<c:forEach var="pp" begin="${startPage }" end="${endPage }">
		<li>
			<c:if test="${pp==currentPage }">
				<a href="list?pageNum=${pp}" style="color: red;">${pp }</a>
			</c:if>
			<c:if test="${pp!=currentPage }">
				<a href="list?pageNum=${pp}" style="color: black;">${pp }</a>
			</c:if>
		
		</li>
	
	</c:forEach>
	
	<c:if test="${endPage<totalPage }">
			<li>
				<a href="list?pageNum=${endPage+1 }">▶ </a>
			
			</li>
		
	</c:if>	
	
	</ul>
</div>
	

</body>
</html>