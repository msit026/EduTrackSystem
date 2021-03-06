<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>

<html lang="EN" dir="ltr" xml:lang="EN"
	xmlns="http://www.w3.org/1999/xhtml">
<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=iso-8859-1" />
<title>File Upload Page</title>
<meta content="no" http-equiv="imagetoolbar" />
<link type="text/css" href="styles/layout.css" rel="stylesheet" />
</head>
<body id="top">
	<div class="wrapper col1">
		<div id="header">
			<div id="logo">
				<h1>
					<a href="#">LC Solutions</a>
				</h1>
				<p>
					<strong>Helping you build your dream</strong>
				</p>
			</div>

			<br class="clear" />
		</div>
	</div>
	<div class="wrapper col2">
		<div id="topbar">
			<div style="width: 100%; float: right;" id="topnav">
				<ul style="width: 100%; float: right">
					<li><a href="adminHomePage.jsp">Home</a></li>
					<li class="active"><a href="fileUploadPage.jsp">Upload Files</a></li>
					<li><a href="#">Approve User</a>
						<ul>
							<li><a href="ShowPendingRequestsServlet">Students</a></li>
							<li><a href="ShowMentorsPendingRequestsServlet">Mentors</a></li>
						</ul></li>

					<li><a href="#">View Data</a>
						<ul>
							<li><a href="ShowRegisteredStudents.jsp">Registered
									Students</a></li>
							<li><a href="ShowUnRegisteredStudents.jsp">Unregistered
									Students</a></li>
							<li><a href="ShowRegisteredMentors">Registered Mentors</a></li>
							<li><a href="ShowUnregisteredMentors">UnRegistered
									Mentors</a></li>
							<li><a href="ShowCoursesServelt">Courses</a></li>
							<li><a href="ShowGrades.jsp">Grades</a></li>
						</ul></li>

					<li><a href="Templates.jsp">Templates</a></li>
					<li><a href="userContactUs.jsp">Contact Us</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>

	<div class="wrapper col4">
		<div id="container">
			<div id="content">
				<h2>Upload files</h2>
				<form name="myForm" id="myForm" method="post"
					action="FileUploadServlet" enctype="multipart/form-data"
					onSubmit="return alertError()">
					<fieldset>
						<legend>NewsLetter</legend>
						<table>
							<tr>
								<td width="110px"><label id="fileType" name="fileType">File
										Regarding</label></td>
								<td><select NAME="type">
										<option value="studentDetails">Student Details</option>
										<option value="mentorDetails">Mentor Details</option>
										<option value="attendance">Attendance</option>
										<option value="courseDetails">Course Details</option>
										<option value="grades">Grades</option>
								</select></td>
							</tr>
							<tr>
								<td><label id="fileChoose" name="fileChoose">Choose
										File</label></td>
								<td><input type="file" style="border: none" id="fileChosen"
									name="fileChosen" accept=" application/vnd.ms-excel" /></td>
							</tr>
							<tr colspan=2>
								<td style="align: center"><br /> <input type="submit"
									value="Upload" id="buttonSubmit" name="buttonSubmit" /></td>
							</tr>
						</table>
				</form>
			</div>
		</div>
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" />

		<div class="wrapper col7">
			<div id="copyright">
				<p class="fl_left">
					Copyright � 2014 - All Rights Reserved - <a href="#">MSITMedhas</a>
				</p>
				<a href="#"></a> <br class="clear" />
			</div>
		</div>
</body>
</html>
<%
	}
%>