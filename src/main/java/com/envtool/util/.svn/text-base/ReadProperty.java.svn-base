import java.io.*;
import java.util.*;

  class ReadProperty
  {
           public static void main(String[] args) {
	    Properties pro = new Properties();
	    try{
	      FileInputStream in = new FileInputStream("iprange.properties");
	      pro.load(in);
	      final ResourceBundle rb = ResourceBundle.getBundle ("iprange");
	       System.out.println(rb);
	      System.out.println("All keys of the property file : ");
	      //System.out.println(pro.keySet());
	      System.out.println("All values of the property file : ");
	      Enumeration em = rb.getKeys();
	      while (em.hasMoreElements()){
	        String str = (String)em.nextElement();
	        if(rb.getString(str).length() != 0){
	        System.out.println(rb.getString(str));
	        }
	      }
	    }
	   
     catch(IOException e){
    System.out.println(e.getMessage());
    }
  }
      }
