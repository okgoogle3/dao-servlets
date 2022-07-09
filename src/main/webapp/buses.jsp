<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Buses</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/autopark/'">Home</button>
     </div>

    <c:forEach var="bus" items="${buses}">
         <p>bus id = "${bus.id()}"
         bus number = "${bus.number()}"<p>
         <hr>
    </c:forEach>
</body>
</html>