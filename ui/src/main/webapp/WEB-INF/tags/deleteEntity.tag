<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="parts" tagdir="/WEB-INF/tags/parts" %>
<%@ attribute name="entityName" required="false" rtexprvalue="true" type="java.lang.String" %>

<div class="modal hide fade" id="deleteEntity">
    <parts:dialogHeader headerName="Deleting ${entityName}" />
    <div class="modal-body">
        <p>do you want to delete ${entityName} <span class="entity"></span> ?</p>
    </div>
    <div class="modal-footer">
        <a href="#" onclick="ajaxDelete()" class="btn toReplace btn-primary">Delete</a>
        <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
    </div>
</div>