package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import view.Home;

public class Main {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
		
		Home home = new Home();
		home.show();
		
		final String fileName = "file_test.txt";
		
		  Main rp=new Main();  
		  System.out.println("Reading file from resources folder");  
		  System.out.println("-----------------------------");  
		  
		  rp.readFile(fileName);  
		    
		  System.out.println("-----------------------------");  
	}
	
	public  void readFile(String fileName) throws IOException  
	 {  
	  FileInputStream inputStream=null;  
	    
	  try {  
	   // Getting ClassLoader obj  
	   ClassLoader classLoader = this.getClass().getClassLoader();  
	   // Getting resource(File) from class loader  
	   
	   final String filePath = "resources/" + fileName;
	   File configFile=new File(classLoader.getResource(filePath).getFile());  
	    
	   inputStream = new FileInputStream(configFile);  
	   
	   BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));  
	   String line;  
	   while ((line = reader.readLine()) != null) {  
	   System.out.println(line);  
	   }  
	   
	   reader.close();  
	  
	  
	  } catch (FileNotFoundException e) {  
	  
	   e.printStackTrace();  
	  }catch (IOException e) {  
	  
	   e.printStackTrace();  
	  }  
	  finally {  
	   inputStream.close();  
	  }  
	  
	    
	 }
}
