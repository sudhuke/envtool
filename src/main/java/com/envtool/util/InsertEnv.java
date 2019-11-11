package com.envtool.util;
public class InsertEnv {

public static String insert(String release, String env,String ip,String url, String username, String password) {

        java.sql.Connection conn = linktodata();
        

        String todo = "INSERT into envtool.envdetails" +
                "(`release`,`env`,`ip`,`url`,`username`,`password`)"+
                "values"+" ('"+release+"','"+env+"','"+ip+"','"+url+"','"+username+"','"+password+"')";

        try {
                java.sql.Statement s = conn.createStatement();
                int r = s.executeUpdate (todo);
        }
        catch (Exception e) {
                return ("Oh oops - code 003\n"+e);
                }

        return (todo);

        }

public static String select(String name, String group, String yearborn) {

        java.sql.Connection conn = linktodata();

        StringBuffer reply = new StringBuffer("<table border=1>");

        StringBuffer conditions = new StringBuffer("where ");

        if (! group.equals("")) {
                conditions.append("ethnicorigin = '"+group+"'") ;
                }
        if (! name.equals("")) {
                if (conditions.length() > 6) {
                        conditions.append(" && ");
                        }
                conditions.append("fullname = '"+name+"'") ;
                }

        String selector = null;
        if (conditions.length() > 6) {
                selector = conditions.toString();
        } else {
                selector = "";
        }

        String todo = ("SELECT id, fullname, born, ethnicorigin "+
                " from population " + selector);

        try {
                java.sql.Statement s = conn.createStatement();
                java.sql.ResultSet r = s.executeQuery (todo);
                while(r.next()) {
                        reply.append("<tr>");
                        reply.append(tabit(r.getString("id")));
                        reply.append(tabit(r.getString("ethnicorigin")));
                        reply.append(tabit(r.getString("fullname")));
                        reply.append(tabit(r.getString("born")));
                        reply.append("</tr>");
                        }
                reply.append("</table>");
                }
        catch (Exception e) {
                return ("Oh oops - code 003\n"+e);
                }

        return (reply.toString());

        }

private static String tabit(String box) {
        return ("<td>"+box+"</td>");
        }

private static java.sql.Connection linktodata () {

        java.sql.Connection conn = null;
        try {
                Class.forName("org.gjt.mm.mysql.Driver").newInstance();
                }
        catch (Exception e) {
                return conn;
                // return "Oh dear - code 001 and a quarter";
                }
        try {
                conn = java.sql.DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/envtool?user=root&password=");
        }
        catch (Exception e) {
                //return conn;
              System.out.println("Oh dear - code 001 and a half");
              System.out.println(conn);
              }
        return conn;
}

public static void main(String args[])
{
  String res= insert("3a","ui","127.0.0.1","www.abc.com","abc","abc");
  System.out.println(res);
}
}
