function initDialog(address, username) {
    $(".toReplace").attr('name', address);
    $('#deleteUser').modal('show');
    $('.user').text(username);
}

function ajaxDelete() {
    var url = $(".toReplace").attr('name');
    $.get(url);
    deleteFromDatatable(url);
    $('#deleteUser').modal('hide');
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
            "<td><a href='#' onclick='initDialog('ID','LOGIN')' class='deleteLink'>Удалить</a></td>" +
            "</tr>";
    row= row.replace("ID",id);
    row=row.replace("LOGIN",form[0].value);
    row=row.replace("EMAIL",form[1].value);
    row=row.replace("PASSWORD",form[2].value);
    $("#userTable tr:last").after(row);
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
