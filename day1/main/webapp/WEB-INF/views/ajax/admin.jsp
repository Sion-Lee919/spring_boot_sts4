<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#listbtn").on("click",function(){
		$.ajax({
			url : 'ajaxadminlist',
			data : {'id' : $("input[name=id]").val(),'pw':$("#pw").val()},
			type : 'get',
			dataType : 'json',
			success: function(response){
				$("#list").html("");
				for(let i=0; i <response.length; i++){
					$("#list").append("<h3>id=<a href=''>" + response[i].id+"</a></h3>");
					$("#list").append("<h3>name=" + response[i].name+"</h3>");
					$("#list").append("<h3>email=" + response[i].email+"</h3>");
					$("#list").append("<h3>phone=" + response[i].phone+"</h3>");
					$("#list").append("<h3>regdate=" + response[i].regdate+"</h3>");
				}
				
				$("#list").css("border","2px solid lime");
			},
			error : function(request, status,error){
				alert("코드=" +request.status+"\n메세지="+ request.responseText+"\n오류"+error);
			}
		});
	});
	
	$("#list").on("click","a",function(ev){
		ev.preventDefault();
		$.ajax({
			url : 'getpw/'+$(this).text(),
			type : 'get',
			dataType : 'json',
			success: function(response){
				$("#pwdiv").css("border","2px solid lime");
				$("#pwdiv").html("암호="+response.pw);
			},
			error : function(request, status,error){
				alert("코드=" +request.status+"\n메세지="+ request.responseText+"\n오류"+error);
			}
		});
	});
});
</script>
</head>
<body>
<form action="" method="post">
아이디<input type=text name="id" id="id"> <br>
비밀번호<input type=password  id="pw"> <br>
<input type=button id="listbtn" value="회원아이디리스트"> <br>
</form>
<!-- <a href=''>ajax1</a> 암호확인 <br>
<a href=''>ajax2</a> 암호확인 <br>
<a href=''>ajax3</a> 암호확인 <br>
<a href=''>ajax4</a> 암호확인 <br>
<a href=''>ajax5</a> 암호확인 <br>
<a href=''>ajax6</a> 암호확인 <br>
<a href=''>ajax7</a> 암호확인 <br>
<a href=''>ajax8</a> 암호확인 <br>
<a href=''>ajax9</a> 암호확인 <br>
<a href=''>ajax10</a> 암호확인 <br> -->
<div id="pwdiv"></div>
<div id="list"></div>
</body>
</html>