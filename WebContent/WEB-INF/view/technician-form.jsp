<style>
<!--
.field {
    width: 450px;

 }
.ui form {
    width: 420px;
   
}

.ui submit button{
	
	margin-left: -4px
}

-->
</style>



<div>
	<br>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_TECH')">
	<h3>Create Vehicle Card</h3>
	<form action="createCard" method="POST" class="ui form">
		<input type="text" name="license_plate" placeholder="License Plate"
			pattern="^[a-zA-Z0-9]+$" required="true" /><br>
		<h4>Inspection Date</h4>
		<input type="date" name="inspection_date"
			placeholder="inspection_date" required="true"/><br>
		<h4>Next Inspection Date</h4>
		<input type="date" name="next_inspection_date"
			placeholder="next_inspection_date" required="true"/><br>
		<h4>ModelType</h4>
		<input type="radio" name="model" value="car" checked> car<br>
		<input type="radio" name="model" value="truck"> truck<br>
		<h4>CC</h4>
		<input type="text" name="cc" placeholder="CC" pattern="^[0-9]+$" required="true"/><br>
		<h4>Results</h4>
		<input type="radio" name="results" value="Success" checked>Success<br>
		<input type="radio" name="results" value="Failure">Failure <br>
		<br> <input type="submit" value="Create" class="ui button">
	</form>
	<br>
	<%
		String create_msg = (String) request.getAttribute("create");
		if (create_msg != null)
			out.println("<font color=red size=3px>" + create_msg + "</font>");
	%>
	<br>
	<h3>Update Vehicle Card</h3>
	<br>
	<form action="updateCardDelete" class="ui form">
		<input type="text" name="license_plate" placeholder="License Plate"  pattern="^[a-zA-Z0-9]+$" required="true">
		<br>
		<br> <input type="submit" value="Update" class="ui button">
	</form>
	<br>
	<%
				String update_msg = (String) request.getAttribute("update_msg");
				if (update_msg != null)
					out.println("<font color=red size=4px>" + update_msg + "</font>");
			%>
			</sec:authorize>
			<sec:authorize access="!hasAnyRole('ROLE_TECH')">
			<br>
			<br>
			<br>
			<br>
			<div class="ui middle aligned center aligned grid">
  			<div class="column">
			
		<h2 class="ui icon header">
  <i class="remove circle outline icon"></i>
  <div class="content">
    Access Denied
    <div class="sub header">Please Login As An Technician <a href="<c:url value="/login/logout" />"><strong></strong>Here</a> </div>
  </div>
</h2>
			</div>
			</div>
			<br>
			<br>
			<br>
			<br>
			</sec:authorize>