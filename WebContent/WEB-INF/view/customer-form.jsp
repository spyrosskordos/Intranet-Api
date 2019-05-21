<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<br>
	<h3>Add a Customer</h3>

	<form:form action="saveCustomer" modelAttribute="customer"
		method="POST" class="ui form">
		<div class="field">
			<label>First Name</label>
			<form:input path="firstName" required="true" pattern="^[a-zA-Z0-9]+$" />
		</div>
		<div class="field">
			<label>Last Name</label>
			<form:input path="lastName" required="true" pattern="^[a-zA-Z0-9]+$" />
		</div>
		<div class="field">
			<label>Email</label>
			<form:input path="email" required="true" />
		</div>
		<button class="ui button" type="submit">Save</button>
		
	</form:form>
</div>