<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Login</title></head>
     <body>

<form action="/app/autopark/" method="post">
    <div class="container">
        <div visible="hidden">
                <input type="hidden" name="command" value="CommandLogin">
         </div>
        <h1>Login</h1>
        <p>Please fill in this form to login in your account.</p>
        <hr>
        <c:if test = "${incorrect == true}">
                         <p>Incorrect username or password!<p>
                </c:if>
        <label><b>UserName</b></label>
        <input name="username" type="text" placeholder="Enter UserName" required>

        <label><b>Password</b></label>
        <input name="password" type="password" placeholder="Enter Password" required>
        <hr>

        <button type="submit" class="registerbtn">Login</button>
    </div>

</form>
</body>
</html>