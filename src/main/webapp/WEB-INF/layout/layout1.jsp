<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="<%=request.getContextPath() %>"></c:set>
<meta charset="utf-8">
 <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
	#top{/* id가 top인 */
		position: absolute; left: 0px; top: 10px; width: 1300px; height: 50px;
		text-align: center; 
	}
	
	#menu{/* id가 menu인 */
		position: absolute; left: 300px; top: 150px; width: 700px; height: 70px;
		text-align: center;
	}
	
	#body{
		position: absolute; left: 50px; top: 200px; width: 1200px; height: 500px;
		padding-left: 200px; overflow: auto;
			
	}
	
	#bottom{
		position: absolute; left: 0px; top: 2500px; width: 1300px; height: 80px;
		text-align:  center;
	}
}
	
</style>
<title>Insert title here</title>
</head>
<body>
<div id="top">
	<tiles:insertAttribute name="header"/>
</div>
<div id="menu">
	<tiles:insertAttribute name="menu"/>
</div>
<div id="body">
	<tiles:insertAttribute name="body"/>
</div>
<div id="bottom">
	<tiles:insertAttribute name="bottom"/>
</div>

</body>
</html>