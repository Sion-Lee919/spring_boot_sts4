<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if (session.getAttribute("sessionid")!=null){ %>
<%=session.getAttribute("sessionid") %> 회원님 로그인중입니다<br>
<%}
else {
%>
로그인한적이 없습니다
<%
}
%>
<h3>
	<ul>
		<li><a href="boardlist">게시물리스트 보러가기</a>(로그인필요없습니다)</li>
		<li><a href="boardwrite">글쓰기</a>(로그인하셔야합니다)</li>
		<li><a href="boardlogin">로그인</a></li>
		<li><a href="boardlogout">로그아웃</a></li>
	</ul>

</h3>
</body>
</html>