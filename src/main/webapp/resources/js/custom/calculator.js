let row = 1;
let rowProcessing;
let glassTypes = JSON.parse($('#glassTypeList').val());
let processing = JSON.parse($('#processingList').val())

jQuery.fn.showIf = function (condition) {
    return this[condition ? 'show' : 'hide']();
}

$(document).ready(function () {
    $("#addRaw").click(function () {
        addTableRowGlass();
    });
    $("#calculatorForm").submit(function (event) {
        event.preventDefault();
        doAjaxPost();
    });
    addTableRowGlass();
});

function addTableRowGlass() {

    rowProcessing = 1;

    let tableBody = $("#glass");

    let tableRow = $("<tr></tr>");

    let buttonRemoveGlass = $('<a href="javascript:void(0);" id="removeGlass_' + row + '">x</a>');
    tableRow.append(buttonRemoveGlass);
    tableRow.append($('<th><label>Type: </label></th><td><select id="glassTypeSelect_' + row + '">' + getGlassTypeSelect() + '</select></td>'));
    let selectedType = tableRow.find("#glassTypeSelect_" + row + ">option:selected").val();
    tableRow.append($('<th><label>Thickness: </label></th><td><select id="thicknessSelect_' + row + '">' + getThicknessSelect(selectedType, row) + '</select></td>'));
    tableRow.append($('<th><label>Width: </label></th><td><input type="number"></td>'));
    tableRow.append($('<th><label>Height: </label></th><td><input type="number"></td>'));

    let tableProcessing = $('<table><tbody id="processing_' + row + '"></tbody></table>');
    let buttonAddProcessing = $('<a href="javascript:void(0);" id="addProcessing_' + row + '">Add processing</a>');

    buttonAddProcessing.click(function () {
        addTableRowProcessing(buttonAddProcessing[0].id);
    });

    buttonRemoveGlass.click(function () {
        buttonRemoveGlass.parent().remove();
    });

    tableRow.find("#glassTypeSelect_" + row).change(function () {
        let currentGlassType = $(this).find('option:selected').val();
        let thicknessId = $(this)[0].id.split("_")[1];
        let thicknessSelect = $('#thicknessSelect_' + thicknessId);
        thicknessSelect.empty();
        thicknessSelect.append($(getThicknessSelect(currentGlassType)));
    })
    tableRow.append(buttonAddProcessing);
    tableRow.append(tableProcessing);
    tableBody.append(tableRow);

    row++;
}

function getGlassTypeSelect() {

    glassTypesSet = new Set();
    glassTypes.forEach(function (item) {
        glassTypesSet.add(item.name)
    });

    let select = "";
    glassTypesSet.forEach(function (item) {
        let option = "<option value=" + item + ">" + item + "</option>";
        select += option;
    });
    return select;

}

function getThicknessSelect(glassTypeNameValue) {

    let thicknessList = glassTypes.filter(type => type.name === glassTypeNameValue);
    let thicknessSet = new Set();
    thicknessList.forEach(function (item) {
        thicknessSet.add({"id": item.id, "thickness": item.thickness})
    })

    let select = "";
    thicknessSet.forEach(function (item) {
        let option = "<option value=" + item.id + ">" + item.thickness + "</option>";
        select += option;
    })
    return select;
}

function getProcessingTypeSelect(){

    processingTypesSet = new Set();
    processing.forEach(function (item) {
        processingTypesSet.add(item.type)
    });

    let select = "";
    processingTypesSet.forEach(function (item) {
        let option = "<option value=" + item + ">" + item + "</option>";
        select += option;
    });
    return select;
}

function getProcessingNameSelect(processingTypeValue){

    let processingList = processing.filter(item => item.type === processingTypeValue);
    let processingSet = new Set();
    processingList.forEach(function (item) {
        processingSet.add({"id": item.id, "name": item.name})
    })

    let select = "";
    processingSet.forEach(function (item) {
        let option = "<option value=" + item.id + ">" + item.name + "</option>";
        select += option;
    })
    return select;
}

