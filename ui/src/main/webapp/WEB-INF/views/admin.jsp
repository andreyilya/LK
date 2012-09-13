<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <meta http-equiv="Content-Script-Type" content="text/javascript; charset=utf-8">
    <title><spring:message code="label.title"/></title>
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/bootstrap/css/styles.css" rel="stylesheet">
    <script src="resources/bootstrap/js/jquery.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/scripts.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>

<a href="<c:url value="/logout" />">
    <spring:message code="label.logout"/>
</a>

<h2><spring:message code="label.title"/></h2>

<p><a href="index">Notes</a></p>

<h3><spring:message code="label.users"/></h3>

<a href="#createUser" role="button" class="btn btn-primary" data-toggle="modal" onclick="setType($('#addUser'), 'add');">Create
    user</a>

<table class="table table-striped table-bordered" id="userTable">
    <tr>
        <th><spring:message code="label.firstname"/></th>
        <th><spring:message code="label.email"/></th>
        <th><spring:message code="label.password"/></th>
        <th></th>
    </tr>
    <c:if test="${!empty userList}">
        <c:forEach items="${userList}" var="user">
            <tr id="delete/${user.id}">
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>
                    <div><a href="#" onclick="initDialog('delete/${user.id}','${user.login}')"
                            class="deleteLink"><spring:message code="label.delete"/></a>
                    </div>
                    <div>
                        <a href="#" data-toggle="modal" onclick="initUpdate(${user.id});">
                            <spring:message code="label.update"/></a>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>


<tags:deleteEntity entityName="user"/>
<tags:addUser type="add"/>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
 <script type="text/javascript">
     $('#createUser').on('hidden', function () {
         clearForm($('#addUser'));
     });
 </script>
</body>
</html>