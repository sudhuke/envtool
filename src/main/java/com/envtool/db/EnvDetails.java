package com.envtool.db;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.impl.SQLQueryImpl;


public class EnvDetails {
    private int id;
    private Date date;
    private String url,release,env,ip,username,password;

    public EnvDetails() {}

    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRelease() {
        return release;
    }
    
    public void setRelease( String release ) {
       this.release = release;
    }

    public String getEnv() {
        return env;
    }
    public void setEnv(String env) {
        this.env = env;
    }
    
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   	
    public static boolean InsertEnvDetails(String release,String env,String ip,String url,String username,String password){
    		Session session = null;

    		try{
    			// This step will read hibernate.cfg.xml and prepare hibernate for use
    			SessionFactory sessionFactory = new Configuration().addResource("EnvDetails.hbm.xml").buildSessionFactory();
    		    	//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    		    	session =sessionFactory.openSession();
    				//Create new instance of Contact and set values in it by reading them from form object
    			 	System.out.println("Inserting Record");
    				EnvDetails ed = new EnvDetails();
    				//ed.setId(1);
    				ed.setDate(new Date());
    				ed.setRelease(release);
    				ed.setEnv(env);
    				ed.setIp(ip);
    				ed.setUrl(url);
    				ed.setUsername(username);
    				ed.setPassword(password); 
    				//System.out.println(toString(ed));
    				session.save(ed);
    				session.beginTransaction().commit();
    				System.out.println("Done");
    				session.flush();
    	    			session.close();
    	    			return true;
    		}catch(Exception e){
    			System.out.println(e.getMessage());
    			return false;
    		}
    	    			
    		
    	}
    
    public static ArrayList viewEnvDetails(){
	Session session=null;
	SessionFactory sessionFactory = new Configuration().addResource("EnvDetails.hbm.xml").buildSessionFactory();
	    	//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    	       session =sessionFactory.openSession();
			//Create new instance of Contact and set values in it by reading them from form object
		 	System.out.println("Retrieving Record");
			String SQL_QUERY ="select * from  envdetails";
			//SQLQuery q = session.createSQLQuery("select * from  envdetails");
			/*String classname = new String("EnvDetails.class");
			SQLQuery query = q.addEntity(classname);*/
			SQLQuery query = session.createSQLQuery(SQL_QUERY).addScalar("release_name",Hibernate.STRING).addScalar("env",Hibernate.STRING).addScalar("ip",Hibernate.STRING).addScalar("url",Hibernate.STRING).addScalar("username",Hibernate.STRING).addScalar("password",Hibernate.STRING);
		 	 
		 	 ArrayList list= (ArrayList)query.list();
		 	 if (list.size() != 0)
		 	 {
		 	     System.out.println("Total No of records found is"+list.size());
		 	 }
		 	/********Working Code
		 	 System.out.println(list.size());
		 	 	 	
		 	for(int i=0;i<list.size();i++)
		 	{
		 	   Object[] o = (Object[]) list.get(i);
		 	  for(int j=0;j<o.length;j++)
		 	   System.out.println("Value :"+ o[j].toString());
		         }*/

		 	/*for(Iterator it=query.iterate();it.hasNext();){
		 	          Object[] row = (Object[]) it.next();
		 	          System.out.println("release_name: " + row[0]);
		 	          System.out.println("env: " + row[2]);
		 	          System.out.println("IP: " + row[3]);
		 	          System.out.println("url: " + row[4]);
		 	          System.out.println("username: " + row[5]);
		 	          System.out.println("password: " + row[6]);
		 	        }*/
			//System.out.println(toString(ed));
			session.flush();
			session.close();
			return list;
	
	
    }

    /*private static char[] toString(EnvDetails ed) {
	// TODO Auto-generated method stub
	return null;
    }*/
    }
