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

	<h3>Login</h3>


	<form:form action="${pageContext.request.contextPath}/authUser"
		method="POST" class="ui form">
		<c:if test="${param.error != null}">
			<div class="ui negative message">
				<i class="close icon"></i>
				<div class="header">Oops!</div>
				<p>Sorry! Invalid username/password!</p>
			</div>
		</c:if>
		
		
		<div class="field">
			<label>User Name</label> <input type="text" name="username" />
		</div>
		<div class="field">
			<label>Password</label> <input type="password" name="password" />
		</div>
		<div class="field">
			<input type="submit" value="Login" class="ui button" />
		</div>
	</form:form>

</div>