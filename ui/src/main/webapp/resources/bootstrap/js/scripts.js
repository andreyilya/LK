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
