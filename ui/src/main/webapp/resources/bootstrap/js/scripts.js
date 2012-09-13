function initDialog(address, entityname) {
    $(".toReplace").attr('name', address);
    $('#deleteEntity').modal('show');
    $('.entity').text(entityname);
}

function ajaxDelete() {
    var url = $(".toReplace").attr('name');
    $.get(url, function(response){
        deleteFromDatatable(url);
        $('#deleteEntity').modal('hide');
    });

    return false;
}

function deleteFromDatatable(url) {
    var row = $(document.getElementById(url));
    row.remove();
}


function ajaxAddOrUpdate() {
    var type = $('#addUser').attr('action');
    $.post(type, $("#addUser").serialize(),
        function (response) {
            $('#createUser').modal('hide');
            if (type == "add") {
                addRow($(addUser).serializeArray(), response)
            } else {
                updateRow($(addUser).serializeArray());
            }
        }, 'json');
}

function addRow(form, response) {
    if (response > 0) {
        var row = createUserRow(response, form);
        $("#userTable tr:last").after(row);
    }
}

function updateRow(form) {
    var id = $("#hiddenId").attr("value");
    var row = createUserCell(id, form);
    var rowId = "#delete\\/" + id;
    $(rowId).html(row);
}

function createUserRow(response, form) {
    var id = "delete/" + response;

    var row = "<tr id='ID'>" +
        createUserCell(response, form) +
        "</tr>";
    row = row.replace(/ID/g, id);
    return row;
}

function createUserCell(response, form) {
    var id = "delete/" + response;

    var row =
        "<td>LOGIN</td>" +
            "<td>EMAIL</td>" +
            "<td>PASSWORD</td> " +
            "<td><div><a href='#' onclick=\"initDialog('ID','LOGIN')\" class='deleteLink'>Удалить</a></div>" +
            "<div><a href='#' onclick=\"initUpdate('UPDATE')\" >Обновить</a></div></td>";
    row = row.replace(/ID/g, id);
    row = row.replace(/LOGIN/g, getValue(form, "login"));
    row = row.replace("EMAIL", getValue(form, "email"));
    row = row.replace("PASSWORD", getValue(form, "password"));
    row = row.replace("UPDATE", response);
    return row;
}

function getValue(list, key) {
    for (i = 0; i < list.length; i++) {
        if (list[i].name == key) {
            return list[i].value;
        }
    }
    return null;
}


function ajaxAddNote() {
    $.post("addNote", $("#addNote").serialize(),
        function (response) {
            $('#createNote').modal('hide');
            addRowNote($(addNote).serializeArray(), response)
        }, 'json');
}

function addRowNote(form, response) {
    var id = "deleteNote/" + response;
    var row = "<tr id='ROW_ID'>" +
        "<td>ID</td>" +
        "<td>DATE</td>" +
        "<td>PRICE</td> " +
        "<td>NUMBER</td> " +
        "<td>STATUS</td> " +
        "<td>CUSTOMER_NAME</td> " +
        "<td>CUSTOMER_PHONE</td> " +
        "<td>OTHERS</td> " +
        "<td><div><a href='#' onclick=\"initDialog('ROW_ID','ID')\" class='deleteLink'>Удалить</a></td></div>" +
        "</tr>";
    var date = new Date();
    var mm = date.getMonth() + 1;
    mm = (mm < 10) ? '0' + mm : mm;
    var dateString = date.getFullYear() + "-" + mm + "-" + date.getDate();
    row = row.replace(/ROW_ID/g, id);
    row = row.replace(/ID/g, response);
    row = row.replace(/DATE/g, dateString);
    row = row.replace("PRICE", getValue(form, "price"));
    row = row.replace("NUMBER", getValue(form, "number"));
    row = row.replace("STATUS", getValue(form, "status"));
    row = row.replace("CUSTOMER_NAME", getValue(form, "customerName"));
    row = row.replace("CUSTOMER_PHONE", getValue(form, "customersPhone"));
    row = row.replace("OTHERS", getValue(form, "others"));
    $("#noteTable tr:last").after(row);
}


function setType(type) {
    $('#addUser').attr('action', type);
}

function initUpdate(id) {
    var url = "getUser/" + id;
    $.get(url, function (response) {
        initUpdateDialog(response);
        $('#createUser').modal('show');
    }, 'json');
}

function initUpdateDialog(response) {
    $('#addUser').trigger('reset');

    setType('update');
    $('#hiddenId').attr('value', response.id);
    $('#login').attr('value', response.login);
    $('#email').attr('value', response.email);

    for (i = 0; i < $("#roles td").length; i++) {
        var id = "#roless" + (i + 1).toString();
        for (j = 0; j < response.roles.length; j++) {
            if (response.roles[j].id == $(id).attr("value")) {
                $(id).prop("checked", true);
            }
        }
    }
}
