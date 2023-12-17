<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Noto+Sans+KR:wght@300&display=swap')
	;

* {
	font-family: font-family : 'Gowun Dodum', sans-serif;
	font-family: 'Noto Sans KR', sans-serif;
}

a {
	text-decoration: none; /*밑줄*/
}
</style>
</head>
<body>
게시글을 삭제했습니다.
<button type="button" onclick="location.href='${pageContext.request.contextPath}/board/proposal';">목록</button>
</body>
</html>