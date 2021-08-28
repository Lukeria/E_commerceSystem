<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"\>
</head>
<body>
<form action="/calculator/calculate" method="post" onsubmit="tableToJSON()">
    <label for="productType">Product type: </label>
    <input type="text" id="productType" name="productType">
    <p>Glass</p>
    <table>
        <tbody>
        <tr>
            <th>
                <label for="row-1-glassType">Type: </label>
            </th>
            <td>
                <select id="row-1-glassType" name="row-1-glassType">
                    <c:forEach var="item" items="${glassTypeList}">
                        <option value="${item.id}">${item.name} ${item.thickness}</option>
                    </c:forEach>
                </select>
            </td>
            <th>
                <label for="row-1-sizeWidth">Width: </label>
            </th>
            <td>
                <input type="number" id="row-1-sizeWidth" name="row-1-sizeWidth">
            </td>
            <th>
                <label for="row-1-sizeHeight">Height: </label>
            </th>
            <td>
                <input type="number" id="row-1-sizeHeight" name="row-1-sizeHeight">
            </td>
        </tr>
        </tbody>
    </table>
    <a href="javascript:void(0);" id="addRaw">Add raw</a>
    <input id="tableJSON" name="tableJSON" type="hidden">
    <label for="result">Result: </label>
    <input type="text" id="result" name="result" value="${result}">
    <button type="submit">Calculate</button>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

    let row = 1;

    // $(document).ready(function () {
    //     $("#addRaw").click(function () {
    //         $("table tbody").append('<tr><th><label for="row-' + (++row) + '-glassType">Type: </label></th><td></td><th><label for="row-' + (++row) + '-sizeWidth">Width: </label></th><td><input type="number" id="row-' + (++row) + '-sizeWidth" name="row-1-sizeWidth"></td><th><label for="row-' + (++row) + '-sizeHeight">Height: </label></th><td><input type="number" id="row-' + (++row) + '-sizeHeight" name="row-1-sizeHeight"></td><th><label for="row-' + (++row) + '-thickness">Thickness: </label></th><td><input type="number" id="row-' + (++row) + '-thickness" name="row-' + (++row) + '-thickness"></td><th><label for="row-' + (++row) + '-processing">Processing: </label></th><td><input type="checkbox" id="row-' + (++row) + '-processing" name="row-' + (++row) + '-processing"></td></tr>');
    //     });
    // });

    function tableToJSON() {

        let myRows = [];
//loop through tr
        $('table tbody tr').each(function () {
            let obj = {} //create obj
            //add value to it
            let type = {};
            type["id"]=$(this).find("td:eq(0) select option:selected").val();
            type["name"]=$(this).find("td:eq(0) select option:selected").text().split(" ")[0].trim();
            type["thickness"]=Number.parseInt($(this).find("td:eq(0) select option:selected").text().split(" ")[1].trim());

            obj["type"] = type;
            obj["width"] = $(this).find("td:eq(1) input").val();
            obj["height"] = $(this).find("td:eq(2) input").val();

            myRows.push(obj) //push obj to array
        });

        $('#tableJSON').val(JSON.stringify(myRows));

    }

    function addRowGlass() {

    }

</script>
</body>
</html>
