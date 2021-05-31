<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
    <head>
        <title>Order Create</title>
    </head>

    <body>
        <div>       <!-- header -->
            <hr>
            <h1>
                Create your order
            </h1>
            <hr>
        </div>
        <div>
            <h3>
                ${client.full_name}
            </h3>
            <hr>
        </div>

        <div>       <!-- content -->
            <form:form action="/order_list/${car.reg_id}/${client.client_id}" method="post" modelAttribute="order">
                <label for="test_drive">Test drive</label>
                <form:select name="test_drive" id="test_drive" path="test_drive">
                    <form:option value="true">true</form:option>
                    <form:option value="false">false</form:option>
                </form:select>
                <br/>
                <br/>
                <label>Date: ${order.date_of_order}</label>
                <br/>
                <br/>
                <label>Status: ${order.status}</label>
                <br/>
                <br/>
                <button name="Create order" type="submit" id="create">Create order</button>
            </form:form>
        </div>
    </body>
</html>