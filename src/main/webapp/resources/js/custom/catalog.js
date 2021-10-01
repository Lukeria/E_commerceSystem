$(document).ready(function () {

    $("#file_upload").on("change", function (event) {
        $('#file_upload_name').text($('#file_upload')[0].files[0].name);
    });

    $("#save").click(function () {
        if ($('#file_upload')[0].files.length === 0) {
            showNotification("You can't save catalog item with empty image", "warning");
        } else if (!$('#productType').val()) {
            showNotification("You can't save catalog item with empty product type", "warning");
        } else {
            saveCatalogItem();
            $('#file_upload_name').text('');
        }
    });

})

function saveCatalogItem() {

    let dataForm = new FormData();
    dataForm.append("file", $('#file_upload')[0].files[0]);
    dataForm.append("productType", $('#productType').val());

    $.ajax({
        type: "POST",
        url: "/catalog/settings/upload",
        cache: false,
        contentType: false,
        processData: false,
        data: dataForm,
        success: function (response) {

            if (response.status=='SUCCESS') {

                showNotification("Catalog item has been added successfully", "success");
                $("#file_upload").val('');
                $("#my_image").attr("src", "/catalog/displayImage?id=" + response.result);
            }

        },
        error: function (e) {

            showNotification("Cannot upload image", "danger");
        }
    });
}

function deleteCatalogItem(url, element) {

    $.ajax({
        type: "POST",
        url: url,
        success: function () {

            $(element).parents("[id*='catalogItem']").remove();
            showNotification("Catalog item has been deleted", "success");
        },
        error: function (e) {

            showNotification("Cannot delete catalog item", "danger");
        }
    });
}

function post(path, params, method) {
    method = method || "post";

    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);

    for (var key in params) {
        if (params.hasOwnProperty(key)) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
        }
    }

    document.body.appendChild(form);
    form.submit();
}

function showNotification(text, color) {
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


