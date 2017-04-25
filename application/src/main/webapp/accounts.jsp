<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accounts</title>
    <link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<body>
<table id="accounts" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Number of account</th>
        <th>Amount of money</th>
        <th>Blocked</th>
        <th>Action</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Number of account</th>
        <th>Amount of money</th>
        <th>Blocked</th>
        <th>Action</th>
    </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td>${account.accountNumber}</td>
            <td>${account.amountMoney}</td>
            <td>${account.blocked}</td>
            <td><button  class="js-action-block" data-key="${account.accountNumber}">Block</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="Accounts" target="_blank">Test Button</a>
<p><button class="js-action-count">Count</button>
    <label id="label" >Result</label></p>
<script src="<c:url value="/resources/js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/js/accounts.js"/>"></script>
</body>
</html>
