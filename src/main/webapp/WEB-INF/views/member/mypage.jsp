<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
		<form action="/member/modify.kh" method="post">
			ID: <input type="text" name="member-id" value="${member.memberId}" readonly><br>
			PW: <input type="password" name="member-pw" ><br>
			NAME: <input type="text" name="member-name" value="${member.memberName}"><br>
			EMAIL: <input type="text" name="member-email" value="${member.memberEmail}"><br>
			PHONE: <input type="text" name="member-phone" value="${member.memberPhone}"><br>
			ADDRESS: <input type="text" name="member-addr" value="${member.memberAddr}"><br>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
	</body>
</html>