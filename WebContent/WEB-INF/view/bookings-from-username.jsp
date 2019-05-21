<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">
	<h3>
		<i class="book icon"></i>Bookings
	</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			
			<th>date</th>
			<th>time</th>
			<th>username</th>
			<th>vehicleToCheck</th>
			<th>Confirmed</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempBooking" items="${bookings}">

			<tr>
		
				<td>${tempBooking.date}</td>
				<td>${tempBooking.time}</td>
				<td>${tempBooking.username}</td>
				<td>${tempBooking.vehicleToCheck}</td>
				
				
				<c:choose>
            <c:when test="${tempBooking.confirmed == 'true'}">
           
               
                <td <%= "style='background-color:green;'"%>> </td> 
          
   </c:when>
      <c:otherwise>
           
                <td <%= "style='background-color:FireBrick ;'"%>><form:form action="confirm"
				
						modelAttribute="booking" method="POST" class="ui form">

						<button class="ui button" type="submit" value="${tempBooking.id}"
							name="id">
							Confirm
						</button>

					</form:form></td>  </td> 
                
          
  </c:otherwise> 
        </c:choose>
				
				 

			</tr>
		</c:forEach>
	</table>
<div>
<form action="username" modelAttribute="booking" method="POST">
	<h3>Search db</h3>
		<input type="text" name="username" placeholder="Username" 
			pattern="^[a-zA-Z0-9]+$" /><br><br>

	

<br> <input type="submit" value="Search"><br>
</form>

</div>

</div>

