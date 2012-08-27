<div class="modal hide fade" id="createUser">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3>Create user</h3>
        </div>
        <div class="modal-body form-horizontal">

            <ul class="nav nav-tabs">
                <li><a href="#main" data-toggle="tab">Main</a></li>
                <li><a href="#actions" data-toggle="tab">Actions</a></li>
                <li><a href="#roles" data-toggle="tab">Roles</a></li>
            </ul>
            <div class="tab-content">
                <div id="main" class="tab-pane active">
                    <div class="control-group">
                        <label class="control-label" for="inputLogin">
                            <spring:message code="label.login"/>
                        </label>

                        <div class="controls">
                            <input type="text" id="inputLogin"
                                   placeholder=
                                       <spring:message code="label.login" />
                                    />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="inputPassword">
                            <spring:message code="label.password"/>
                        </label>

                        <div class="controls">
                            <input type="password" id="inputPassword"
                                   placeholder=
                                       <spring:message code="label.password" />
                                    />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="confirmPassword">
                            <spring:message code="label.password"/>
                        </label>

                        <div class="controls">
                            <input type="password" id="confirmPassword"
                                   placeholder=
                                       <spring:message code="label.password" />
                                    />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="inputEmail">
                            <spring:message code="label.email"/>
                        </label>

                        <div class="controls">
                            <input type="password" id="inputEmail"
                                   placeholder=
                                       <spring:message code="label.email" />
                                    />
                        </div>
                    </div>
                </div>
                <div id="actions" class="tab-pane">
                    werqwerwreerw
                </div>
                <div id="roles" class="tab-pane"> qwerweqrew</div>
            </div>
        </div>
        <div class="modal-footer">
            <a href="#" onclick="ajaxDelete()" class="btn btn-primary">Create</a>
            <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</a>
        </div>
    </div>