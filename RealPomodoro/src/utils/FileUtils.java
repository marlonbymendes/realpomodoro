package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {

	
	public String getStringInResourcesFile(String fileName) throws FileNotFoundException {  
	  FileInputStream inputStream = null;  
	  StringBuilder stringInFile = new StringBuilder();
	    
	  try { 
		  final ClassLoader classLoader = this.getClass().getClassLoader();    
	   
		  final String filePath = "resources/" + fileName;
		  final File file = new File(classLoader.getResource(filePath).getFile());  
	    
		  inputStream = new FileInputStream(file);  
	   
		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));  
		  while (true) {
			  final String nextLine = reader.readLine();
			  if(nextLine == null) {
				  break;
			  }
			  stringInFile.append(nextLine + "\n");  
		  }
		  reader.close();  
	  } catch (IOException e) {
		  System.out.println("Can't read file " + fileName); 
	  }  
	  finally {  
		  try {
			  inputStream.close();
		  }
		  catch(IOException exception) {
			  System.out.println("Can't read file " + fileName);
		  }
	  }
	  
	  return stringInFile.toString();
	}
}
