<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
    <head>
        <title>Sign in</title>
    </head>
    <body>
        <!-- header -->
        <hr>
        <div>
            <h1>
                Sign in to continue
            </h1>
        </div>
        <hr>
        <div>       <!-- content -->
            <form action="/sign_in/start_page/" method="POST">
                <label for="login">Login</label>
                <input type="text" name="login" id="login"/>
                <label for="password">Password</label>
                <input type="password" name="password" id="password"/>
                <input type="submit" value="Sign in"/>
            </form>
        </div>
    </body>
</html>