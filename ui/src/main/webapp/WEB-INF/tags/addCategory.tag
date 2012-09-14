<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="parts" tagdir="/WEB-INF/tags/parts" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal hide fade" id="createCategory">
    <parts:dialogHeader headerName="category"/>
    <form:form id="addCategory" method="post" action="addCategory" onsubmit='return false;' commandName="category">
        <div class="modal-body form-horizontal">
            <form:hidden path="id" id="hiddenCategoryId"/>
            <parts:formfield label="label.others" value="name"/>
        </div>
        <div class="modal-footer">
            <input type="submit" class="btn btn-primary type" value="Create" onclick="ajaxAddUpdateCategory();">
            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true" >Close</a>
        </div>
    </form:form>
</div>