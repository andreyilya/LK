function initDialog(address, entityname) {
    $(".toReplace").attr('name', address);
    $('#deleteEntity').modal('show');
    $('.entity').text(entityname);
}

function ajaxDelete() {
    var url = $(".toReplace").attr('name');
    $.get(url);
    deleteFromDatatable(url);
    $('#deleteEntity').modal('hide');
    return false;
}

function deleteFromDatatable(url) {
    var row = $(document.getElementById(url));
    row.remove();
}


function ajaxAdd() {
    $.post("add", $("#addUser").serialize(),
            function (response) {
                $('#createUser').modal('hide');
                addRow($(addUser).serializeArray(), response)
            }, 'json');
}

function addRow(form, response) {
    var id = "delete/" + response;
    var row = "<tr id='ID'>" +
            "<td>LOGIN</td>" +
            "<td>EMAIL</td>" +
            "<td>PASSWORD</td> " +
            "<td><a href='#' onclick=\"initDialog('ID','LOGIN')\" class='deleteLink'>Удалить</a></td>" +
            "</tr>";
    row = row.replace(/ID/g, id);
    row = row.replace(/LOGIN/g, getValue(form, "login"));
    row = row.replace("EMAIL", getValue(form, "email"));
    row = row.replace("PASSWORD", getValue(form, "password"));
    $("#userTable tr:last").after(row);
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
            "<td><a href='#' onclick=\"initDialog('ROW_ID','ID')\" class='deleteLink'>Удалить</a></td>" +
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


$('#main a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
});

$('#actions a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
});

$('#roles a').click(function (e) {
    e.preventDefault();
    $(this).tab('show');
});
