<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="parts" tagdir="/WEB-INF/tags/parts" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <table>
                        <c:forEach items="${actions}" var="action">
                            <tr>${action.field}<td> <form:checkbox path="actionsForEmail.${action.field}" value="true"/></td></tr>

                        </c:forEach>
                    </table>
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