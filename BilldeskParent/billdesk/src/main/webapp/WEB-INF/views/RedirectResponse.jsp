<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Enumeration"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hacker's page ;-)</title>

<SCRIPT language="JavaScript">
function OnSubmitForm()
{
  document.cheatForm.action = document.getElementById("RU").value;
  return true;
}
</SCRIPT>



</head>
<%  
String msg = (String)request.getAttribute("msg");  ;  
String hidRequestId = (String)request.getAttribute("hidRequestId");  
String hidOperation = (String)request.getAttribute("hidOperation");  

String RU = (String)request.getAttribute("RU");  	


String requestPayload = (String)request.getAttribute("payload");

%>

  <!-- <body onLoad="document.cheatForm.submit()">  -->  
    <form method="post" name="cheatForm" onSubmit="return OnSubmitForm();">    
      Response Message:  <br />
      <textarea cols="80" name="msg" rows="2"><%= msg %></textarea>   <br /> 
      Request Id: <input type="text" name="hidRequestId" value="<%= hidRequestId %>"/> <br />
      Operation: <input type="text" name="hidOperation" value="<%= hidOperation %>"/> <br />
      Return URL: <input type="text" id="RU" name="RU" size="150" value="<%= RU %>"/> <br /><br />
      <input type="submit" value="submit" />
	</form>
<!-- </body> -->
<br /><br /><br />
	<strong>Request Payload:</strong><br /><%= requestPayload %>
</html>