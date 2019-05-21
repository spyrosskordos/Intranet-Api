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


	<br> <br>
<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
	<h3>Create a new User</h3>
	
	<form:form action="${pageContext.request.contextPath}/user/registerUser"
		method="POST" class="ui form">
		<input type="text" name="name" placeholder="name" pattern="^[a-zA-Z]+$" required="true" />&nbsp &nbsp &nbsp
		<input type="text" name="surname" placeholder="surname" pattern="^[a-zA-Z]+$" required="true"/> &nbsp
		&nbsp &nbsp<input type="text" name="email" placeholder="email" required="true"/> <br>
		<br> <input type="text" name="username" placeholder="userid" required="true"/>&nbsp
		&nbsp &nbsp <input type="password" name="password"
			placeholder="password" required="true"/><br>
		<h4>Role</h4>
		<select id="role" name="role">
			<option value="ROLE_ADMIN">Administrator</option>
			<option value="ROLE_SEC">Secretariat</option>
			<option value="ROLE_TECH">Technician</option>
		</select><br> <br> <input  type="submit" value="Create" class="ui button">
</form:form>
	<br>
	<%
				String create_msg = (String) request.getAttribute("create");
				if (create_msg != null)
					out.println("<font color=red size=3px>" + create_msg + "</font>");
			%>
	<br>
	<div>
		<h3>Delete a user</h3>
		<form action="deleteUser" class="ui form">
			<select id="username" name="username">
				<c:forEach var="tempCustomer" items="${users}">
				
					<option value=${tempCustomer.username}>${tempCustomer.username}</option>
					
				</c:forEach>
			</select> <br> <br> 
			<input type="submit" value="Delete" class="ui button">
		</form>
		<br>
		<%
			String delete_msg = (String) request.getAttribute("delete_msg");
			if (delete_msg != null)
				out.println("<font color=red size=4px>" + delete_msg + "</font>");
		%>
		<div>
			<h3>Update a user</h3>
			<form action="updateUser" class="ui form">
				<input type="text" name="username" placeholder="username"><br>
				<br> <input type="submit" value="Update" class="ui button">
			</form>
			<br>
			<%
				String update_msg = (String) request.getAttribute("update_msg");
				if (update_msg != null)
					out.println("<font color=red size=4px>" + update_msg + "</font>");
			%>
			</sec:authorize>
			<sec:authorize access="!hasAnyRole('ROLE_ADMIN')">
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
    <div class="sub header">Please Login As An Admin <a href="<c:url value="/login/logout" />"><strong></strong>Here</a> </div>
  </div>
</h2>
			</div>
			</div>
			<br>
			<br>
			<br>
			<br>
			</sec:authorize>