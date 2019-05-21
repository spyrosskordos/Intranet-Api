<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">
	<br>
	<h3>Customers</h3>
	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempCustomer" items="${customers}">

			<tr>
				<td>${tempCustomer.id}</td>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
			</tr>
		</c:forEach>
	</table>
</div>


<div class="ui segment">

	<h3>Delete a Customer</h3>

	<form:form action="deleteCustomer" modelAttribute="customer"
		method="POST" class="ui form">
		<div class="field">
			<input type="text" name="id" placeholder="Select ID" required="true"
				pattern="^[0-9]+$" />
		</div>
		<button class="ui button" type="submit">Delete</button>
	</form:form>

	<%
		String delete_msg = (String) request.getAttribute("delete_msg");
		if (delete_msg != null)
			out.println("<font color=red size=4px>" + delete_msg + "</font>");
	%>


</div>