<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <script src="../assets/js/color-modes.js"></script>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
    <title>주문하기</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">
    
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/orderPage.css" rel="stylesheet">
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
<div class="container">
  <main>
    <div class="py-5 text-center">
      <a href="/"><img class="d-block mx-auto mb-4" src="/css/meal.png" alt="" width="72" height="57"></a>
      <h2>메뉴 수량을 선택해 주세요.</h2>
      <p class="lead">런치박스는 고객님의 소중한 식사를 안전하고 빠르게 제공할 수 있도록 노력하고 있습니다.</p>
    </div>
    <div class="row g-5">
      <div class="col-md-12 col-lg-12 order-md-last"></div>
        <h4 class="d-flex justify-content-between align-items-center mb-3">
          <span class="text-primary">메뉴 및 수량 선택</span>
        </h4>


  <form method="post">
  <div id="order">
  <table class="order">
  <colgroup>
  <col width="60em">
  <col width="500em">
  <col width="200em">
  </colgroup>
  <tr>
  <td colspan="3" align="left"><input type="checkbox" id="chk_click" name="chk_click" value="1"><span>전체선택</span></td>
  </tr>
  <tr>
  	<th>선택</th>
  	<th>상품명</th>
  	<th>수량 변경</th>
  </tr>
  	<tr>
  		
  		<td><input type="checkbox"  id="checkbox" name="basic" value="1"></td>
  		<td>베이직_간단 한끼</td>
  		<td>
  		<button type ="button" onclick="basicCount('p',this);">+</button>
      	<input type="text" class="ck" name="basicAmount" min="0" value="0" >
       	<button type="button" onclick="basicCount('m', this);">-</button>
  		</td>
  	</tr>
  		
  	<tr>
  		
  		<td><input type="checkbox" id="checkbox" name="goodMeal" value="2"></td>
  		<td>굿밀_균형 한끼</td>
  		<td>
  		<button type ="button" onclick="goodCount('p',this);">+</button>
      	 <input type="text" class="ck" name="goodMealAmount" min="0"  value="0">
       <button type="button" onclick="goodCount('m', this);">-</button>
  		</td>
  	</tr>
  	<tr>	
  		<td><input type="checkbox"  id="checkbox" name="happy" value="3"></td>
  		<td>해피_반찬 세트</td>
  		<td>
  		<button type ="button" onclick="happyCount('p',this);">+</button>
      <input type="text" class="ck" name="happyAmount"  min="0"  value="0">
       <button type="button" onclick="happyCount('m', this);">-</button>
  		</td>
  	</tr>
  	<tr>
  		
  		<td><input type="checkbox"  id="checkbox" name="one" value="4"></td>
  		<td>구독: 1 week</td>
  		<td>
  		<button type ="button" onclick="oneCount('p',this);">+</button>
      	<input type="text" class="ck" name="oneAmount" min="0" value="0" >
       	<button type="button" onclick="oneCount('m', this);">-</button>
  		</td>
  	</tr>
  		
  	<tr>
  		
  		<td><input type="checkbox" id="checkbox" name="two" value="5"></td>
  		<td>구독: 2 week</td>
  		<td>
  		<button type ="button" onclick="twoCount('p',this);">+</button>
      	 <input type="text" class="ck" name="twoAmount" min="0"  value="0">
       <button type="button" onclick="twoCount('m', this);">-</button>
  		</td>
  	</tr>
  	<tr>	
  		<td><input type="checkbox"  id="checkbox" name="month" value="6"></td>
  		<td>구독: 1 month</td>
  		<td>
  		<button type ="button" onclick="monthCount('p',this);">+</button>
      <input type="text" class="ck" name="monthAmount"  min="0"  value="0">
       <button type="button" onclick="monthCount('m', this);">-</button>
  		</td>
  	</tr>
      </table>
      </div>
      <div class="button">
      <button type="submit" class="bt" id="cartbt" formaction="${pageContext.request.contextPath}/cart/myCart">장바구니</button>
      <button type="submit" class="bt" formaction="${pageContext.request.contextPath}/">메인</button>
      </div>
      </form>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
      <script>
    
      function basicCount(type, ths){
    	    var $input = $(ths).parents("td").find("input[name='basicAmount']");
    	    var tCount = Number($input.val());
    	    
    	    if(type=='p'){
    	       $input.val(Number(tCount)+1);
    	    }else{
    	        if(tCount >0) $input.val(Number(tCount)-1);    
    	    }
    	}
      
      function goodCount(type, ths){
  	    var $input = $(ths).parents("td").find("input[name='goodMealAmount']");
  	    var tCount = Number($input.val());
  	    
  	    
  	    if(type=='p'){
  	       $input.val(Number(tCount)+1);
  	        
  	    }else{
  	        if(tCount >0) $input.val(Number(tCount)-1);    
  	        }
  	}
      
      function happyCount(type, ths){
    	    var $input = $(ths).parents("td").find("input[name='happyAmount']");
    	    var tCount = Number($input.val());
    	    
    	    
    	    if(type=='p'){
    	       $input.val(Number(tCount)+1);
    	        
    	    }else{
    	        if(tCount >0) $input.val(Number(tCount)-1);    
    	        }
    	}
      function oneCount(type, ths){
  	    var $input = $(ths).parents("td").find("input[name='oneAmount']");
  	    var tCount = Number($input.val());
  	    
  	    
  	    if(type=='p'){
  	       $input.val(Number(tCount)+1);
  	        
  	    }else{
  	        if(tCount >0) $input.val(Number(tCount)-1);    
  	        }
  	}
      function twoCount(type, ths){
  	    var $input = $(ths).parents("td").find("input[name='twoAmount']");
  	    var tCount = Number($input.val());
  	    
  	    
  	    if(type=='p'){
  	       $input.val(Number(tCount)+1);
  	        
  	    }else{
  	        if(tCount >0) $input.val(Number(tCount)-1);    
  	        }
  	}
      function monthCount(type, ths){
  	    var $input = $(ths).parents("td").find("input[name='monthAmount']");
  	    var tCount = Number($input.val());
  	    
  	    
  	    if(type=='p'){
  	       $input.val(Number(tCount)+1);
  	        
  	    }else{
  	        if(tCount >0) $input.val(Number(tCount)-1);    
  	        }
  	}
      
     
      $("#chk_click").click( function() {
  		if($("#chk_click").is(":checked")) $("input[id=checkbox]").prop("checked", true);
  		else $("input[id=checkbox]").prop("checked", false);
  	});

  	$("input[id=checkbox]").click(function() {
  		var total = $("input[id=checkbox]").length;
  		var checked = $("input[id=checkbox]:checked").length;

  		if(total != checked) $("#chk_click").prop("checked", false);
  		else $("#chk_click").prop("checked", true); 
  	});
  	
  	$("#cartbt").click(function() {
  		const checkbox = document.querySelector('.order');
  		const checkboxes = checkbox.querySelectorAll('input[id="checkbox"]')
  		for (let i = 0; i<checkboxes.length ; i ++ ) {
  			if(checkboxes[i].checked === true) return;
  		}
  		alert("상품을 선택해주세요")
  		return false;		
  	});
  	
 
  	
  	
 

  

  </script>
</body>
</html>