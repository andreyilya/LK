<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="parts" tagdir="/WEB-INF/tags/parts" %>
<div class="modal hide fade" id="deleteUser">
    <parts:dialogHeader headerName="Deleting user" />
    <div class="modal-body">
        <p>do you want to delete пользователя <span class="user"></span> ?</p>
    </div>
    <div class="modal-footer">
        <a href="#" onclick="ajaxDelete()" class="btn toReplace btn-primary">Delete</a>
        <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
    </div>
</div>