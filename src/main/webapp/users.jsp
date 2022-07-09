<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Drivers</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/autopark/'">Home</button>
     </div>

    <c:forEach var="user" items="${users}">
         <p>driver id = "${user.id()}"
         driver name = "${user.name()}"<p>
         <hr>
    </c:forEach>
</body>
</html>