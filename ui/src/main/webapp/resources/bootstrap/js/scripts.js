function initDialog(address, entityname) {
    $(".toReplace").attr('name', address);
    $('#deleteEntity').modal('show');
    $('.entity').text(entityname);
}

function ajaxDelete() {
    var url = $(".toReplace").attr('name');
    $.get(url, function (response) {
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
            if (response > 0) {
                $('#createUser').modal('hide');
                if (type == "add") {
                    addRow($(addUser).serializeArray(), response)
                } else {
                    updateRow($(addUser).serializeArray());
                }
            }
        }, 'json');
}

function addRow(form, response) {
    var row = createUserRow(response, form);
    $("#userTable tr:last").after(row);
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


function ajaxAddUpdateNote() {
    var type = $('#addNote').attr('action');
    $.post(type, $("#addNote").serialize(),
        function (response) {
            if (response > 0) {
                $('#createNote').modal('hide');
                if (type == 'addNote') {
                    addRowNote($(addNote).serializeArray(), response);
                } else {
                    updateRowNote($(addNote).serializeArray());
                }
                noteMenu();
            }
        }, 'json');
}


function addRowNote(form, response) {
    var id = "deleteNote/" + response;
    var row = "<tr id='ROW_ID'>" +
        createNoteCell(form, response) +
        "</tr>";
    row = row.replace(/ROW_ID/g, id);
    $("#noteTable tr:last").after(row);
}

function createNoteCell(form, response) {
    var id = "deleteNote/" + response;
    var row = "<td>ID</td>" +
        "<td>DATE</td>" +
        "<td>PRICE</td> " +
        "<td class='category'>CATEGORY</td> " +
        "<td>CATEGORY</td> " +
        "<td>NUMBER</td> " +
        "<td>STATUS</td> " +
        "<td>CUSTOMER_NAME</td> " +
        "<td>CUSTOMER_PHONE</td> " +
        "<td>OTHERS</td> ";
    var date = new Date();
    var mm = date.getMonth() + 1;
    mm = (mm < 10) ? '0' + mm : mm;
    var dateString = date.getFullYear() + "-" + mm + "-" + date.getDate();
    row = row.replace(/ROW_ID/g, id);
    row = row.replace(/ID/g, response);
    row = row.replace(/DATE/g, dateString);
    row = row.replace("PRICE", getValue(form, "price"));
    row = row.replace(/CATEGORY/g, $("#noteCategory option:selected").text());
    row = row.replace("NUMBER", getValue(form, "number"));
    row = row.replace("STATUS", getValue(form, "status"));
    row = row.replace("CUSTOMER_NAME", getValue(form, "customerName"));
    row = row.replace("CUSTOMER_PHONE", getValue(form, "customersPhone"));
    row = row.replace("OTHERS", getValue(form, "others"));
    return row;
}

function updateRowNote(form) {
    var id = $("#hiddenId").attr("value");
    var row = createNoteCell(form, id);
    var rowId = "#deleteNote\\/" + id;
    $(rowId).html(row);
}

function setType(form, type) {
    form.attr('action', type);
    $("span.type").html(type);
    $("input.type").attr('value', type);
}

function initUpdate(id) {
    var url = "getUser/" + id;
    $.get(url, function (response) {
        initUpdateDialog(response);
        $('#createUser').modal('show');
    }, 'json');
}

function initNoteUpdate(id) {
    var url = "getNote/" + id;
    $.get(url, function (response) {
        initNoteUpdateDialog(response);
        $('#createNote').modal('show');
    }, 'json');
}

function initCategoryUpdate(elId) {
    var id = elId.split('/')[1];
    var url = "getCategory/" + id;
    $.get(url, function (response) {
        initCategoryUpdateDialog(response);
        $('#createCategory').modal('show');
    }, 'json');

}

function initSubCategoryUpdate(elId) {
    var id = elId.split('/')[1];
    var url = "getSubCategory/" + id;
    $.get(url, function (response) {
        initSubCategoryUpdateDialog(response);
        $('#createSubCategory').modal('show');
    }, 'json');

}

function initSubCategoryCreate(id) {
    var categoryId = id.split('/')[1];
    $("#hiddenSubCategoryCategoryId").attr("value", categoryId);
    $('#createSubCategory').modal('show');
}

function initNoteUpdateDialog(response) {
    $('#addNote').trigger('reset');

    setType($('#addNote'), 'updateNote');
    $('#hiddenId').attr('value', response.id);
    $('#price').attr('value', response.price);
    $('#status').attr('value', response.status);
    if (response.category != null) {
        $("#noteCategory option:contains(" + response.category.name + ")").attr("selected", "selected");
    }
    $('#customerName').attr('value', response.customerName);
    $('#customersPhone').attr('value', response.customersPhone);
    $('#others').attr('value', response.others);
}

function initCategoryUpdateDialog(response) {
    $('#addCategory').trigger('reset');

    setType($('#addCategory'), 'updateCategory');
    $('#hiddenCategoryId').attr('value', response.id);
    $('#name').attr('value', response.name);
}


function initSubCategoryUpdateDialog(response) {
    $('#addSubCategory').trigger('reset');

    setType($('#addSubCategory'), 'updateSubCategory');
    $('#hiddenSubCategoryId').attr('value', response.id);
    $('#subCategoryName').attr('value', response.name);
    $('#usdPrice').attr('value', response.usdPrice);
    $('#rubPrice').attr('value', response.rubPrice);
}

function initUpdateDialog(response) {
    $('#addUser').trigger('reset');

    setType($('#addUser'), 'update');
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


function ajaxAddUpdateCategory() {
    var type = $('#addCategory').attr('action');
    $.post(type, $("#addCategory").serialize(),
        function (response) {
            if (response > 0) {
                $('#createCategory').modal('hide');
                if (type == 'addCategory') {
                    addRowCategory($(addCategory).serializeArray(), response);
                } else {
                    updateRowCategory($(addCategory).serializeArray());
                }
                categoryMenu();
            }
        }, 'json');
}

function addRowCategory(form, response) {
    var id = "deleteCategory/" + response;
    var row = "<li id='ROW_ID' class='categoriesTree'><label>" +
        getValue(form, "name") +
        "</label></li>";
    row = row.replace(/ROW_ID/g, id);
    $("li.categoriesTree:last").after(row);
}

function updateRowCategory(form) {
    var id = "#deleteCategory\\/" + getValue(form, "id");
    var leaf = $(id).children("label");
    var newName = getValue(form, "name");
    var categories = $("." + leaf.html());
    leaf.html(newName);
    for (var i = 0; i < categories.length; i++) {
        $(categories[i]).attr("class", newName);
        $(categories[i]).html(newName);
    }
}

function ajaxAddUpdateSubCategory() {
    var type = $('#addSubCategory').attr('action');
    $.post(type, $("#addSubCategory").serialize(),
        function (response) {
            if (response > 0) {
                $('#createSubCategory').modal('hide');
                if (type == 'addSubCategory') {
                    addRowSubCategory($(addSubCategory).serializeArray(), response);
                } else {
                    updateRowSubCategory($(addSubCategory).serializeArray());
                }
                subCategoryMenu();
            }
        }, 'json');
}

function addRowSubCategory(form, response) {
    var id = "deleteSubCategory/" + response;
    const categoryIdNum = getValue(form, "category.id");
    var categoryId = "#deleteCategory\\/" + categoryIdNum;
    var row = "<li id='ROW_ID' class='file'>" +
        getValue(form, "name") +
        "</li>";
    row = row.replace(/ROW_ID/g, id);
    var selector = categoryId + " li.file:last";
    if ($(selector).length > 0) {
        $(selector).after(row);
    } else {
        var leafs =
            "<label for='CATEGORY_ID'>CATEGORY_NAME</label>" +
                "<input type='checkbox' id='CATEGORY_ID'/>" +
                "<ol>" +
                "LEAF" +
                "</ol>";
        leafs = leafs.replace("/CATEGORY_ID/g", "s" + categoryIdNum);
        leafs = leafs.replace("CATEGORY_NAME", $(categoryId + " label").text());
        leafs = leafs.replace("LEAF", row);
        $(categoryId).html(leafs);
    }
}

function updateRowSubCategory(form) {
    var id = "#deleteSubCategory\\/" + getValue(form, "id");
    var leaf = $(id);
    leaf.html(getValue(form, "name"))
}

function clearForm(form) {
    form.find(':input').each(function () {
        var type = this.type, tag = this.tagName.toLowerCase();
        if (type == 'text' || type == 'password' || tag == 'textarea')
            this.value = '';
        else if (type == 'checkbox' || type == 'radio')
            this.checked = false;
        else if (tag == 'select')
            this.selectedIndex = -1;
    })
}


function initContextMenu() {
    categoryMenu();

    subCategoryMenu();

    noteMenu();
}

function categoryMenu() {
    $("#categoryTable li.categoriesTree").contextMenu({
            menu:'categoryMenu'
        },
        function (action, el, pos) {
            if (action == "delete") {
                initDialog($(el).attr("id"), "category");
            } else if (action == "update") {
                initCategoryUpdate($(el).attr("id"));
            } else {
                initSubCategoryCreate($(el).attr("id"));
            }
        });
}

function subCategoryMenu() {
    $("#categoryTable li.file").contextMenu({
            menu:'subCategoryMenu'
        },
        function (action, el, pos) {
            if (action == "delete") {
                initDialog($(el).attr("id"), "subCategory");
            } else {
                initSubCategoryUpdate($(el).attr("id"))
            }
        });
}

function noteMenu() {
    $("#noteTable tr").contextMenu({
            menu:'subCategoryMenu'
        },
        function (action, el, pos) {
            var rowId = $(el).attr("id");
            var id = rowId.split('/')[1];
            if (action == "delete") {
                initDialog(rowId, id);
            } else {
                initNoteUpdate(id)
            }
        });
}