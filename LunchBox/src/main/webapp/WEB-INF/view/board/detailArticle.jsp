<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<script src="../assets/js/color-modes.js"></script>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
<title>게시글 읽기</title>
<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/blog/">

    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
  	<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
  	<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/detailArticle.css?after"/>
</head>
<body class="bg-body-tertiary">
   <svg xmlns="http://www.w3.org/2000/svg" class="d-none">
      <symbol id="check2" viewBox="0 0 16 16">
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
      </symbol>
      <symbol id="circle-half" viewBox="0 0 16 16">
        <path d="M8 15A7 7 0 1 0 8 1v14zm0 1A8 8 0 1 1 8 0a8 8 0 0 1 0 16z"/>
      </symbol>
      <symbol id="moon-stars-fill" viewBox="0 0 16 16">
        <path d="M6 .278a.768.768 0 0 1 .08.858 7.208 7.208 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277.527 0 1.04-.055 1.533-.16a.787.787 0 0 1 .81.316.733.733 0 0 1-.031.893A8.349 8.349 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.752.752 0 0 1 6 .278z"/>
        <path d="M10.794 3.148a.217.217 0 0 1 .412 0l.387 1.162c.173.518.579.924 1.097 1.097l1.162.387a.217.217 0 0 1 0 .412l-1.162.387a1.734 1.734 0 0 0-1.097 1.097l-.387 1.162a.217.217 0 0 1-.412 0l-.387-1.162A1.734 1.734 0 0 0 9.31 6.593l-1.162-.387a.217.217 0 0 1 0-.412l1.162-.387a1.734 1.734 0 0 0 1.097-1.097l.387-1.162zM13.863.099a.145.145 0 0 1 .274 0l.258.774c.115.346.386.617.732.732l.774.258a.145.145 0 0 1 0 .274l-.774.258a1.156 1.156 0 0 0-.732.732l-.258.774a.145.145 0 0 1-.274 0l-.258-.774a1.156 1.156 0 0 0-.732-.732l-.774-.258a.145.145 0 0 1 0-.274l.774-.258c.346-.115.617-.386.732-.732L13.863.1z"/>
      </symbol>
      <symbol id="sun-fill" viewBox="0 0 16 16">
        <path d="M8 12a4 4 0 1 0 0-8 4 4 0 0 0 0 8zM8 0a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 0zm0 13a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-1 0v-2A.5.5 0 0 1 8 13zm8-5a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2a.5.5 0 0 1 .5.5zM3 8a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1h2A.5.5 0 0 1 3 8zm10.657-5.657a.5.5 0 0 1 0 .707l-1.414 1.415a.5.5 0 1 1-.707-.708l1.414-1.414a.5.5 0 0 1 .707 0zm-9.193 9.193a.5.5 0 0 1 0 .707L3.05 13.657a.5.5 0 0 1-.707-.707l1.414-1.414a.5.5 0 0 1 .707 0zm9.193 2.121a.5.5 0 0 1-.707 0l-1.414-1.414a.5.5 0 0 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .707zM4.464 4.465a.5.5 0 0 1-.707 0L2.343 3.05a.5.5 0 1 1 .707-.707l1.414 1.414a.5.5 0 0 1 0 .708z"/>
      </symbol>
    </svg>
    
<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
  <symbol id="aperture" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24">
    <circle cx="12" cy="12" r="10"/>
    <path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/>
  </symbol>
  <symbol id="cart" viewBox="0 0 16 16">
    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
  </symbol>
  <symbol id="chevron-right" viewBox="0 0 16 16">
    <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
  </symbol>
</svg>

<div class="container">
  <header class="border-bottom lh-1 py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 pt-1">
      </div>
      <div class="col-4 text-center">
        <a class="blog-header-logo text-body-emphasis text-decoration-none" href="/">LunchBox</a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
      <c:if test = "${!empty authInfo}">
         <a class="btn btn-sm btn-outline-secondary" href="/register/step1">${authInfo.memId}님</a>
         <a class="btn btn-sm btn-outline-secondary" href="/myPage/myInfo">마이페이지</a> 
         <a class="btn btn-sm btn-outline-secondary" href="/logout">로그아웃</a>
      </c:if> 
      <c:if test = "${empty authInfo}">
      	<a class="btn btn-sm btn-outline-secondary" href="/login">로그인</a>
        <a class="btn btn-sm btn-outline-secondary" href="/register/step1">회원가입</a>
	  </c:if>
	   </div>
    	</div>
	  </header>
	<div class="nav-scroller py-1 mb-3 border-bottom">
    <nav class="nav nav-underline justify-content-between">
      <a class="nav-item nav-link link-body-emphasis active" href="#">런치박스</a>
      <a class="nav-item nav-link link-body-emphasis active" href="/menu">메뉴</a>
      <a class="nav-item nav-link link-body-emphasis active" href="/order">주문하기</a>
      <a class="nav-item nav-link link-body-emphasis active" href="/review/list">후기</a>
      <a class="nav-item nav-link link-body-emphasis active" href="/board/proposal">건의</a>
      <a class="nav-item nav-link link-body-emphasis active" href="/notice/list">공지사항</a>
      
    </nav>
  </div>
</div>
<div class ="board">
<div class = "boardTitle">
	<h2>건의 게시판</h2>
</div>
<section class="boardView">
<header>
<h3 class="title"><c:out value='${detailArticle.articleTitle}'></c:out></h3>
조회수 ${detailArticle.articleHits}
</header>
<article class = "boardViewDetail">
<div class = inner>
<div calss="detail">
<p class="memId">${detailArticle.memId}</p>
<p class ="regDate"><td><tf:formatDateTime value="${detailArticle.articleRegDate}" pattern="yyyy-MM-dd "/></td></p>
</div>
<h3 class = "boardTitle2"><c:out value='${detailArticle.articleTitle}'></c:out></h3>
<hr  class="hr">
<p class="articleNo">No.${articleNo}</p>
<p class="boardContent">
<u:pre value='${detailArticle.articleContent}'/>
</p>
</div>
</article> 
<div class="btn-bottom">
<ul>
		<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
		<li class="btn-list"><a href="${pageContext.request.contextPath}/board/proposal?pageNo=${pageNo}">목록</a></li>
		
		<c:if test="${authInfo.memId == detailArticle.memId}">
		<li class="btn-list"><a href="${pageContext.request.contextPath}/board/modify?articleNo=${detailArticle.articleNo}">수정</a></li>
		</c:if>
		<c:if test="${authInfo.memId == detailArticle.memId || memberSession.memTypeNo==11}">
		<li class="btn-list"><a href="${pageContext.request.contextPath}/board/delete?articleNo=${detailArticle.articleNo}">삭제</a></li>
		</c:if>
</ul>
</div>
</section>
</div>
</body>
</html>