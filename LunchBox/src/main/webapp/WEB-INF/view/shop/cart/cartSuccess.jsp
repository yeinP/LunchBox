<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니에 담았습니다.</title>
</head>
<body>
장바구니에 담았습니다.
<button type="button" onclick="location.href='${pageContext.request.contextPath}/'">메인</button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/cart/myCart'">장바구니</button>
</body>
</html>