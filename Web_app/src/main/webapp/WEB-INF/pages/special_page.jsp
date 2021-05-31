<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="ru">
    <head>
        <title>Special page</title>
    </head>

    <body>
        <div>  <!-- header -->
            <hr>
            <h1>
                Welcome to special page, please enter required parameters:
            </h1>
            <hr>
        </div>

        <div>
            <c:if test="${admin.function == 1}">
                <c:url value="/special_page_2/1" var="var"/>
                <div>
                    <b>
                        Enter Order ID
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function == 2}">
                <c:url value="/special_page_2/2" var="var"/>
                <div>
                    <b>
                        Enter Car ID
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function == 3}">
                <c:url value="/special_page_2/3" var="var"/>
                <div>
                    <b>
                        Enter Client ID
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function == 4}">
                <c:url value="/special_page_2/4" var="var"/>
                <div>
                    <b>
                        Enter Client ID
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function == 5}">
                <c:url value="/special_page_2/5" var="var"/>
                <div>
                    <b>
                        Enter Order Notifications
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function == 6}">
                <c:url value="/special_page_2/6" var="var"/>
                <div>
                    <b>
                        Enter Car Notifications
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function == 7}">
                <c:url value="/special_page_2/7" var="var"/>
                <div>
                    <b>
                        Enter Order Parameters
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function == 8}">
                <div>
                    <b>
                        Enter Client Parameters
                    </b>
                    <hr>
                </div>
                <form:form action="/special_page_2/8" method="get" modelAttribute="client">
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

            <c:if test="${admin.function == 9}">
                <c:url value="/special_page_2/9" var="var"/>
                <div>
                    <b>
                        Choose Car Parameters
                    </b>
                    <hr>
                </div>
            </c:if>

            <c:if test="${admin.function_1 == 1}">
                <form:form action="${var}" method="get" modelAttribute="admin">
                    <label for="Order id">
                        <b>
                            ID
                        </b>
                    </label>
                    <form:input path="number" type="text" name="Order id" id="_id"/>
                    <br>
                    <p>
                        <input name="Reset the form" type="reset"/>
                    </p>
                    <p>
                        <br>
                        <input name="Confirm the form and continue" type="submit" id="id_submit"/>
                    </p>
                </form:form>
            </c:if>

            <c:if test="${admin.function_1 ==2}">
                <form:form action="${var}" method="get" modelAttribute="order">
                    <label for="test_drive">
                        <b>
                            Test drive
                        </b>
                    </label>
                    <form:select name="test_drive" id="test_drive" path="test_drive">
                        <form:option value="true">true</form:option>
                        <form:option value="false">false</form:option>
                    </form:select>
                    <br><br>
                    <label for="date_of_order">
                        <b>
                            Date of Order
                        </b>
                    </label>
                    <form:input type="text" path="date_of_order" name="date_of_order" id="date_of_order"/>
                    <br><br>
                    <label for="status">
                        <b>
                            Status
                        </b>
                    </label>
                    <form:input type="text" path="status" name="status" id="status"/>
                    <br>
                    <p>
                        <input name="Reset the form" type="reset"/>
                    </p>
                    <p>
                        <br>
                        <input name="Confirm the form and continue" type="submit" id="order_submit"/>
                    </p>
                </form:form>
            </c:if>

            <c:if test="${admin.function_1 == 3}">
                <form:form action="${var}" method="get" modelAttribute="car">
                    <label for="brand">
                        <b><br>
                            Choose car brand
                        </b><br>
                    </label>
                    <form:select name="brand" id="brand" path="brand">
                        <c:forEach var="brand" items="${form.brands}">
                            <option value=${brand}>${brand}</option>
                        </c:forEach>
                    </form:select>

                    <label for="manufacturer">
                        <b><br>
                            Choose car manufacturer
                        </b><br>
                    </label>
                    <form:select name="manufacturer" id="manufacturer" path="manufacturer">
                        <c:forEach var="manufacturer" items="${form.manufacturers}">
                            <option value=${manufacturer}>${manufacturer}</option>
                        </c:forEach>
                    </form:select>

                    <label for="technical_not">
                        <b><br>
                            Choose car technical_not
                        </b><br>
                    </label>
                    <form:select name="technical_not" id="technical_not" path="technical_not">
                        <c:forEach var="technical_not" items="${form.technical_notifications}">
                            <option value=${technical_not}>${technical_not}</option>
                        </c:forEach>
                    </form:select>

                    <label for="addition_devices">
                        <b><br>
                            Choose car addition_devices
                        </b><br>
                    </label>
                    <form:select name="addition_devices" id="addition_devices" path="addition_devices">
                        <c:forEach var="addition_devices" items="${form.additions_devices}">
                            <option value=${addition_devices}>${addition_devices}</option>
                        </c:forEach>
                    </form:select>

                    <label for="costumer_not">
                        <b><br>
                            Choose car costumer_not
                        </b><br>
                    </label>
                    <form:select name="costumer_not" id="costumer_not" path="costumer_not">
                        <c:forEach var="costumer_not" items="${form.costumer_notifications}">
                            <option value=${costumer_not}>${costumer_not}</option>
                        </c:forEach>
                    </form:select>

                    <label for="mutable_not">
                        <b><br>
                            Choose car mutable_not
                        </b><br>
                    </label>
                    <form:select name="mutable_not" id="mutable_not" path="mutable_not">
                        <c:forEach var="mutable_not" items="${form.mutable_notifications}">
                            <option value=${mutable_not}>${mutable_not}</option>
                        </c:forEach>
                    </form:select>
                    <p>
                        <input name="Reset the form" type="reset"/>
                    </p>
                    <p>
                        <br>
                        <input name="Confirm the form and continue" type="submit"/>
                    </p>
                </form:form>
            </c:if>
        </div>
    </body>
</html>