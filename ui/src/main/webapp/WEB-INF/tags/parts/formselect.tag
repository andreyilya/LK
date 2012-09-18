<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ attribute name="label" required="true" rtexprvalue="true" %>
<%@ attribute name="items" required="true" rtexprvalue="true" type="java.util.List" %>
<%@ attribute name="id" required="false" rtexprvalue="true" %>
<%@ attribute name="itemLabel" required="false" rtexprvalue="true" %>
<%@ attribute name="itemValue" required="false" rtexprvalue="true" %>
<%@ attribute name="path" required="true" rtexprvalue="true" %>
<div class="control-group">
    <label class="control-label" for="${id}">
        <spring:message code="${label}"/>
    </label>
    <div class="controls">
        <form:select path="${path}" items="${items}" itemLabel="${itemLabel}" itemValue="${itemValue}" id="${id}"/>
    </div>
</div>