<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
    <head>
        <title>Check out</title>
    </head>
    <body>
        <div>       <!-- header -->
            <hr>
            <c:if test="${client.login != null}">
                <h1>
                    Check car parameters and check out to continue
                </h1>
            </c:if>
            <c:if test="${client.login == null}">
                <h1>
                    Check car parameters and sign in to continue
                </h1>
            </c:if>
            <hr>
        </div>

        <c:if test="${client.login != null}">
            <div>
                <h3>
                        ${client.full_name}
                </h3>
            </div>
            <hr>
        </c:if>

        <div>       <!-- content -->
            <table>
                <tr>
                    <th>brand</th>
                    <th>manufacturer</th>
                    <th>technical_not</th>
                    <th>addition_devices</th>
                    <th>costumer_not</th>
                    <th>mutable_not</th>
                    <th>price</th>
                </tr>
                <tr>
                    <td>${car.brand}</td>
                    <td>${car.manufacturer}</td>
                    <td>${car.technical_not}</td>
                    <td>${car.addition_devices}</td>
                    <td>${car.costumer_not}</td>
                    <td>${car.mutable_not}</td>
                    <td>${car.price}</td>
                </tr>
            </table>
            <br/>
            <c:if test="${client.login != null}">
                <button onclick="location.href='/confirm_form/checkout/order/${car.reg_id}/${client.client_id}'" id="create">Create the order</button>
            </c:if>
            <c:if test="${client.login == null}">
                <button onclick="location.href='/order/sign_in/${car.reg_id}'" id="create">Sign in</button>
            </c:if>
        </div>
    </body>
</html>