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


    <div class="modal hide fade" id="deleteUser">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3>Deleting user</h3>
        </div>
        <div class="modal-body">
            <p>do you want to delete user <span class="user"></span> ?</p>
        </div>
        <div class="modal-footer">
            <a href="#" onclick="ajaxDelete()" class="btn toReplace btn-primary">Delete</a>
            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
        </div>
    </div>


    <div class="modal hide fade" id="createUser">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3>Create user</h3>
        </div>
        <div class="modal-body form-horizontal">

            <ul class="nav nav-tabs">
                <li><a href="#main" data-toggle="tab">Main</a></li>
                <li><a href="#actions" data-toggle="tab">Actions</a></li>
                <li><a href="#roles" data-toggle="tab">Roles</a></li>
            </ul>
            <div class="tab-content">
                <div id="main" class="tab-pane active">
                    <div class="control-group">
                        <label class="control-label" for="inputLogin">
                            <spring:message code="label.login"/>
                        </label>

                        <div class="controls">
                            <input type="text" id="inputLogin"
                                   placeholder=
                                       <spring:message code="label.login" />
                                    />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="inputPassword">
                            <spring:message code="label.password"/>
                        </label>

                        <div class="controls">
                            <input type="password" id="inputPassword"
                                   placeholder=
                                       <spring:message code="label.password" />
                                    />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="confirmPassword">
                            <spring:message code="label.password"/>
                        </label>

                        <div class="controls">
                            <input type="password" id="confirmPassword"
                                   placeholder=
                                       <spring:message code="label.password" />
                                    />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="inputEmail">
                            <spring:message code="label.email"/>
                        </label>

                        <div class="controls">
                            <input type="password" id="inputEmail"
                                   placeholder=
                                       <spring:message code="label.email" />
                                    />
                        </div>
                    </div>
                </div>
                <div id="actions" class="tab-pane">
                    werqwerwreerw
                </div>
                <div id="roles" class="tab-pane"> qwerweqrew</div>
            </div>
        </div>
        <div class="modal-footer">
            <a href="#" onclick="ajaxDelete()" class="btn btn-primary">Create</a>
            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
        </div>
    </div>


</c:if>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>