<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="parts" tagdir="/WEB-INF/tags/parts" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal hide fade" id="createNote">
    <parts:dialogHeader headerName="Add note"/>
    <form:form id="addNote" method="post" action="add" onsubmit='return false;' commandName="note">
        <div class="modal-body form-horizontal">

            <parts:formfield label="label.price" value="price"/>
            <parts:formfield label="label.number" value="number"/>
            <parts:formfield label="label.status" value="status"/>
            <parts:formfield label="label.customerName" value="customerName"/>
            <parts:formfield label="label.customersPhone" value="customersPhone"/>
            <parts:formfield label="label.others" value="others"/>

        </div>
        <div class="modal-footer">
            <input type="submit" class="btn btn-primary" value="Create" onclick="ajaxAddNote();">
            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
        </div>
    </form:form>
</div>