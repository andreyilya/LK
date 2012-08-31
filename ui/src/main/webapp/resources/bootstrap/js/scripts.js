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
