$(document).ready(function () {

    $("#file_upload").on("change", function (event) {
        $('#file_upload_name').text($('#file_upload')[0].files[0].name);
    });

    $("#save").click(function () {
        if($('#file_upload')[0].files.length === 0){
            showNotification("You can't save catalog item with empty image", "warning")
        } else {
            saveCatalogItem();
            $('#file_upload_name').text('');
            // let params = {};
            // params['file']=$('#file_upload')[0].files[0];
            // params["productType"]= $('#productType').val();
            // post("/catalog/settings/upload", params);
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
            // we have the response
            if(response.redirect){
                window.location.replace(response.redirectUrl);
            } else {
                $("#my_image").attr("src","/catalog/settings/displayImage?id="+response.result);
                $('#catalog_id').val(response.result);
                $("#updateGlass").attr("href","/catalog/settings/"+response.result+"/updateGlass");
            }

        },
        error: function (e) {
            alert('Error: ' + e);
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


