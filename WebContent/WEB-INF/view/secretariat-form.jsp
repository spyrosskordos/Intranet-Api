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

	<br> <br>
	<sec:authorize access="hasAnyRole('ROLE_SEC')">
	<h3>Add a Customer</h3>

	<form>
		<input type="button" value="Add" class="ui button"
			onclick="window.location.href='${pageContext.request.contextPath}/customer/showAddForm'" />
	</form>

	<h3>Delete a Customer</h3>

	<form>
		<input type="button" value="Delete" class="ui button"
			onclick="window.location.href='${pageContext.request.contextPath}/customer/showDeleteForm'" />
	</form>
<form action="searchDB" modelAttribute="vehicleDB" method="POST" class="ui form">
	<h3>Search db</h3>
		<input type="text" name="id" placeholder="License Plate"
			pattern="^[a-zA-Z0-9]+$" /><br><br>

	
<input type="radio" name="intime" value="false">Arrived out of time<br>
<br> <input type="submit" value="Search" class="ui button"><br>
<br>
	
<font color="red" size=4px>  ${message} </font>
	<h3>Total Payment for customer:</h3>
	
	<%
String pay_msg=(String)request.getAttribute("payment");  
			
if(pay_msg!=null){
	int no = Integer.parseInt(pay_msg);
	if(no<200){
	if("false".equals(request.getParameter("intime"))){
		System.out.println("ok");
		no=no+no/2;
		pay_msg="Citizen must pay "+no+" $ in total for not being in time and for the tecnhical check";
		
		out.println("<font color=red size=4px>"+pay_msg+"</font>");
		
	}else{
		pay_msg="Citizen must pay "+no+" $ in total  for the  tecnhical check";
		out.println("<font color=red size=4px>"+pay_msg+"</font>");	
	
	}
	}else{
		pay_msg="Citizen must pay "+no+ " $ in total  for not having insurance";
		out.println("<font color=red size=4px>"+pay_msg+"</font>");
	}
}


%>
	
	</form>
	
	</sec:authorize>
			<sec:authorize access="!hasAnyRole('ROLE_SEC')">
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
    <div class="sub header">Please Login As An Secreteriat <a href="<c:url value="/login/logout" />"><strong></strong>Here</a> </div>
  </div>
</h2>
			</div>
			</div>
			<br>
			<br>
			<br>
			<br>
			</sec:authorize>