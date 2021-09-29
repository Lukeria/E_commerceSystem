$(document).ready(function () {

    $("#file_upload").on("change", function (event) {
        $('#file_upload_name').text($('#file_upload')[0].files[0].name);
    });

    $("#save").click(function () {
        uploadFile();
        $('#file_upload_name').text('');
    });
})

function uploadFile() {

    let dataForm = new FormData();
    dataForm.append("file", $('#file_upload')[0].files[0]);

    $.ajax({
        type: "POST",
        url: "/catalog/settings/upload",
        cache: false,
        contentType: false,
        processData: false,
        data: dataForm,
        success: function (response) {
            // we have the response
            $("#my_image").attr("src","/catalog/settings/displayImage?id="+response);
        },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}
