<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="parts" tagdir="/WEB-INF/tags/parts" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal hide fade" id="createSubCategory">
    <parts:dialogHeader headerName="sub Category"/>
    <form:form id="addSubCategory" method="post" action="addSubCategory" onsubmit='return false;' commandName="subCategory">
        <div class="modal-body form-horizontal">
            <form:hidden path="id" id="hiddenSubCategoryId"/>
            <form:hidden path="category.id" id="hiddenSubCategoryCategoryId"/>
            <div class="control-group">
                <label class="control-label" for="subCategoryName">
                    <spring:message code="label.firstname"/>
                </label>
                <div class="controls">
                    <form:input path="name" id="subCategoryName"/>
                </div>
            </div>
            <parts:formfield label="label.others" value="usdPrice"/>
            <parts:formfield label="label.others" value="rubPrice"/>
        </div>
        <div class="modal-footer">
            <input type="submit" class="btn btn-primary type" value="Create" onclick="ajaxAddUpdateSubCategory();">
            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >Close</a>
        </div>
    </form:form>
</div>