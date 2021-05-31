<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="ru">
    <head>
        <title>Start page</title>
    </head>
    <body>
        <div>  <!-- header -->
            <hr>
            <h1>
                Choose required notifications:
            </h1>
            <hr>
        </div>

        <div>       <!-- content -->
            <c:if test="${client.login == null}">
                <button onclick="location.href='/sign_in'" id="sign_in">Sign in</button>
                <hr>
            </c:if>
            <c:if test="${client.login != null}">
                <div>
                    <h3>
                        ${client.full_name}
                    </h3>
                    <hr>
                </div>
            </c:if>
            <br>
            <div>    <!-- forms holder -->
                <c:if test="${client.login != null}">
                    <c:url var="var" value="/sign_in/confirm_form/${client.client_id}"/>
                </c:if>
                <c:if test="${client.login == null}">
                    <c:url var="var" value="/confirm_form"/>
                </c:if>
                <form:form action="${var}" method="get" lang="ru" modelAttribute="car_inf">
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
                        <button name="Reset the form" id="reset" type="reset">Reset the form</button>
                    </p>
                    <p>
                        <br>
                        <button name="Confirm the form and continue" id="submit" type="submit">Confirm the form and continue</button>
                    </p>
                </form:form>
            </div>
        </div>
    </body>
</html>
