<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">
	<h3>
		<i class="book icon"></i>Bookings
	</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			
			<th>Date</th>
			<th>Time</th>
			<th>Username</th>
			<th>VehicleToCheck</th>
			<sec:authorize access="hasAnyRole('ROLE_SEC')">
			<th>Actions</th>
			</sec:authorize>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempBooking" items="${bookings}">

			<tr>
			
				<c:choose>
            <c:when test="${tempBooking.confirmed == 'true'}">
            
				<td <%= "style='background-color:lightgreen;'"%>>${tempBooking.date}</td>
				<td <%= "style='background-color:lightgreen;'"%>>${tempBooking.time}</td>
				<td <%= "style='background-color:lightgreen;'"%>>${tempBooking.username}</td>
				<td <%= "style='background-color:lightgreen;'"%>>${tempBooking.vehicleToCheck}</td>
				<sec:authorize access="hasAnyRole('ROLE_SEC')">
                <td <%= "style='background-color:lightgreen;'"%>> 
                <form:form action="deleteBooking"
						modelAttribute="booking" method="POST" class="ui form">

						<button class="ui button" type="submit" value="${tempBooking.vehicleToCheck}"
							name="vehicleToCheck">
							<i class="remove user icon"></i> Delete
						</button>

					</form:form></td> 
          </sec:authorize>
   </c:when>
      <c:otherwise>
           		<td <%= "style='background-color:LightCoral;'"%>>${tempBooking.date}</td>
				<td <%= "style='background-color:LightCoral;'"%>>${tempBooking.time}</td>
				<td <%= "style='background-color:LightCoral;'"%>>${tempBooking.username}</td>
				<td <%= "style='background-color:LightCoral;'"%>>${tempBooking.vehicleToCheck}</td>
					<sec:authorize access="hasAnyRole('ROLE_SEC')">
                <td <%= "style='background-color:LightCoral  ;'"%>>
                <form:form action="confirm"
				
						modelAttribute="booking" method="POST" class="ui form">

						<button class="ui button" type="submit" value="${tempBooking.vehicleToCheck}"
							name="vehicleToCheck">
							<i class="checkmark icon"></i> Confirm
						</button>

					</form:form></td>  </td> 
                 </sec:authorize>
          
  </c:otherwise> 
        </c:choose>
				
				 

			</tr>
		</c:forEach>
	</table>
<div>
<form action="username" modelAttribute="booking" method="GET">
	<h3>Search Booking</h3>
	<div class="ui input focus">
		<input type="text" name="username" placeholder="Username" 
			pattern="^[a-zA-Z0-9]+$" /><br><br>
</div>
	

<br> <input type="submit" value="Search"><br>
</form>

</div>

</div>

