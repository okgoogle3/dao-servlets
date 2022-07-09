<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Profile</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/autopark/'">Home</button>
     </div>
    <p>id = "${user.id()}"</p>
    <p>name = "${user.username()}"</p>
    <c:if test = "${user.busy() == true}">
         <p>bus number = "${resultField.bus_number()}"<p>
         <p>route name = "${resultField.route_name()}"<p>
    </c:if>
</body>
</html>