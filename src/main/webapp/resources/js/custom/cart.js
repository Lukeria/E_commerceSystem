let selectedOrders = false;

$(document).ready(function () {
    $("#formOrder").click(function (event) {
        submitOrder();
    });
    $("#order_selectAll").click(function () {
        selectAll('order', !selectedOrders);
        selectedOrders = !selectedOrders;
    });

});

function selectAll(id, value) {

    $('#' + id + '>tr').each(function () {
        $(this).find('.form-check-label>input[id*="selected_"]').prop('checked', value);
    });
}

function calculateCost(element){

    let currentRow = element.parents('tr');
    let cost = currentRow.find('td[id*="cost_"]').text();

}

function deleteCartOrder(url, element) {

    $.ajax({
        type: "POST",
        url: url,
        success: function () {

            $(element).parents("tr").remove();
            showNotification("Order has been deleted", "success");
        },
        error: function (e) {

            showNotification("Cannot delete order", "danger");
        }
    });
}

function submitOrder(){

    let ids = getIdsArray();
    $.ajax({
        type: "POST",
        url: "/cart/submit",
        data: JSON.stringify(ids),
        contentType: "application/json",
        success: function (response) {
            // we have the response
            if (response.status == "SUCCESS") {
                $('#order>tr').each(function () {
                    if (!$(this).find('.form-check-label>input[id*="selected_"]').is(":checked")) {
                        return true;
                    }
                    $(this).remove();
                });
                showNotification("Order is submitted", "success");
            }
        },
        error: function (e) {
            showNotification("Order can't be submitted", "danger");
        }
    });
}

function getIdsArray(){

    let array = [];

    $('#order>tr').each(function () {
        if (!$(this).find('.form-check-label>input[id*="selected_"]').is(":checked")) {
            return true;
        }

        let id = Number.parseInt(($(this).find('input[id*="id_"]').val()) || 0);
        array.push(id);
    });

    return array;
}