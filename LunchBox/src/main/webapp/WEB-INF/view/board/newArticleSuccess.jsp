<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 등록</title>
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

게시글을 등록했습니다.
<br>
${ctxPath = pageContext.request.contextPath}<br/><br/>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/board/proposal';">목록 보기</button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/board/detail?articleNo=${newArticleNo}';">게시글 보기</button>
				
</body>
</html>