<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update a User</h3>

	<form:form action="updateUseradd" modelAttribute="customer"
		method="POST" class="ui form">
		<div class="field">
			<label>Username</label> <input type="text" name="username" required="true"/>
		</div>
		<div class="field">
			<label>Password</label> <input type="password" name="password" required="true"/>
		</div>
		<div class="field">
			<label>Name</label> <input type="text" name="name" pattern="^[a-zA-Z]+$" required="true"/>
		</div>
		<div class="field">
			<label>Surname</label> <input type="text" name="surname" pattern="^[a-zA-Z]+$" required="true"/>
		</div>
		<div class="field">
			<label>Email</label> <input type="text" name="email" required="true"/>
		</div>
		<div class="field">
			<select id="role" name="role">
				<option value="Administrator">Administrator</option>
				<option value="Secretariat">Secretariat</option>
				<option value="Technician">Technician</option>
			</select>
		</div>
		<button class="ui button" type="submit">Update</button>
	</form:form>
	<%
		String update_msg = (String) request.getAttribute("update_msg");
		if (update_msg != null)
			out.println("<font color=red size=4px>" + update_msg + "</font>");
	%>
</div>