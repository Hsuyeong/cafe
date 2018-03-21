<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Join page</title>
<script		type="text/javascript" 
			src="<c:url value="/static/js/jquery-3.3.1.min.js" />"></script>
<script type="text/javascript">
	$().ready(function() {		
		$("#joinBtn").click(function(){		
			$("#joinForm").attr({
				"action":"<c:url value="/join" />",
				"method":"post"
			}).submit();
		});		
	});
</script>
</head>
<body>

	<form id="joinForm">

		<div>
			<input type="text" id="userId" name="userId" placeholder="아이디를 입력하세요."/>
		</div>
		<div>
			<input type="text" id="userNickname" name="userNickname" placeholder="별칭을 입력하세요."/>
		</div>
		<div>
			<input type="password" id="userPassword" name="userPassword" placeholder="비밀번호를 입력하세요."/>
		</div>
		<div>
			<input type="text" id="phoneNumber" name="phoneNumber" placeholder="핸드폰 번호를 (-) 없이 입력하세요."/>
		</div>
		<div>
			<input type="button" id="joinBtn" value="join"/>
		</div>		
	</form>	

</body>
</html>