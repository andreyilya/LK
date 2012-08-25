<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title"/></title>
</head>
<body>

<a href="<c:url value="/login.jsp" />">
    <spring:message code="label.logout"/>
</a>

<h2><spring:message code="label.title"/></h2>


<h3><spring:message code="label.contacts"/></h3>

adminnnnnnnnnnnnnnnnnnnnnnnnnnnn!sadfasas
<c:if test="${!empty userList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstname"/></th>
            <th><spring:message code="label.email"/></th>
            <th><spring:message code="label.telephone"/></th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
            </tr>
        </c:forEach>
    </table>


</c:if>

</body>
</html>