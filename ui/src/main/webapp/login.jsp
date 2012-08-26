<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title"/></title>
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/jquery.js" type="text/javascript"></script>
</head>
<body>


<c:if test="${not empty param.error}">

    <div class="alert alert-error fade in">
        <button type="button" class="close" data-dismiss="alert">×</button>
        <strong><spring:message code="label.loginerror"/>: </strong> <spring:message code="label.loginmessage"/>
    </div>

</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />" class="form-horizontal">


    <div class="control-group">
        <label class="control-label" for="inputLogin">
            <spring:message code="label.login"/>
        </label>

        <div class="controls">
            <input type="text" name="j_username" id="inputLogin"
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
            <input type="password" name="j_password" id="inputPassword"
                   placeholder=
                   <spring:message code="label.password" />
                    />
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <label class="checkbox">
                <input type="checkbox" name="_spring_security_remember_me"> <spring:message code="label.remember"/>
            </label>
            <input type="submit" class="btn btn-primary" value="Login"/>
            <input type="reset" class="btn btn-primary" value="Reset"/>
        </div>
    </div>

</form>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>