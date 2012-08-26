function initDialog(address, username) {
    $(".toReplace").attr('href', address);
    $('#deleteUser').modal('show');
    $('.user').append(username);
}