function addTableRowProcessing(id) {
    let rowNumber = id.split("_")[1]

    let tableBody = $('#processing_' + rowNumber);

    let tableRow = $("<tr></tr>");

    let buttonRemoveProcessing = $('<a href="javascript:void(0);" id="removeProcessing_' + rowNumber + '_'+rowProcessing + '">x</a>');
    tableRow.append(buttonRemoveProcessing);
    tableRow.append('<th><label>Type: </label></th><td><select id="processingTypeSelect_' + rowNumber + '_'+rowProcessing+'">' + getProcessingTypeSelect() + '</select></td></td>');
    let selectedType = tableRow.find("#processingTypeSelect_" + rowNumber + "_"+rowProcessing+">option:selected").val();
    tableRow.append('<th><label>Name: </label></th><td><select id="processingNameSelect_' + rowNumber + '_'+rowProcessing+'">' + getProcessingNameSelect(selectedType) + '</select></td>');

    buttonRemoveProcessing.click(function () {
        buttonRemoveProcessing.parent().remove();
    })

    tableRow.find("#processingTypeSelect_" + rowNumber+ "_"+rowProcessing).change(function () {
        let currentType = $(this).find('option:selected').val();
        let processingIdRow = $(this)[0].id.split("_")[1];
        let processingIdChildRow = $(this)[0].id.split("_")[2];

        if(currentType === 'Отверстие' || currentType === 'Закругление') {
            tableRow.append('<th><label for="processingQuantity_' + processingIdRow + '_' + processingIdChildRow + '">Quantity: </label></th><td><input type="number" id="processingQuantity_' + processingIdRow + '_' + processingIdChildRow + '"></td>');
        }else{
            tableRow.find('#processingQuantity_' + processingIdRow + '_'+processingIdChildRow+'').parent().remove();
            tableRow.find('label[for=processingQuantity_' + processingIdRow + '_'+processingIdChildRow+']').parent().remove();
        }

        let processingTypeSelect = $('#processingNameSelect_' + processingIdRow+'_'+processingIdChildRow);
        processingTypeSelect.empty();
        processingTypeSelect.append($(getProcessingNameSelect(currentType)));
    })

    tableBody.append(tableRow);

    rowProcessing++;
}

function tableToJSON() {

    let myRows = [];
    //loop through tr
    $('#glass>tr').each(function () {
        let obj = {} //create obj
        //add value to it

        let type = {};
        type["id"] = $(this).find("td:eq(1) select option:selected").val();
        type["name"] = $(this).find("td:eq(0) select option:selected").text();
        type["thickness"] = Number.parseInt($(this).find("td:eq(1) select option:selected").text());

        obj["type"] = type;
        obj["width"] = Number.parseInt($(this).find("td:eq(2) input").val()) || 0;
        obj["height"] = Number.parseInt($(this).find("td:eq(3) input").val()) || 0;

        let tableProcessing = $(this).find("tbody>tr");
        let processingList = [];
        tableProcessing.each(function () {
                let processingObj = {};
                processingObj["type"] = $(this).find("td:eq(0) select option:selected").val();
                processingObj["id"] = $(this).find("td:eq(1) select option:selected").val();
                processingObj["name"] = $(this).find("td:eq(1) select option:selected").text();
                processingObj["quantity"] =  Number.parseInt($(this).find("td:eq(2) input").val()) || 0;

                processingList.push(processingObj);
            }
        )

        obj["processingArrayList"] = processingList;

        myRows.push(obj) //push obj to array
    });

    return JSON.stringify(myRows);

}

function doAjaxPost() {
    // get the form values
    let JSON = tableToJSON();

    $.ajax({
        type: "POST",
        url: "/calculator/calculateAjax",
        data: "tableJSON=" + JSON,
        success: function (response) {
            // we have the response
            if (response.status == "SUCCESS") {
                $('#result').val(response.result);
            }
        },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}