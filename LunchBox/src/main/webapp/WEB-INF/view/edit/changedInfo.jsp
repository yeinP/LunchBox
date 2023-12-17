<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>정보 수정 완료</title>
</head>
<body>
    <p>
        정보를 수정했습니다.
    </p>
    <p>
     <button type="button" onclick="location.href='${pageContext.request.contextPath}/main';"><spring:message code="go.main" /></button>
   	 <button type="button" onclick="location.href='${pageContext.request.contextPath}/myPage/myInfo';"><spring:message code="myPage"/></button>
    </p>
</body>
</html>
