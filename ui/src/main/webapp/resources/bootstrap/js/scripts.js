function initDialog(address, username) {
    $(".toReplace").attr('name', address);
    $('#deleteUser').modal('show');
    $('.user').append(username);
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