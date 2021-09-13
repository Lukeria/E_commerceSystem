let glassTypeList = [];
let processingList = [];

$(document).ready(function () {

    prepareData();

    $("#glassType").change(function () {
        prepareThickness($(this));
    })

    $("#addRaw").click(function () {
        addGlassRow();
    });

    $('#delete').click(function () {
        if ($(this).parents("tr")[0].id != "row_1") {
            $(this).parents("tr").remove();
        }
    });

    $('#addProcessing').click(function () {
        addProcessingRow($(this).parents("tr")[0]);
    });

    $("#addToCart").click(function (event) {
        doAjaxAddToCartPost();
    });

    $("#calculate").click(function (event) {
        doAjaxCalculatePost();
    });

});

////Prepare data////
function prepareData() {
    $.ajax({
        type: "POST",
        url: "/component/getData",
        success: function (response) {
            // we have the response
            if (response.status == "SUCCESS") {
                let result = JSON.parse(response.result);
                glassTypeList = result.glassTypeList;
                processingList = result.processingList;
                let glassTypeSelect = prepareGlassType();
                prepareThickness(glassTypeSelect);
            }
        },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}

function prepareGlassType() {

    let currentRow = $('#glass tr:last-child');
    let glassTypeSelect = $(currentRow).find('#glassType');

    glassTypesSet = new Set();
    glassTypeList.forEach(function (item) {
        glassTypesSet.add(item.name)
    });

    let select = "";
    glassTypesSet.forEach(function (item) {
        let option = "<option value=" + item + ">" + item + "</option>";
        select += option;
    });

    glassTypeSelect.append(select);

    return glassTypeSelect;
}

function prepareThickness(selected) {

    let currentGlassType = selected.find('option:selected').val();
    let currentRow = selected.parents("tr");
    let thicknessSelect = $(currentRow).find('#thickness');
    thicknessSelect.empty();

    let thicknessList = glassTypeList
        .filter(type => type.name === currentGlassType)
        .sort(function (a, b) {
            return a.thickness - b.thickness
        });
    let thicknessSet = new Set();
    thicknessList.forEach(function (item) {
        thicknessSet.add({"id": item.id, "thickness": item.thickness})
    })

    let select = "";
    thicknessSet.forEach(function (item) {
        let option = "<option value=" + item.id + ">" + item.thickness + "</option>";
        select += option;
    })

    thicknessSelect.append(select);
}

function prepareProcessingType(glassRow) {

    let currentRow = $(glassRow).find('#processing>tr:last-child');
    let typeSelect = $(currentRow).find('#type');

    processingTypesSet = new Set();
    processingList.forEach(function (item) {
        processingTypesSet.add(item.type)
    });

    let select = "";
    processingTypesSet.forEach(function (item) {
        let option = "<option value=" + item + ">" + item + "</option>";
        select += option;
    });

    typeSelect.append(select);
    return typeSelect;
}

function prepareProcessingName(selected) {

    let currentType = selected.find('option:selected').val();
    let currentRow = selected.parents("#processing>tr");
    let nameSelect = $(currentRow).find('#name');
    nameSelect.empty();

    let processingNameList = processingList
        .filter(item => item.type === currentType);
    let processingSet = new Set();
    processingNameList.forEach(function (item) {
        processingSet.add({"id": item.id, "name": item.name})
    })

    let select = "";
    processingSet.forEach(function (item) {
        let option = "<option value=" + item.id + ">" + item.name + "</option>";
        select += option;
    })

    nameSelect.append(select);
}

///////////////////////

////Add rows////
function addGlassRow() {

    let tableBody = $('#glass');
    let currentRow = $('#glass>tr:last-child');

    let currentId = Number.parseInt(currentRow[0].id.split("_")[1]) || 0;
    let newRow = $(currentRow).clone().prop("id", "row_" + (currentId + 1));
    newRow.find("input").val("");
    newRow.find("#processing").empty();

    newRow.find('#glassType').change(function () {
        prepareThickness($(this));
    });

    newRow.find('#delete').click(function () {
        if ($(this).parents("tr")[0].id != "row_1") {
            $(this).parents("tr").remove();
        }
    });

    newRow.find('#addProcessing').click(function () {
        addProcessingRow($(this).parents("tr")[0]);
    });

    let select = newRow.find("#glassType");
    prepareThickness(select);

    tableBody.append(newRow);

}

function addProcessingRow(glassRow) {

    let tableProcessing = $(glassRow).find('#processing');
    let currentRow = $(glassRow).find('#processing>tr:last-child');
    let newRow;
    let type;
    if (currentRow.length === 0) {
        newRow = createProcessingRow();
        tableProcessing.append(newRow);

        type = prepareProcessingType(glassRow);
    } else {
        let currentId = Number.parseInt(currentRow[0].id.split("_")[1]) || 0;
        newRow = $(currentRow).clone().prop("id", "row_" + (currentId + 1));
        newRow.find("input").val("");
        tableProcessing.append(newRow);

        type = newRow.find("#type");
    }

    prepareProcessingName(type);
    manageProcessingInputsVisibility(newRow);

    newRow.find('#type').change(function () {
        prepareProcessingName($(this));
        manageProcessingInputsVisibility($(this).parents('#processing>tr')[0]);
    });

    newRow.find('#delete').click(function () {
        $(this).parents("#processing>tr").remove();
    });
}

function createProcessingRow() {

    let currentRow = $("<tr id='row_1'></tr>");

    currentRow.append('<td class="td-action">\n' +
        '<button type="button" id="delete" type="button" rel="tooltip"\n' +
        'class="btn btn-link btn-danger btn-sm btn-icon">\n' +
        '<i class="tim-icons icon-trash-simple"></i>\n' +
        '</button>\n' +
        '</td>');
    currentRow.append('<td>' +
        '<select class="form-control" id="type">\n' +
        '</select>' +
        '</td>');
    currentRow.append('<td>' +
        '<select class="form-control" id="name">\n' +
        '</select>' +
        '</td>');
    currentRow.append('<td>' +
        '<input class="form-control" type="number" id="quantity" placeholder="Quantity">\n' +
        '</td>')

    return currentRow;
}

function manageProcessingInputsVisibility(currentRow) {

    let typeValue = $(currentRow).find("#type>option:selected").val();
    let name = $(currentRow).find("#name");
    let quantity = $(currentRow).find("#quantity");

    if (typeValue === "Полировка") {
        name.val($(name).find("option:first").val());
        name.parents('#processing>tr>td').hide();
        quantity.parents('#processing>tr>td').hide();
    } else if (typeValue === "Фацет") {
        name.parents('#processing>tr>td').show();
        quantity.parents('#processing>tr>td').hide();
    } else {
        name.parents('#processing>tr>td').show();
        quantity.parents('#processing>tr>td').show();
    }
}

///////////

////Save data////
function tableToJSON() {

    let myRows = [];

    $('#glass>tr').each(function () {
        let obj = {}

        let type = {};
        type["id"] = $(this).find("#thickness>option:selected").val();
        type["name"] = $(this).find("#glassType>option:selected").val();
        type["thickness"] = Number.parseInt($(this).find("#thickness>option:selected").text());

        obj["type"] = type;
        obj["width"] = Number.parseInt($(this).find("#width").val()) || 0;
        obj["height"] = Number.parseInt($(this).find("#height").val()) || 0;

        let tableProcessing = $(this).find("#processing>tr");
        let processingList = [];
        tableProcessing.each(function () {
                let processingObj = {};
                processingObj["type"] = $(this).find("#type>option:selected").val();
                processingObj["id"] = $(this).find("#name>option:selected").val();
                processingObj["name"] = $(this).find("#name>option:selected").text();
                processingObj["quantity"] = Number.parseInt($(this).find("#quantity").val()) || 0;

                processingList.push(processingObj);
            }
        )

        obj["processingArrayList"] = processingList;

        myRows.push(obj)
    });

    return JSON.stringify(myRows);

}

function doAjaxCalculatePost() {
    // get the form values
    let JSON = tableToJSON();
    $('#tableJSON').val(JSON);
    $.ajax({
        type: "POST",
        url: "/calculator/calculate",
        contentType: "application/json",
        data: JSON,
        success: function (response) {
            // we have the response
            if (response.status == "SUCCESS") {
                $('#result').val(response.result);
                $('#resultText').text(response.result);
            } else {
                showNotification("An <b>error</b> occurred while processing the request", "danger");
            }
        },
        error: function (e) {
            showNotification(e, "danger");
        }
    });
}

function doAjaxAddToCartPost() {
    // get the form values
    let JSON = tableToJSON();
    let price = Number.parseFloat($("#resultText").text()) || 0;

    $.ajax({
        type: "POST",
        url: "/cart/add",
        data: "tableJSON=" + JSON + "&price=" + price,
        success:
            function (response) {
                // we have the response
                if (response.indexOf("loginForm") != -1) {
                    window.location = "/login";

                }
            },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}

/////Вынести в отдельный файл!!!
function showNotification(text, color){
    $.notify({
        icon: "tim-icons icon-bell-55",
        message: text

    }, {
        type: color,
        timer: 8000,
        placement: {
            from: 'bottom',
            align: 'center'
        }
    });
}