<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Drivers</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/autopark/'">Home</button>
     </div>

    <c:forEach var="route" items="${routes}">
         <p>route id = "${route.id()}"
         route name = "${route.name()}"<p>
         <hr>
    </c:forEach>
</body>
</html>