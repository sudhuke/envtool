<%@ page import="java.util.*" %>
<%@ page import="com.envtool.db.EnvDetails" %>
<html>
<title>View Env Details</title>
<body>
<%
ArrayList list = EnvDetails.viewEnvDetails();

		 	 if (list.size() != 0)
		 	 {
		 	    System.out.println("Total No of records found is"+list.size());
		 	 
		 	
		 	 System.out.println(list.size());
		 	 %><table BORDER=1 CELLPADDING=3 CELLSPACING=5 ><% 	
		 	for(int i=0;i<list.size();i++)
		 	{
		 	   Object[] o = (Object[]) list.get(i);
		 	   System.out.println("No of colums:"+o.length);
		 	   
		 	   %> <tr>
		 	   <%
		 	  for(int j=0;j<o.length;j++)
		 	  {
		 	   %>
		 	   <td><%
		 	   if(j==2)
		 	   { 
		 	   %>
		 	   <a href="<%
		 	    out.println(o[j].toString()); 
		 	   %>" target="_blank"><%
		 	    out.println(o[j].toString());
		 	    %> </a> <% 
		 	    } 
		 	   
		 	    else
		 	    {
		 	    out.println(o[j].toString());
		 	   }
		 	   %></td><%
		    }
		     %></tr><%
		     }
		   
		    
		    }
%>
</table>
</body>
</html>

		    
		    