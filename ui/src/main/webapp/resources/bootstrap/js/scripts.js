function initDialog(address, username) {
    $(".toReplace").attr('href', address);
    $('#deleteUser').modal('show');
    $('.user').append(username);
}

function ajaxDelete() {
    var url = $(".toReplace").attr('href');
    $.get(url);
    deleteFromDatatable(url);
    $('#deleteUser').modal('hide');
    return false;
}

function deleteFromDatatable(url){
    var row = $("#" + url);
    row.remove();
}