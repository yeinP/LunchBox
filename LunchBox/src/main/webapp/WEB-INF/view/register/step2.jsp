<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
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
    <link href="../css/step2.css" rel="stylesheet">

</head>
<body class="bg-body-tertiary">
       
<div class="container">
  <main>
    <div class="py-5 text-center">
      <img class="d-block mx-auto mb-4" src="/css/meal.png" alt="" width="72" height="57">
      <h2>LunchBox</h2>
      <p class="lead">환영합니다.</p>
    </div>

    <div class="row g-5">
      
      <div class="con">
        <h4 class="mb-3"><spring:message code="member.info" /></h4>
        <form:form action="step3" modelAttribute="registerRequest" class="needs-validation">
    
            <div class="col-12">
              <label for="firstName" class="form-label"><spring:message code="memId" /></label>
              <form:input path="memId" class="form-control" id="firstName" placeholder="Id" value=""/>
              <form:errors path="memId"/>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>

            <div class="col-12">
              <label for="lastName" class="form-label"><spring:message code="memName" /></label>
              <form:input path="memName" class="form-control" id="lastName" placeholder="Name" value=""/>
              <form:errors path="memName"/>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>

            <div class="col-12">
              <label for="memEmail" class="form-label"><spring:message code="memEmail" /></label>
                <form:input path="memEmail" class="form-control" id="memEmail" placeholder="Email(you@example.com)"/>
                <form:errors path="memEmail"/>
              <div class="invalid-feedback">
                  Your username is required.
             
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label"><spring:message code="memPassword" /><span class="text-body-secondary"></span></label>
              <form:password path="memPassword" class="form-control" id="email" placeholder="password"/>
              <form:errors path="memPassword"/>
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>

            <div class="col-12">
              <label for="confirmPassword" class="form-label"><spring:message code="password.confirm" /> <span class="text-body-secondary"></span></label>
              <form:password path="confirmPassword" class="form-control" id="confirmPassword" placeholder="Confirm Password"/>
              <form:errors path="confirmPassword"/>
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>
			<div>
			<label>주소</label>
				<button class="btn btn-primary" id="address_kakao">주소 검색</button>
				<div>
					<input type="text"  id="zip_code" name="zip_code" readonly="readonly" placeholder="우편번호" style="width:250px;">
					<input type="text"  id="addr" name="addr" readonly="readonly" placeholder="기본주소"  style="width:250px;">
					<input type="text"  id="addr_dtl" name="addr_dtl" placeholder="상세주소"  style="width:250px;">
				</div>
		</div>
            <!-- <div class="col-12">
              <label for="address" class="form-label"><spring:message code="memAddress" /></label>
              <form:input path="memAddress" class="form-control" id="address" placeholder="Address" />
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div> -->

            <div class="col-12">
              <label for="address" class="form-label"><spring:message code="memPhone" /></label>
              <form:input path="memPhone" class="form-control" id="memPhone" placeholder="Phone" />
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>



          <hr class="my-4">

          <h4 class="mb-3"><spring:message code="memTypeNo" /></h4>

          <div class="my-3">
            <div >
              <label class="form-check-label">
              <form:radiobuttons path="memTypeNo" items="${memTypeNoList}" itemLabel="memTypeName" itemValue="memTypeNo"  class="form-check-input" />
              </label>
            </div>
          </div>
          <div class="col-12" style="display: none;" id="adminPasswordDiv">
    		<label for="adminPassword" class="form-label">관리자 비밀번호</label>
    		<input type="password" class="form-control" id="adminPassword" placeholder="Admin Password" />
    		<span id="adminPasswordErrorMessage" style="color: red;"></span>
		  </div>
          

          
          <hr class="my-4">
          <input type="submit" class="submit" class="w-100 btn btn-primary btn-lg" value="<spring:message code="register.btn" />" >
        </form:form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-body-secondary text-center text-small">
    <p class="mb-1">&copy; 2017–2023 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
<script src = "//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!--<script src="checkout.js"></script>  --> 
<script>
window.onload = function() {

    document.getElementById("address_kakao").addEventListener("click", function() {
    	  new daum.Postcode({
              oncomplete: function(data) {
                  document.getElementById("zip_code").value = data.zonecode;
                  document.getElementById("addr").value = data.address;
                  document.getElementById("addr_dtl").focus();
              }
          }).open();
      });
}

	

    var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    $("#memEmail").on("blur", function() {
        var emailInput = $(this).val(); // 입력란의 값 가져오기

        if (!emailRegex.test(emailInput)) {
            alert("유효한 이메일 주소를 입력하세요.");
            $(this).val('');
        }
    });
    
    $("[name=memTypeNo]").on("change", function() {
        var selectedValue = $(this).val();
        if (selectedValue === "11") {
            $("#adminPasswordDiv").show();
        } else {
            $("#adminPasswordDiv").hide();
        }
    });
    
    $(".submit").click(function() {
        var selectedValue = $("[name=memTypeNo]:checked").val();
        var adminPassword = $("#adminPassword").val();
        if (selectedValue === "11" && adminPassword !== "adminLunchBox") {
            $("#adminPasswordErrorMessage").text("관리자로 회원가입하실 수 없습니다.");
            return false;
        }

        return true;
    });

</script>
</body>
</html>