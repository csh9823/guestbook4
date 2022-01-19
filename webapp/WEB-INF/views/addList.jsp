<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook4/guest/add" method="get">
		<table border="1" width="500px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""> <input type="hidden" name="action" value="add"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea name="content" cols="65" rows="5"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<button type="submit">글작성</button>
				</td>
			</tr>
		</table>
	</form>


	<br>


	<c:forEach items="${requestScope.guestbookList}" var="gList">
		<table border="1" width="500px">
			<tr>
				<td>${gList.no}</td>
				<td>${gList.name}</td>
				<td>${gList.regDate}</td>
				<td><a href="/guestbook4/guest/deleteForm?no=${gList.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">${gList.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>

</body>
</body>
</html>