<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ attribute name="label" required="true" rtexprvalue="true" %>
<%@ attribute name="value" required="true" rtexprvalue="true" %>
<div class="control-group">
    <label class="control-label" for="${value}">
        <spring:message code="${label}"/>
    </label>
    <div class="controls">
            <form:password path="${value}"/>
    </div>
</div>