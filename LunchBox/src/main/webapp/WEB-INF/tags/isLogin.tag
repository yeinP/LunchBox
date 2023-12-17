<%@ tag body-content="scriptless" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%
	HttpSession httpSession = request.getSession(false);
	if (httpSession != null && httpSession.getAttribute("authInfo") != null) {
%>
<jsp:doBody />
<%
	}
%>