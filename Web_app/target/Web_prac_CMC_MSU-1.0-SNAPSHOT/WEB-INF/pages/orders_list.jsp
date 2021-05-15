<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
<head>
    <title>Orders</title>
</head>
<body>
<!-- header -->
<div>
    <h2>
        Your orders:
    </h2>
</div>
<div>       <!-- content -->
    <table>
        <tr>
            <th>order_id</th>
            <th>test drive</th>
            <th>date of order</th>
            <th>status</th>
        </tr>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.order_id}</td>
                <td>${order.test_drive}</td>
                <td>${order.date_of_order}</td>
                <td>${order.status}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>