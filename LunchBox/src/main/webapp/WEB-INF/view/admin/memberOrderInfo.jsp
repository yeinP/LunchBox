<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            text-align: center;
            border: 1px solid #ddd;
            padding: 8px;
        }
    </style>
    <meta charset="UTF-8">
    <title>주문 내역</title>
</head>
<body>
    <div class="membersinfo">
        <h6>주문 내역</h6>
        <div class="tableall">
            <table>
                <tr>
                    <th>주문번호</th>
                    <th>주문일</th>
                    <th>총액</th>
                    <th>제품명</th>
                    <th>수량</th>
                    <th>제품가격</th>
                    
                </tr>

                <c:forEach var="mem" items="${memberOrderInfo}" varStatus="loop">
                    <tr>
                        <c:choose>
                            <c:when test="${loop.first}">
                                <td rowspan="${fn:length(memberOrderInfo) - loop.index}">
                                    ${mem.orderNo}
                                </td>
                                <td rowspan="${fn:length(memberOrderInfo) - loop.index}">
                                    <tf:formatDateTime value="${mem.orderDate}" pattern="yyyy.MM.dd"/>
                                </td>
                                <td rowspan="${fn:length(memberOrderInfo) - loop.index}">
                        ${mem.orderTotalPrice}
                        </td>
                            </c:when>
                        </c:choose>
                        <td>${mem.productName}</td>
                        <td>${mem.orderAmount}</td>
                        <td>${mem.productPrice}</td>
                        
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
