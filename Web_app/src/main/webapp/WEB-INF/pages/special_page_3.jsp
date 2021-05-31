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
            <c:if test="${admin.number == 1}">
                <div>
                    <b>
                        Enter Order Parameters
                    </b>
                    <hr>
                </div>
                <form:form action="special_page_3/1/1/${order.order_id}" method="post" modelAttribute="order_inf">
                    <label for="status">
                        <b>
                            Full Name
                        </b>
                    </label>
                    <form:input path="status"/>
                    <br>
                    <input type="submit" name="Edit Order"/>
                </form:form>
            </c:if>

            <c:if test="${admin.number == 2}">
                <div>
                    <b>
                        Enter Client Parameters
                    </b>
                    <hr>
                </div>
                <form:form action="special_page_3/2/1/${client.client_id}" method="post" modelAttribute="client_inf">
                    <label for="full_name">
                        <b>
                            Full Name
                        </b>
                    </label>
                    <form:input path="full_name" type="text" name="full_name"/>
                    <br><br>
                    <label for="client_inf">
                        <b>
                            Client Information
                        </b>
                    </label>
                    <form:input path="client_inf" type="text" name="client_inf"/>
                    <br><br>
                    <label for="login">
                        <b>
                            Login
                        </b>
                    </label>
                    <form:input path="login" type="text" name="login"/>
                    <br><br>
                    <label for="password">
                        <b>
                            Password
                        </b>
                    </label>
                    <form:input path="password" type="password" name="password"/>
                    <br><br>
                    <label for="costumer_status">
                        <b>
                            Costumer Status
                        </b>
                    </label>
                    <form:input path="costumer_status" type="text" name="costumer_status"/>
                    <br>
                    <p>
                        <input name="Reset the form" type="reset"/>
                    </p>
                    <p>
                        <br>
                        <input name="Confirm the form and continue" type="submit"/>
                    </p>
                </form:form>
            </c:if>

            <c:if test="${admin.number == 5}">
                <c:if test="${admin.function == 1}">
                    <c:url var="var" value="/special_page_3/5/1/${car.reg_id}"/>
                </c:if>
                <c:if test="${admin.function == 2}">
                    <c:url var="var" value="/special_page_3/6/1/${car.reg_id}"/>
                </c:if>

                <form:form action="${var}" method="post" modelAttribute="car_inf">
                    <label for="brand">
                        <b>
                            Brand
                        </b>
                    </label>
                    <form:input path="brand" type="text" name="brand"/>
                    <br><br/>
                    <label for="manufacturer">
                        <b>
                            Manufacturer
                        </b>
                    </label>
                    <form:input path="manufacturer" type="text" name="manufacturer"/>
                    <label for="technical_not">
                        <b>
                            Technical Notifications
                        </b>
                    </label>
                    <form:input path="technical_not" type="text" name="technical_not"/>
                    <label for="addition_devices">
                        <b>
                            Additional devices
                        </b>
                    </label>
                    <form:input path="addition_devices" type="text" name="addition_devices"/>
                    <label for="costumer_not">
                        <b>
                            Costumer Notifications
                        </b>
                    </label>
                    <form:input path="costumer_not" type="text" name="costumer_not"/>
                    <label for="mutable_not">
                        <b>
                            Mutable Notifications
                        </b>
                    </label>
                    <form:input path="mutable_not" type="text" name="mutable_not"/>
                </form:form>
            </c:if>
        </div>
    </body>
</html>