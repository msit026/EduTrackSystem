/**
 * 
 * 
 */
function validateName()
{ 
	var f=document.forms["registration"]["fname"].value;
	var l=document.forms["registration"]["lname"].value;	
	if(f==null || f=="" || f>=0 ||/[0-9]/.test(f) && /[a-zA-Z]/.test(f))
	{
		   document.getElementById("error").innerHTML="Invalid name ";
		  
	}
	else
	{
		document.getElementById("error").innerHTML="";
	}
}
function validateLname()
{ 
	var l=document.forms["registration"]["lname"].value;	
	if(l==null || l=="" || l>=0 ||/[0-9]/.test(l) && /[a-zA-Z]/.test(l))
	{
		   document.getElementById("error000").innerHTML="Invalid name ";
	}	
	else
	{
		document.getElementById("error000").innerHTML="";
	}	
}

function validateEmail()
{
	 
  var email = document.registration.emailId.value;
  atpos = email.indexOf("@");
  dotpos = email.lastIndexOf(".");
  if (email == "" || atpos < 1 || ( dotpos - atpos < 2 )) 
  {
     document.getElementById("error5").innerHTML="Invalid Email ";
     return false;
  }
  else
	{
		document.getElementById("error5").innerHTML="";
	}	
}
function validatePassword()
{
  var pwd=document.registration.password.value;
  if(pwd="" || pwd.length < 8)
  {
     document.getElementById("error6").innerHTML="minimum 8 characters ";
     return false;
  }
  else
	{
		document.getElementById("error6").innerHTML="";
	}	

}
function validateRePassword()
{
	var pwd=document.registration.password.value;
	var pwd2=document.registration.reenter.value;
	if(pwd!=pwd2)
	{
		document.getElementById("error7").innerHTML="Password mismatch";
		document.getElementById("password").value="";
		document.getElementById("reenter").value="";
	}
	else
	{
		document.getElementById("error7").innerHTML="";
	}	
}
function validateDate()
{
  if( document.registration.dob.value == "" )
  {
     document.getElementById("error2").innerHTML="Enter Date of Birth";
	 return false;
  }
  else
	{
		document.getElementById("error2").innerHTML="";
	}	
}
function validateRole()
{
  if ( ( registration.role.value == "" ) && ( registration.role.value == null ) )
  {
     document.getElementById("error0").innerHTML="Please choose your Gender: Male or Female" ;
     return false;
  } 
  else
	{
		document.getElementById("error0").innerHTML="";
	}	
}

function validateGender()
{
  if ( ( registration.gender[0].checked == false ) && ( registration.gender[1].checked == false ) )
  {
     document.getElementById("error3").innerHTML="Please choose your Gender: Male or Female" ;
     return false;
  } 
  else
	{
		document.getElementById("error3").innerHTML="";
	}	
}


function validateAdress()
{
  if( document.registration.address.value == "" )
  {
     document.getElementById("error1").innerHTML="Provide Address" ;
     document.registration.address.focus() ;
     return false;
  } 
  else
	{
		document.getElementById("error1").innerHTML="";
	}	
}
function validateMobile()
{
  if( document.registration.mobileno.value == "" || isNaN( document.registration.mobileno.value) ||  document.registration.mobileno.value.length != 10 )
  {
     document.getElementById("error4").innerHTML="Enter digits(0-9)" ;
     //document.registration.mobileno.focus() ;
     return false;
  }
  else
	{
		document.getElementById("error4").innerHTML="";
	}	
  return( true );
}


function funcDisplay()
{
	document.getElementById("fill2").style.visibility="hidden";
    //document.getElementById("programme").style.visibility="hidden";
    //document.getElementById("programmeLabel").style.visibility="hidden";
    document.getElementById("fill1").style.visibility="hidden";
}
function verifyUser()
{
	var e = document.getElementById("role");
	var v1=e.options[e.selectedIndex].value;
		if(v1=="Mentor")
		{
		document.getElementById('fill1').innerHTML ="<span style = \"font-size:14px;color:black\">Department</span>";
		document.getElementById('fill2').innerHTML ="<select id='department' name='department' required> <option>Select</option><option>IT</option><option>SS</option></select>";
		 document.getElementById("fill1").style.visibility="visible";
		 document.getElementById("fill2").style.visibility="visible";
		}
		if(v1=="Student")
		{
		document.getElementById('fill1').innerHTML ="<span style = \"font-size:14px;color:black\">Current Year</span>";
		document.getElementById('fill2').innerHTML ="<select id='currentYear' name='currentYear' required> <option>Select</option><option>1</option><option>2</option></select>";
		 document.getElementById("fill1").style.visibility="visible";
		 document.getElementById("fill2").style.visibility="visible";
			
		}
}


