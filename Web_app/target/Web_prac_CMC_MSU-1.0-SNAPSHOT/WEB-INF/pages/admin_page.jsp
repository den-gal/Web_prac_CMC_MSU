<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="ru">
    <head>
        <title>Admin page</title>
    </head>

    <body>
        <div>  <!-- header -->
            <hr>
            <h1>
                Welcome to admin page, please choose required function:
            </h1>
            <hr>
        </div>

        <div>       <!-- content -->
            <form:form action="/special_page" modelAttribute="admin" method="get">
                <label for="admin_func">
                    <b>
                        Admin Functions
                    </b>
                </label>
                <form:select path="function" name="admin_func" id="admin_func">
                    <form:option value="1">Find Order By Order Id </form:option>
                    <form:option value="2">Find Order By Car Id </form:option>
                    <form:option value="3">findClientById </form:option>
                    <form:option value="4">findOrdersByClientId </form:option>
                    <form:option value="5">findClientsByOrderNot </form:option>
                    <form:option value="6">findCarsByCarNot </form:option>
                    <form:option value="7">New Order </form:option>
                    <form:option value="8">New Client </form:option>
                    <form:option value="9">New Car </form:option>
                </form:select>
                <br>
                <input type="submit" name="Use this function" id="submit"/>
            </form:form>
        </div>
    </body>
</html>