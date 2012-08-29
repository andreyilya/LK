<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="parts" tagdir="/WEB-INF/tags/parts" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="modal hide fade" id="createUser">
    <parts:dialogHeader headerName="Add user"/>
    <form:form method="post" action="add" commandName="user">
        <div class="modal-body form-horizontal">

            <ul class="nav nav-tabs">
                <li class="active"><a href="#main" data-toggle="tab">Main</a></li>
                <li><a href="#actions" data-toggle="tab">Actions</a></li>
                <li><a href="#roles" data-toggle="tab">Roles</a></li>
            </ul>
            <div class="tab-content">
                <div id="main" class="tab-pane active">
                    <parts:formfield label="label.login" value="login" />
                    <parts:formpassword label="label.password" value="password" />
                    <parts:formpassword label="label.password" value="password" />
                    <parts:formfield label="label.email" value="email"/>
                </div>
                <div id="actions" class="tab-pane">
                    werqwerwreerw
                </div>
                <div id="roles" class="tab-pane"> qwerweqrew</div>
            </div>
        </div>
        <div class="modal-footer">
            <input type="submit" class="btn btn-primary" value="Create">
            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
        </div>
    </form:form>
</div>