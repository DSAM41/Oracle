<%@ page import="java.sql.*" %>
<%

	try{
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","admin","admin");
		Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery("select * from users");
		
		while(rs.next())
		{
			System.out.println(rs.getString("EMAIL"));
		}
	}catch(Exception e){
		out.print(e);
		System.out.println(e);
		System.out.println("aaa");
	}


%>