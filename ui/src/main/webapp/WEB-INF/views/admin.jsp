<%@ page language="java" contentType="text/html; charset=utf8"
pageEncoding="utf8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title"/></title>
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet">
    <script src="resources/bootstrap/js/jquery.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/scripts.js" type="text/javascript"></script>
</head>
<body>

<a href="<c:url value="/logout" />">
    <spring:message code="label.logout"/>
</a>

<h2><spring:message code="label.title"/></h2>


<h3><spring:message code="label.users"/></h3>

<a href="#createUser" role="button" class="btn btn-primary" data-toggle="modal">Create user</a>
<c:if test="${!empty userList}">
    <table class="table table-striped table-bordered">
        <tr>
            <th><spring:message code="label.firstname"/></th>
            <th><spring:message code="label.email"/></th>
            <th><spring:message code="label.password"/></th>
            <th></th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr id="delete/${user.id}">
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td><a href="#" onclick="initDialog('delete/${user.id}','${user.login}')"
                       class="deleteLink"><spring:message code="label.delete"/></a></td>
            </tr>
        </c:forEach>
    </table>


    <tags:deleteEntity/>
    <tags:addUser />

</c:if>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>