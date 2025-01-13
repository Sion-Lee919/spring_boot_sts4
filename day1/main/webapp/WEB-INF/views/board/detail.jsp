<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src ="js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#deletebtn").on("click",function(){
		/* let userpw = prompt("글암호를 입력하세요") */
		$("#inputpw").html("<input type='password' id='userpw'><input type='button' id='checkpwbtn' value='암호확인'>")
		
		$("#checkpwbtn").on('click',function(){
			let userpw = $("#userpw").val();
			let dbpw = ${boarddetail.pw};
			if(userpw==dbpw){
				//alert("암호일치");
				$.ajax({
					url : 'boarddelete',
					data : {seq:'${boarddetail.seq}'},
					type : 'get',
					dataType : 'json',
					success : function(res){
						$("#inputpw").append("<h3>"+res.result+"</h3>");
					}
				});
			}
			else{
				alert("암호불일치");
			}			
		});
	});
	
	$("#listbtn").on('click',function(){
		location.href="/boardlist";
	});
	
	$("#updatebtn").on("click",function(){
		/* let userpw = prompt("글암호를 입력하세요") */
		$("#inputpw").html("<input type='password' id='userpw'><input type='button' id='checkpwbtn' value='암호확인'>")
		
		$("#checkpwbtn").on('click',function(){
			let userpw = $("#userpw").val();
			let dbpw = ${boarddetail.pw};
			if(userpw==dbpw){
				$.ajax({
					url : 'boardupdate',
					data : $("form").serialize(),//{seq:'${boarddetail.seq}', title: $("input[name=title]").val(), contents:$("textarea[name=contents]").val()},
					type : 'get',
					dataType : 'json',
					success : function(res){
						$("#inputpw").append("<h3>"+res.result+"</h3>");
					}
				});
			}
			else{
				alert("암호불일치");
			}			
		});
	});
});
</script>
</head>
<body>
<h1>게시물</h1>
<form action="" >
<table border="2">
	<tr><th>번호</th><td><input type=text value="${boarddetail.seq }" readonly="readonly" name="seq"></td></tr>
	<tr><th>제목</th><td><input type="text" value="${boarddetail.title }" name ="title"></td></tr>
	<tr><th>내용</th><td><textarea cols=50 rows=5 name ="contents">${boarddetail.contents }</textarea></td></tr>
	<tr><th>작성자</th><td><input type="text" value="${boarddetail.writer }" readonly="readonly" name ="writer"></td></tr>
	<tr><th>조회수</th><td><input type="text" value="${boarddetail.viewcount }" readonly="readonly" name ="viewcount"></td></tr>
	<tr><th>작성시간</th><td><input type="text" value="${boarddetail.writingtime }" readonly="readonly" name ="writingtime"></td></tr>
	<tr><th>첨부파일명</th><td><a href='boarddownload?filename=${boarddetail.file1}'>${boarddetail.file1}</a></td></tr>
	<tr><th colspan="2" style="text-align: center;"><input type="button" id="updatebtn" value="수정버튼"><input type="button" id="deletebtn" value="삭제버튼"></th></tr>
</table>
</form>
<div id="inputpw"></div>

<input type="button" value="게시물리스트" id="listbtn">
</body>
</html>