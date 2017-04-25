<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head><title>Producten</title></head>
    <body>
        <h1>Producten</h1>
        <c:forEach items="${productList}" var="prod" >
            ${prod.description}
            <i>    
                <!--  fmt:setLocale value="en_US" scope="session"/> -->
                <fmt:setLocale value="de_DE" scope="session"/> 
                <fmt:formatNumber value="${prod.price}" 
                                  type="currency"/>
            </i>
            <br><br>
        </c:forEach><br>
        <a href="<c:url value="increaseDecrease.htm"/>">
            Wijzig prijzen</a>
        <br>
    </body>
</html>











 <!-- fmt:formatNumber maxFractionDigits="2" minFractionDigits="2" value="${prod.price}" /> -->
