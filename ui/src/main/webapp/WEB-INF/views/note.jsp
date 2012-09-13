<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
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

<sec:authorize ifAnyGranted="ROLE_ADMIN">
    <a href="admin">Admin page</a>
</sec:authorize>
<h3><spring:message code="label.contacts"/></h3>

<div class="notes">
    <a href="#createNote" role="button" class="btn btn-primary" data-toggle="modal" onclick="setType($('#addNote'), 'addNote');">Create note</a>
    <table class="table table-striped table-bordered" id="noteTable">
        <tr>
            <th><spring:message code="label.createdDate"/></th>
            <th><spring:message code="label.createdDate"/></th>
            <th><spring:message code="label.price"/></th>
            <th><spring:message code="label.number"/></th>
            <th><spring:message code="label.status"/></th>
            <th><spring:message code="label.customerName"/></th>
            <th><spring:message code="label.customersPhone"/></th>
            <th><spring:message code="label.others"/></th>
            <th><spring:message code="label.delete"/></th>
        </tr>
        <c:if test="${!empty noteList}">
            <c:forEach items="${noteList}" var="note">
                <tr id="deleteNote/${note.id}">
                    <td>${note.id}</td>
                    <td>${note.createdDate}</td>
                    <td>${note.price}</td>
                    <td>${note.number}</td>
                    <td>${note.status}</td>
                    <td>${note.customerName}</td>
                    <td>${note.customersPhone}</td>
                    <td>${note.others}</td>
                    <td><div><a href="#" onclick="initDialog('deleteNote/${note.id}','${note.id}')"
                           class="deleteLink"><spring:message code="label.delete"/></a></div>
                        <div><a href="#" onclick="initNoteUpdate('${note.id}');"
                                ><spring:message code="label.update"/></a></div>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<table class="table table-striped table-bordered" id="categoryTable">
    <tr>
        <th><spring:message code="label.createdDate"/></th>
        <th><spring:message code="label.createdDate"/></th>

    </tr>
    <c:if test="${!empty categoryList}">
        <c:forEach items="${categoryList}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>


<tags:deleteEntity entityName="note"/>
<tags:addNote/>

<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $('#createNote').on('hidden', function () {
        clearForm($('#addNote'));
    });
</script>
</body>
</html>