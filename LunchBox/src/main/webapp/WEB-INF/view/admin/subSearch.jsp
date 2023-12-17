<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head><script src="../assets/js/color-modes.js"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
    <title>회원 정보 조회</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/blog/">

    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
  	<link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
  	<link href="../css/orderList.css" rel="stylesheet">
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
         <a class="btn btn-sm btn-outline-secondary" href="cart/myCart">${authInfo.memId}님</a>
         <a class="btn btn-sm btn-outline-secondary" href="myPage/myInfo">마이페이지</a> 
         <a class="btn btn-sm btn-outline-secondary" href="redirect:/main">로그아웃</a>
      </c:if> 
      <c:if test = "${empty authInfo}">
      	<a class="btn btn-sm btn-outline-secondary" href="/login">로그인</a>
        <a class="btn btn-sm btn-outline-secondary" href="register/step1">회원가입</a>
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
      <a class="nav-item nav-link link-body-emphasis active" href="notice/list">공지사항</a>
      
    </nav>
  </div>
</div>
<div id="container">
	<div class="admin">
		<div class="admin-1">
			<div id="admin">
				<div class="img">
					<img src="/img/admin.png" >
				</div>
				<div class="admininfo">
					<h3>[관리자] '${authInfo.memName}'님 페이지</h3>
				</div>
				<div class="list">
					<ul>
					<li><button type="button" class="bt" id="btMem" onclick="location.href='${pageContext.request.contextPath}/admin/memberList';">회원 관리</button></li>
					<li><button type="button" class="bt" id="btOrder" onclick="location.href='${pageContext.request.contextPath}/admin/orderList';">주문 관리</button></li>
					</ul>
				</div>
			</div>
		</div>
	
	<div class="membersinfo">
		<div style="margin-bottom:30px;">
			<button onclick="showOrderInfo() " style="width: 30%; color:white;"> 주문 정보 조회 </button>
			<button onclick="showSubInfo()" style="width: 30%; color:white;"> 구독 정보 조회 </button>
		</div>
		<div class="searchWrap" style="display:flex;">
					<form action = "/admin/subSearch" method="get">
						<input type="date" id = "date1" name = "searchDate" value = "${searchDate}">
			        	<input type="text" value="${keyword}" name = "keyword" id="keyword">
			        	<input type="submit" value="검색">
			        </form>
			    </div>
			<div class="subsinfoBox" style="display: none;" id="subsInfoDiv">
				<div class="subtableall">
					<c:if test="${!empty orderList}">
						<table>
							<colgroup>
								<col width="30%;">
								<col width="20%">
								<col width="40%">
								<col width="*%">
							</colgroup>
							 <tr>
								 <th>아이디</th>
								 <th>주문일</th>
								 <th>주문 상품</th>
								 <th>결제 금액</th>
							 </tr>
						 	<c:forEach var = "mem" items="${orderList}">
								 <tr>
									 <td>${mem.memId}</td>
									 <td><tf:formatDateTime value="${mem.orderDate}" pattern="yyyy.MM.dd"/></td>
									 <td>${mem.productName}</td>
									 <td>${mem.productPrice}</td>
								 </tr>
						  </c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	let btn = document.querySelector("#btMem");
	
	$("#btMem").on("click", function() {
		
	})
	
	

</script>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
function showOrderInfo() {
    // orderInfoDiv를 보이도록 변경
    document.getElementById("orderInfoDiv").style.display = "block";
    
    // subsInfoDiv를 숨김으로 변경
    document.getElementById("subsInfoDiv").style.display = "none";
}

function showSubInfo() {
    // orderInfoDiv를 숨김으로 변경
    document.getElementById("orderInfoDiv").style.display = "none";
    
    // subsInfoDiv를 보이도록 변경
    document.getElementById("subsInfoDiv").style.display = "block";
}

</script>
</body>
</html>