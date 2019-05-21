<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<div class="ui segment">

	<br>
	<h3>Add a Customer</h3>

	<form:form action="saveCustomerList" modelAttribute="customer"
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