<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
    <form:form modelAttribute="loginCommand">
    <form:errors />
    <p>
        <label><spring:message code="memId" />:<br>
        <form:input path="memId" />
        <form:errors path="memId"/>
        </label>
    </p>
    <p>
        <label><spring:message code="memPassword" />:<br>
        <form:password path="memPassword" />
        <form:errors path="memPassword"/>
        </label>
    </p>
    <p>
        <label><spring:message code="rememberId" />:
        <form:checkbox path="rememberId"/> 
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
    </form:form>
</body>
</html>
