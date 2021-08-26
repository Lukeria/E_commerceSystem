<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>Calculator</title>
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
                <input type="text" id="row-1-glassType" name="row-1-glassType">
            </td>
            <th>
                <label for="row-1-sizeWidth">Width: </label>
            </th>
            <td>
                <input type="text" id="row-1-sizeWidth" name="row-1-sizeWidth">
            </td>
            <th>
                <label for="row-1-sizeHeight">Height: </label>
            </th>
            <td>
                <input type="text" id="row-1-sizeHeight" name="row-1-sizeHeight">
            </td>
            <th>
                <label for="row-1-thickness">Thickness: </label>
            </th>
            <td>
                <input type="text" id="row-1-thickness" name="row-1-thickness">
            </td>
            <th>
                <label for="row-1-processing">Processing: </label>
            </th>
            <td>
                <input type="checkbox" id="row-1-processing" name="row-1-processing">
            </td>
        </tr>
        <tr>
            <th>
                <label for="row-2-glassType">Type: </label>
            </th>
            <td>
                <input type="text" id="row-2-glassType" name="row-2-glassType">
            </td>
            <th>
                <label for="row-2-sizeWidth">Width: </label>
            </th>
            <td>
                <input type="text" id="row-2-sizeWidth" name="row-2-sizeWidth">
            </td>
            <th>
                <label for="row-2-sizeHeight">Height: </label>
            </th>
            <td>
                <input type="text" id="row-2-sizeHeight" name="row-2-sizeHeight">
            </td>
            <th>
                <label for="row-2-thickness">Thickness: </label>
            </th>
            <td>
                <input type="text" id="row-2-thickness" name="row-2-thickness">
            </td>
            <th>
                <label for="row-2-processing">Processing: </label>
            </th>
            <td>
                <input type="checkbox" id="row-2-processing" name="row-2-processing">
            </td>
        </tr>
        </tbody>
    </table>
    <input id="tableJSON"  name="tableJSON" type="hidden">
    <label for="result">Result: </label>
    <input type="text" id="result" name="result" value="${result}">
    <button type="submit">Calculate</button>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

    function tableToJSON(){

        var myRows = [];
//loop through tr
        $('table tbody tr').each(function() {
            var obj = {} //create obj
            //add value to it
            obj[$(this).find("th:eq(0)").text().trim().slice(0, -1).toLowerCase()] = $(this).find("td:eq(0) input").val();
            obj[$(this).find("th:eq(1)").text().trim().slice(0, -1).toLowerCase()] = $(this).find("td:eq(1) input").val();
            obj[$(this).find("th:eq(2)").text().trim().slice(0, -1).toLowerCase()] = $(this).find("td:eq(2) input").val();
            obj[$(this).find("th:eq(3)").text().trim().slice(0, -1).toLowerCase()] = $(this).find("td:eq(3) input").val();
            obj[$(this).find("th:eq(4)").text().trim().slice(0, -1).toLowerCase()] = $(this).find("td:eq(4) input").val();
            myRows.push(obj) //push obj to array
        });

        $('#tableJSON').val(JSON.stringify(myRows));

    }

</script>
</body>
</html>
