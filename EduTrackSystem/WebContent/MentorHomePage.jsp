
<%
	if (session.getAttribute("userType") == null) {
		response.sendRedirect("Logout");
	} else {
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN"
	dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=iso-8859-1" />
<title>Mentor Home Page</title>
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
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
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">View Reports</a>
						<ul>
							<li><a href="#">Course Report</a></li>
							<li><a href="#">Student Performance</a></li>
						</ul></li>
					<li><a href="Feedbackjsp.jsp">Give feedback</a></li>
					<li><a href="#">Send Request</a></li>
					<li><a href="EditProfilePage.jsp">Edit Profile</a></li>
					<li style="float: right"><a href="Logout">Logout</a></li>
				</ul>
			</div>
			<br class="clear" />
		</div>
	</div>
	<div class="wrapper col4">
		<div id="container">
			<div id="content"></div>
		</div>
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" />
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" /> <br class="clear" /> <br class="clear" />
		<br class="clear" /> <br class="clear" /> <br class="clear" /> <br
			class="clear" />

		<div class="wrapper col7">
			<div id="copyright">
				<p class="fl_left">
					Copyright � 2014 - All Rights Reserved - <a href="#">MSITMedhas</a>
				</p>
				<br class="clear" />
			</div>
		</div>
	</div>
</body>
</html>
<%
	}
%>