<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="ru">
    <head>
        <title>Start page</title>
    </head>
    <body>
        <!-- header -->
        <div>
            <hr>
            <h1>
                Choose required notifications:
            </h1>
            <hr>
        </div>

        <div>       <!-- content -->
            <button onclick="location.href='/sign_in'">Sign in</button>
            <br>
            <div>    <!-- buttons holder -->
                <form action="/confirm_form" method="post" name="Cars notifications">
                    <p>
                        <b>
                            Choose car brand
                        </b>
                    </p>
                    <select name="brand" id="brand">
                        <c:forEach var="brand" items="${form.brands}">
                        <option value=${brand}>${brand}</option>
                        </c:forEach>
                    </select>

                    <p>
                        <b>
                            Choose car manufacturer
                        </b>
                    </p>
                    <select name="manufacturer" id="manufacturer">
                        <c:forEach var="manufacturer" items="${form.manufacturers}">
                            <option value=${manufacturer}>${manufacturer}</option>
                        </c:forEach>
                    </select>
                    <p>
                        <b>
                            Choose car technical_not
                        </b>
                    </p>
                    <select name="technical_not" id="technical_not">
                        <c:forEach var="technical_not" items="${form.technical_notifications}">
                            <option value=${technical_not}>${technical_not}</option>
                        </c:forEach>
                    </select>

                    <p>
                        <b>
                            Choose car addition_devices
                        </b>
                    </p>
                    <select name="addition_devices" id="addition_devices">
                        <c:forEach var="addition_devices" items="${form.additions_devices}">
                            <option value=${addition_devices}>${addition_devices}</option>
                        </c:forEach>
                    </select>

                    <p>
                        <b>
                            Choose car costumer_not
                        </b>
                    </p>
                    <select name="costumer_not" id="costumer_not">
                        <c:forEach var="costumer_not" items="${form.costumer_notifications}">
                            <option value=${costumer_not}>${costumer_not}</option>
                        </c:forEach>
                    </select>

                    <p>
                        <b>
                            Choose car mutable_not
                        </b>
                    </p>
                    <select name="mutable_not" id="mutable_not">
                        <c:forEach var="mutable_not" items="${form.mutable_notifications}">
                            <option value=${mutable_not}>${mutable_not}</option>
                        </c:forEach>
                    </select>
                    <p>
                        <input name="Reset the form" type="reset"/>
                    </p>
                </form>
            </div>
            <br>
            <button onclick="location.href='/confirm_form'">
                Confirm the form and continue
            </button>
        </div>
    </body>
</html>
