<%@ tag pageEncoding="UTF-8" %>
<div class="modal hide fade" id="deleteUser">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3>Deleting user</h3>
    </div>
    <div class="modal-body">
        <p>do you want to delete пользователя <span class="user"></span> ?</p>
    </div>
    <div class="modal-footer">
        <a href="#" onclick="ajaxDelete()" class="btn toReplace btn-primary">Delete</a>
        <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
    </div>
</div>