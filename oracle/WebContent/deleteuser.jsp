<%@page import="oracle.*"%>  
<jsp:useBean id="u" class="oracle.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
User_Data.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  