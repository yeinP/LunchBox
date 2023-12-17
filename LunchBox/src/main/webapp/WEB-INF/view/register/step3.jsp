<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="member.register" /></title>
</head>
<body>
    <p>
        <spring:message code="register.done">
        	<spring:argument value="${registerRequest.memName}" />
        	<spring:argument value="${registerRequest.memId}" />
        </spring:message>
    </p>
    <p>
       <button type="button" onclick="location.href='${pageContext.request.contextPath}/';"><spring:message code="go.main" /></button>
        
    </p>
</body>
</html>
