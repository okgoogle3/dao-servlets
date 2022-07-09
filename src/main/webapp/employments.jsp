<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Employments</title></head>
     <body>
     <div>
            <button onclick="location.href='/app/autopark/'">Home</button>
     </div>
     <form action="/app/autopark/" method="post">
                       <div visible="hidden">
                           <input type="hidden" name="command" value="addEmployment">
                       </div>
                       <label><b>Add employment</b></label>
                       <input name="user_id" type="text" placeholder="Enter user id" required>
                       <input name="bus_id" type="text" placeholder="Enter bus id" required>
                       <input name="route_id" type="text" placeholder="Enter route id" required>
                       <button type="submit">Add</button>

     </form>
     <form action="/app/autopark/" method="post">
                            <div visible="hidden">
                                <input type="hidden" name="command" value="deleteEmployment">
                            </div>
                            <label><b>Delete employment</b></label>
                            <input name="user_id" type="text" placeholder="Enter user id" required>
                            <input name="bus_id" type="text" placeholder="Enter bus id" required>
                            <input name="route_id" type="text" placeholder="Enter route id" required>
                            <button type="submit">Delete</button>

     </form>
    <c:forEach var="employment" items="${employments}">
         <p>
             driver name = "${employment.username()}"
             bus number = "${employment.bus_number()}"
             route name = "${employment.route_name()}"
         <p>
         <hr>
    </c:forEach>
</body>
</html>