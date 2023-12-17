<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="change.pwd.title" /></title>
</head>
<body>
    <p>
        <spring:message code="change.pwd.done" />
    </p>
    <p>
        <button type="button" onclick="location.href='${pageContext.request.contextPath}/';"><spring:message code="go.main" /></button>
    </p>
</body>
</html>
