<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head><head>
    <script src="../assets/js/color-modes.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
    <title><spring:message code="member.register" /></title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">

    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    
    <!-- Custom styles for this template -->
    <link href="../css/step1.css" rel="stylesheet">

</head>
<body class="bg-body-tertiary">
  <div  class="container">
  <main>
    <div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="/css/meal.png" alt="" width="72" height="57">
      <h2>LunchBox</h2>
      <p class="lead">환영합니다.</p>
    </div>
    
   <form action="step2" method="post" id="joinForm">
            <ul class="join_box">
                <li class="checkBox check01">
                    <ul class="clearfix">
                        <li>이용약관, 개인정보 수집 및 이용,
                            위치정보 이용약관(선택), 프로모션 안내
                            메일 수신(선택)에 모두 동의합니다.</li>
                        <li class="checkAllBtn">
                            <input type="checkbox" name="Allagree" id="cbx_chkAll" class="chkAll">
                        </li>
                    </ul>
                </li>
                <li class="checkBox check02">
                    <ul class="clearfix">
                        <li>이용약관 동의(필수)</li>
                        <li class="checkBtn">
                            <input type="checkbox" name="agree1" id="agree"> 
                        </li>
                    </ul>
                    <textarea name="" id="">여러분을 환영합니다.
LunchBox 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 LunchBox 주식회사(이하 ‘LunchBox’)와 이를 이용하는 LunchBox 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       </textarea>
                </li>
                <li class="checkBox check03">
                    <ul class="clearfix">
                        <li>개인정보 수집 및 이용에 대한 안내(필수)</li>
                        <li class="checkBtn">
                            <input type="checkbox" name="agree2" id="agree">
                        </li>
                    </ul>
 
                    <textarea name="" id="">여러분을 환영합니다.
LunchBox 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 LunchBox 주식회사(이하 ‘LunchBox’)와 이를 이용하는 LunchBox 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       </textarea>
                </li>
                <li class="checkBox check03">
                    <ul class="clearfix">
                        <li>위치정보 이용약관 동의(선택)</li>
                        <li class="checkBtn">
                            <input type="checkbox" name="agree" id="agree">
                        </li>
                    </ul>
 
                    <textarea name="" id="">여러분을 환영합니다.
LunchBox 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 LunchBox 주식회사(이하 ‘LunchBox’)와 이를 이용하는 LunchBox 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 네이버 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
       </textarea>
                </li>
                <li class="checkBox check04">
                    <ul class="clearfix">
                        <li>이벤트 등 프로모션 알림 메일 수신(선택)</li>
                        <li class="checkBtn">
                            <input type="checkbox" name="agree" id="agree">
                        </li>
                    </ul>
 
                </li>
            </ul>
           
                <li><input type="submit"  class="w-100 btn btn-primary btn-lg" value="<spring:message code="next.btn" />" /></li>
          
        </form>
    </main>
 </div>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 <script>
 $(document).ready(function() {
	$("#cbx_chkAll").click(function() {
		if($("#cbx_chkAll").is(":checked")) $("input[id=agree]").prop("checked", true);
		else $("input[id=agree]").prop("checked", false);
	});

	$("input[id=agree]").click(function() {
		var total = $("input[id=agree]").length;
		var checked = $("input[id=agree]:checked").length;

		if(total != checked) $("#cbx_chkAll").prop("checked", false);
		else $("#cbx_chkAll").prop("checked", true); 
	});
});
 </script>
</body>
</html>
