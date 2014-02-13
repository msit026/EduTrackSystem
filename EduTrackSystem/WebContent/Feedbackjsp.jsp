
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>

<html>
<head profile="http://gmpg.org/xfn/11">

<!--Load the AJAX API-->
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	function showStudents() {
		alert('In Show Students');
		var url = 'RetrieveStudents?cYear='
				+ document.getElementById("year").value;
		var someStudents = $.get(url, function(responseText) {
			var res = responseText;
			document.getElementById('studentId').innerHTML = res;
		});
	}
</script>



<center>
	<form name="feedbackForm" action="FeedbackServlet">
		<table>
			<tr>
				<td><label for='year'>Year : </label></td>
				<td><select name='year' id='year' onchange="showStudents()"
					required="required">
						<option value="select">Select Year</option>
						<option value='2'>2012</option>
						<option value='1'>2013</option>
				</select></td>
			</tr>

			<tr name='studentId' id='studentId' required="required">

			</tr>

			<tr>
				<td><label for='title'>Title : </label></td>
				<td><input type='text' name='title' id='title'
					required="required" /> <br></td>
			</tr>

			<tr>
				<td><label for='feedback'> Description : </label></td>
				<td><textarea name='feedback' id='feedback' required="required"></textArea></td>
			</tr>
			<tr>
				<td colspan=2>
					<center>
						<input type="submit" value="Send Feedback">
					</center>
				</td>
			</tr>
		</table>
	</form>
</center>
</body>
</html>
<%
	}
%>