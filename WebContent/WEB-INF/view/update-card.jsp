<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Update card</h3>

	<form:form action="updateCardadd" modelAttribute="customer"
		method="POST" class="ui form">
		<div class="field">
			<label>Inspection Date</label> <input type="date" name="inspection_date" required="true"/>
		</div>
		<div class="field">
			<label>Next Inspection Date</label> <input type="date" name="next_inspection_date" required="true"/>
		</div>
		<div class="field">
			<label>ModelType</label> 
		<input type="radio" name="model" value="car" checked> car<br>
		<input type="radio" name="model" value="truck"> truck<br>
		</div>
		<div class="field">
			<label>CC</label> <input type="text" name="cc" required="true"/>
		</div>
		<div class="field">
		<label>Results</label>
		<input type="radio" name="results" value="Success" checked>Success<br>
		<input type="radio" name="results" value="Failure">Failure <br>
		</div>
		<button class="ui button" type="submit">Update</button>
	</form:form>
	<%
		String update_msg = (String) request.getAttribute("update_msg");
		if (update_msg != null)
			out.println("<font color=red size=4px>" + update_msg + "</font>");
	%>
</div>