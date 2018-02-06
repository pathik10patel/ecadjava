<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
session.setAttribute("a", "b");

String num=application.getAttribute("count").toString();
int i,len=num.length();


while(num.length()<8)
{
	num="0"+num;
}
char[] chars = num.toCharArray();
for(i=0;i<8;i++)
{
	%>
	
	<img src="nums/<%= chars[i] %>.png">
	<%
}
%>
Active User::: <%=application.getAttribute("count") %>
<a href="logout.jsp">Log out</a>

</body>
</html>