<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
    <head>
        <title>Sign in</title>
    </head>
    <body>
        <c:if test="${sign_in_again == false}">
            <div>       <!-- header -->
                <hr>
                <h1>
                    Sign in to continue
                </h1>
                <hr>
            </div>
        </c:if>

        <c:if test="${sign_in_again == true}">
            <div>       <!-- header -->
                <hr>
                <h1>
                    Failure of authorisation. Sign in again to continue
                </h1>
                <hr>
            </div>
        </c:if>

        <div>       <!-- content -->
            <c:if test="${start_page == true}">
                <c:url var="var" value="/sign_in/start_page/"/>
            </c:if>
            <c:if test="${start_page == false}">
                <c:url var="var" value="/order/${car.reg_id}"/>
            </c:if>
            <form:form action="${var}" method="get" modelAttribute="client_inf">
                <label for="login">Login</label>
                <form:input type="text" name="login" id="login" path="login"/>
                <br/>
                <br/>
                <label for="password">Password</label>
                <form:input type="password" name="password" id="password" path="password"/>
                <br/>
                <br/>
                <button name="Log in" id="log_in" type="submit" >Log in</button>
            </form:form>
        </div>
    </body>
</html>