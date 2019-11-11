package com.envtool.web;
import javax.servlet.*;
//import com.envtool.util.InsertEnv;
import com.envtool.db.EnvDetails;
import javax.servlet.http.*;
import java.io.*;

public class GetEnvDetails extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {    
  
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println(" Selected environment<br>");
    String rel = request.getParameter("release");
    String c = request.getParameter("env");
    String c1 = request.getParameter("url");
    String c2 = request.getParameter("ip");
    String username=request.getParameter("username");
    String passwd=request.getParameter("password");
    boolean result=EnvDetails.InsertEnvDetails(rel,c,c1,c2,username,passwd);
    EnvDetails.viewEnvDetails();    
    out.println(result);
    out.println("<br>Got env Release " + rel);
    out.println("<br>Got env Type " + c);
    out.println("<br>Got env Url " + c1);
    out.println("<br>Got env IP " + c2);
    out.println("<br>Got env user " + username);
    out.println("<br>Got env password " + passwd);
                                     
  }
                          
}                         
                          
                         