function alertError1(){
	var flag = 1;
	if(document.registration.role.value=="--select--")
	{	
		document.getElementById("role").style.display="block";
		document.getElementById("role").style.border = "solid 1px red";
		flag = 0;
	}
	if(document.registration.id.value=="")
	{		
		document.getElementById("id").style.display="block";
		document.getElementById("id").style.border = "solid 1px red";
		flag = 0;
	}	
	if(document.registration.fname.value=="")
	{		
		document.getElementById("fname").style.display="block";
		document.getElementById("fname").style.border = "solid 1px red";
		flag = 0;
	}	
	if(document.registration.lname.value=="")
	{		
		document.getElementById("lname").style.display="block";
		document.getElementById("lname").style.border = "solid 1px red";
		flag = 0;
	}	
		
	if(document.registration.address.value=="")
	{		
		document.getElementById("address").style.display="block";
		document.getElementById("address").style.border = "solid 1px red";
		flag = 0;
	}	
	if(document.registration.dob.value=="")
	{		
		document.getElementById("dob").style.display="block";
		document.getElementById("dob").style.border = "solid 1px red";
		flag = 0;
	}	
	/*if(document.registration.address.value=="")
	{		
		document.getElementById("gender").style.display="block";
		document.getElementById("gender").style.border = "solid 1px red";
		flag = 0;
	}	*/
//	if(document.registration.mobileno.value=="")
//	{		
//		document.getElementById("mobileno").style.display="block";
//		document.getElementById("mobileno").style.border = "solid 1px red";
//		flag = 0;
//	}	
	if(document.registration.emailId.value=="")
	{		
		document.getElementById("emailId").style.display="block";
		document.getElementById("emailId").style.border = "solid 1px red";
		flag = 0;
	}	
	if(document.registration.reenter.value=="")
	{		
		document.getElementById("reenter").style.display="block";
		document.getElementById("reenter").style.border = "solid 1px red";
		flag = 0;
	}	
	if(document.registration.password.value=="")
	{		
		document.getElementById("password").style.display="block";
		document.getElementById("password").style.border = "solid 1px red";
		flag = 0;
	}	
	if(document.registration.designation != null && document.registration.designation.value=="")
	{		
		document.getElementById("designation").style.display="block";
		document.getElementById("designation").style.border = "solid 1px red";
		flag = 0;
	}	
	if(document.registration.currentYear != null && document.registration.currentYear.value=="")
	{
		document.getElementById("currentYear").style.display="block";
		document.getElementById("currentYear").style.border = "solid 1px red";
		flag = 0;
	}
	if(flag == 0)
		return false;
	else
		return true;
}
function resetField()
{
	document.getElementById("role").style.border="solid 1px black";	
	document.getElementById("id").style.border="solid 1px black";
	document.getElementById("fname").style.border="solid 1px black";
	document.getElementById("lname").style.border="solid 1px black";
	document.getElementById("address").style.border="solid 1px black";
	document.getElementById("dob").style.border="solid 1px black";
	//document.getElementById("gender").style.border="solid 1px black";
	document.getElementById("mobileno").style.border="solid 1px black";
	document.getElementById("emailId").style.border="solid 1px black";
	document.getElementById("password").style.border="solid 1px black";
	document.getElementById("reenter").style.border="solid 1px black";
}
function resetFields()
{		
	document.getElementById("id").value="";
	document.getElementById("fname").value="";
	document.getElementById("lname").value="";
	document.getElementById("address").value="";
	document.getElementById("dob").value="0000-00-00";
	document.getElementById("gender").value="";
	document.getElementById("mobileno").value="";
	document.getElementById("emailId").value="";
	document.getElementById("password").value="";
	document.getElementById("reenter").value="";
}

function setFormat()
{
	if(document.getElementById("role").value=="Student")
	{
		   document.getElementById("error00").innerHTML="(IH2013850XX) ";
		  
	}

	if(document.getElementById("role").value=="Mentor")
	{
		   document.getElementById("error00").innerHTML="(CIHL XXXX) ";
		  
	}
}