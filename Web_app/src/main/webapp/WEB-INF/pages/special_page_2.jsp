<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="ru">
    <head>
        <title>Special page 2</title>
    </head>

    <body>
        <div>  <!-- header -->
            <hr>
            <h1>
                Welcome to special page 2, please enter required option:
            </h1>
            <hr>
        </div>

        <div>
            <c:if test="${number == 1}">
                <table>
                    <tr>
                        <td>Order ID</td>
                        <td>Client ID</td>
                        <td>Car ID</td>
                        <td>Test drive</td>
                        <td>Data of Order</td>
                        <td>Status</td>
                        <td>Action</td>
                    </tr>
                    <tr>
                        <td>${order.order_id}</td>
                        <td>${order.clients.client_id}</td>
                        <td>${order.car_id.reg_id}</td>
                        <td>${order.test_drive}</td>
                        <td>${order.date_of_order}</td>
                        <td>${order.status}</td>
                        <td>
                            <form:form action="/special_page_3/1/1" method="get" modelAttribute="order">
                                <form:button>Edit Order</form:button>
                            </form:form>
                            <form:form action="/special_page_3/1/2" method="post" modelAttribute="order">
                                <form:button>Delete Order</form:button>
                            </form:form>
                        </td>
                    </tr>
                </table>
            </c:if>
            <c:if test="${number == 2}">
                <table>
                    <tr>
                        <td>Client ID</td>
                        <td>Client Full Name</td>
                        <td>Client Client Information</td>
                        <td>Client Login</td>
                        <td>Client Status</td>
                        <td>Action</td>
                    </tr>
                    <tr>
                        <td>${client.client_id}</td>
                        <td>${client.full_name}</td>
                        <td>${client.client_inf}</td>
                        <td>${client.login}</td>
                        <td>${client.costumer_status}</td>
                        <td>
                            <form:form action="/special_page_3/2/1" method="get" modelAttribute="client">
                                <form:button>Edit Client</form:button>
                            </form:form>
                            <form:form action="/special_page_3/2/2/${client.client_id}" method="post" modelAttribute="client"  id="delete_client">
                                <form:button>Delete Client</form:button>
                            </form:form>
                        </td>
                    </tr>
                </table>
            </c:if>
            <c:if test="${number == 3}">
                <table>
                    <tr>
                        <td>Order ID</td>
                        <td>Client ID</td>
                        <td>Car ID</td>
                        <td>Test drive</td>
                        <td>Data of Order</td>
                        <td>Status</td>
                        <td>Action</td>
                    </tr>
                    <c:forEach var="order_inf" items="${orders}">
                        <tr>
                            <td>${order_inf.order_id}</td>
                            <td>${order_inf.clients.client_id}</td>
                            <td>${order_inf.car_id.reg_id}</td>
                            <td>${order_inf.test_drive}</td>
                            <td>${order_inf.date_of_order}</td>
                            <td>${order_inf.status}</td>
                            <td>
                                <form:form action="/special_page_3/1/1" method="get" modelAttribute="order_inf">
                                    <form:button>Edit Order</form:button>
                                </form:form>
                                <form:form action="/special_page_3/1/2" method="post" modelAttribute="order_inf">
                                    <form:button>Delete Order</form:button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${number == 4}">
                <table>
                    <tr>
                        <td>Client ID</td>
                        <td>Client Full Name</td>
                        <td>Client Client Information</td>
                        <td>Client Login</td>
                        <td>Client Status</td>
                        <td>Action</td>
                    </tr>
                    <c:forEach var="client_inf" items="${clients}">
                        <tr>
                            <td>${client_inf.client_id}</td>
                            <td>${client_inf.full_name}</td>
                            <td>${client_inf.client_inf}</td>
                            <td>${client_inf.login}</td>
                            <td>${client_inf.costumer_status}</td>
                            <td>
                                <form:form action="/special_page_3/2/1" method="get" modelAttribute="client_inf">
                                    <form:button>Edit Client</form:button>
                                </form:form>
                                <form:form action="/special_page_3/2/2" method="post" modelAttribute="client_inf">
                                    <form:button>Delete Client</form:button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${number == 5}">
                <table>
                    <tr>
                        <th>brand</th>
                        <th>manufacturer</th>
                        <th>technical_not</th>
                        <th>addition_devices</th>
                        <th>costumer_not</th>
                        <th>mutable_not</th>
                        <th>price</th>
                        <th>action</th>
                    </tr>
                    <c:forEach var="car_inf" items="${cars}">
                        <tr>
                            <td>${car_inf.brand}</td>
                            <td>${car_inf.manufacturer}</td>
                            <td>${car_inf.technical_not}</td>
                            <td>${car_inf.addition_devices}</td>
                            <td>${car_inf.costumer_not}</td>
                            <td>${car_inf.mutable_not}</td>
                            <td>${car_inf.price}</td>
                            <td>
                                <form:form action="/special_page_3/5/1" method="get" modelAttribute="car_inf">
                                    <form:button>Edit Car</form:button>
                                </form:form>
                                <form:form action="/special_page_3/5/2" method="post" modelAttribute="car_inf">
                                    <form:button>Delete Car</form:button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <form:form action="/special_page_3/6/1/${car.reg_id}" method="get" modelAttribute="car">
                    <form:button>Edit Cars</form:button>
                </form:form>
                <form:form action="/special_page_3/6/2/${car.reg_id}" method="get" modelAttribute="car">
                    <form:button>Delete Cars</form:button>
                </form:form>
            </c:if>
        </div>
    </body>
</html>