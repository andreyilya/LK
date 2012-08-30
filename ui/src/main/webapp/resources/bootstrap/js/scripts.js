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
                addRow($(addUser), response)
            }, 'json');
}

function addRow(form, response) {
    var id = "delete/" + response;
    var row = "<tr id=ID>" +
            "<td>LOGIN</td>" +
            "<td>ENAIL</td>" +
            "<td>PASSWORD</td> " +
            "<td><a href='#' onclick='initDialog('ID','LOGIN')' class='deleteLink'>Delete</a></td>" +
            "</tr>";
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
