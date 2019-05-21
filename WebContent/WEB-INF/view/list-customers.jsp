<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">
	<h3>
		List of Customers<i class="user icon"></i>
	</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<sec:authorize access="hasAnyRole('ROLE_SEC')">
			<th>Actions</th>
			</sec:authorize>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempCustomer" items="${customers}">

			<tr>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.email}</td>
				<sec:authorize access="hasAnyRole('ROLE_SEC')">
				<td><form:form action="deleteCustomer1"
						modelAttribute="customer" method="POST" class="ui form">

						<button class="ui button" type="submit" value="${tempCustomer.id}"
							name="id">
							<i class="remove user icon"></i> Delete
						</button>

					</form:form></td>
					</sec:authorize>
			</tr>
		</c:forEach>
	</table>
<sec:authorize access="hasAnyRole('ROLE_SEC')">
<a class="ui button" href="<c:url value="/customer/showAddFormFromList"></c:url>"><i
						class="add user icon"></i>Add Customer</a>
</sec:authorize>
</div>

